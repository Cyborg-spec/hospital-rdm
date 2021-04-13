package cyborgcpec.hospitalrdm.controller;

import cyborgcpec.hospitalrdm.dto.*;
import cyborgcpec.hospitalrdm.exceptions.Problem.ProblemTypeNotFoundException;
import cyborgcpec.hospitalrdm.exceptions.doctor.DoctorNotFoundException;
import cyborgcpec.hospitalrdm.exceptions.medicament.MedicamentNotFoundException;
import cyborgcpec.hospitalrdm.exceptions.patient.PatientNotFoundException;
import cyborgcpec.hospitalrdm.mappers.EntityToDTOConverter;
import cyborgcpec.hospitalrdm.model.*;
import cyborgcpec.hospitalrdm.model.composite_keys.PatientMedicamentId;
import cyborgcpec.hospitalrdm.model.composite_keys.PatientProblemId;
import cyborgcpec.hospitalrdm.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @Autowired
    private PatientApparatusService patientApparatusService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private PatientProblemService patientProblemService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private PatientMedicamentService patientMedicamentService;

    @Autowired
    private PatientBillHistoryService patientBillHistoryService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ApparatusService apparatusService;

    @GetMapping("/patient/{id}")
    public ResponsePatientDTO getPatientById(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isPresent()) {
            return entityToDTOConverter.patientToPatientDTO(patient.get());
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @GetMapping("/patient/{id}/apparatuses")
    public Set<ApparatusDTO> getPatientApparatuses(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isPresent()) {
            Set<Apparatus>apparatuses=apparatusService.findByPatientId(id);
            return entityToDTOConverter.apparatusToApparatusDTO(apparatuses);
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @GetMapping("/patient/status")
    public StatusDTO patientStatus(@RequestBody RequestPatientDTO requestPatientDTO) throws PatientNotFoundException {
        //Todo there are can be several patients with this name and lastname
        Patient patient = patientService.findByFirstNameAndLastName(requestPatientDTO.getFirstName(), requestPatientDTO.getLastName());
        if (patient != null) {
            return entityToDTOConverter.statusToStatusDTO(patient.getStatus());
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @PostMapping("/patient/new-patient")
    public ResponsePatientDTO newPatient(@RequestBody NewPatientDTO newPatientDTO) throws DoctorNotFoundException {
        try {
            //Todo create map with symptoms to find doctor by symptom
            DoctorType doctorType = DoctorType.valueOf(newPatientDTO.getIllType());
            Set<Doctor> doctors = doctorService.findByDoctorType(doctorType.ordinal());

            if (!doctors.isEmpty()) {
                Patient patient = new Patient();
                patient.setFirstName(newPatientDTO.getFirstName());
                patient.setLastName(newPatientDTO.getLastName());
                patient.setStatus(Status.UNDEFINED);
                Doctor availableDoctor = null;

                for (Doctor doctor : doctors) {
                    if (doctor.getPatients().size() <= 3) {
                        availableDoctor = doctor;
                        break;
                    }
                }
                patient.setDoctor(Objects.requireNonNullElseGet(availableDoctor, () -> doctors.stream().findAny().get()));
                //TODO change the logic of finding room
                patient.setRoom(roomService.findByDoctor(patient.getDoctor()));
                patientService.save(patient);
                return entityToDTOConverter.patientToPatientDTO(patient);
            } else {
                throw new DoctorNotFoundException("Doctor for this patient not found");
            }
        } catch (IllegalArgumentException e) {
            throw new DoctorNotFoundException("No such doctor type for this ill");
        }
    }

    @PostMapping("/patient/new-problem")
    public ResponseEntity<Object> patientNewProblem(@RequestBody PatientNewProblemDTO patientNewProblemDTO) throws ProblemTypeNotFoundException, PatientNotFoundException {
        //Todo there are can be several patients with this name and lastname
        Patient patient = patientService.findByFirstNameAndLastName(patientNewProblemDTO.getFirstName(), patientNewProblemDTO.getLastName());
        if (patient != null) {
            Set<String> problemNames = patientNewProblemDTO.getProblems().stream().map(ProblemDTO::getProblemName).collect(Collectors.toSet());
            Set<Problem>problems=problemService.findByProblemNames(problemNames);
            if (!problems.isEmpty()) {
                long patientId = patient.getPatientId();

                for (Problem problem : problems) {
                    PatientProblemId patientProblemId = new PatientProblemId();
                    patientProblemId.setPatientId(patientId);
                    patientProblemId.setProblemId(problem.getProblemId());

                    PatientProblem patientProblem = new PatientProblem();
                    patientProblem.setProblem(problem);
                    patientProblem.setPatient(patient);
                    patientProblem.setPatientProblemId(patientProblemId);

                    patientProblemService.save(patientProblem);
                }
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new ProblemTypeNotFoundException("This problem type(s) not found");
            }
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @GetMapping("/patient/{id}/problems")
    public Set<ProblemDTO> getPatientProblems(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isPresent()) {
            Set<Problem> patientProblems = problemService.findByPatient(id);
            return entityToDTOConverter.problemToProblemDTO(patientProblems);
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @PutMapping("/patient/status-update")
    public String updatePatientStatus(@RequestBody PatientStatusUpdateRequestDTO patientStatusUpdateRequestDTO) throws PatientNotFoundException {
        //Todo there are can be several patients with this name and lastname
        Patient patient = patientService.findByFirstNameAndLastName(patientStatusUpdateRequestDTO.getFirstName(),patientStatusUpdateRequestDTO.getLastName());
        if (patient!=null) {
            patient.setStatus(Status.valueOf(patientStatusUpdateRequestDTO.getStatus()));
            patientService.save(patient);
            return "status updated";
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @PostMapping("/patient/used-medicament/add")
    public String updatePatientUsedMedicament(@RequestBody PatientUsedMedicamentUpdateRequestDTO patientUsedMedicamentUpdateRequestDTO) throws MedicamentNotFoundException, PatientNotFoundException {
        //Todo there are can be several patients with this name and lastname
        Patient patient = patientService.
                findByFirstNameAndLastName(patientUsedMedicamentUpdateRequestDTO.getFirstName(), patientUsedMedicamentUpdateRequestDTO.getLastName());
        if (patient != null) {
            Set<String> medicamentNames = patientUsedMedicamentUpdateRequestDTO.getUsedMedicament().stream().map(MedicamentDTO::getMedicamentName).collect(Collectors.toSet());
            Set<Medicament>medicaments=medicamentService.findByMedicamentNames(medicamentNames);
            if (!medicaments.isEmpty()) {
                long patientId = patient.getPatientId();
                for (Medicament medicament : medicaments) {
                    PatientMedicamentId patientMedicamentId = new PatientMedicamentId();
                    patientMedicamentId.setPatientId(patientId);
                    patientMedicamentId.setMedicamentId(medicament.getMedicamentId());
                    PatientMedicament patientMedicament = new PatientMedicament();
                    patientMedicament.setPatientMedicamentId(patientMedicamentId);
                    patientMedicament.setMedicament(medicament);
                    patientMedicament.setPatient(patient);
                    patientMedicament.setUsedQuantity(patientUsedMedicamentUpdateRequestDTO.getQuantity());
                    patientMedicamentService.save(patientMedicament);
                }
            }else {
                throw new MedicamentNotFoundException("Medicament(s) with this name(s) not found");
            }
        }else {
            throw new PatientNotFoundException("Patient not found");
        }
        return "patient used medicaments saved";
    }
    @DeleteMapping("/patient/{id}/patient-releasing")
    public String patientReleasing(@PathVariable long id) throws PatientNotFoundException {
        Optional<Patient>patient=patientService.findById(id);
        if(patient.isPresent()){
           long billPrice=0;
           Set<Medicament>medicaments=medicamentService.findByPatientId(id);
           if(!medicaments.isEmpty()) {
               //TODO another bill price counting system
               billPrice = medicaments.stream().mapToLong(Medicament::getMedicamentPrice).sum();
           }
           PatientBillHistory patientBillHistory=new PatientBillHistory();
           patientBillHistory.setFirstName(patient.get().getFirstName());
           patientBillHistory.setLastName(patient.get().getLastName());
           patientBillHistory.setBillPrice(billPrice);
           patientBillHistoryService.save(patientBillHistory);
           patientService.delete(patient.get());
           return "Patient deleted successfully";
        }else {
            throw new PatientNotFoundException("Patient not found");
        }
    }
    @GetMapping("/patient/{id}/used-medicament")
    public List<PatientUsedMedicamentDTO> getPatientUsedMedicaments(@PathVariable long id) throws PatientNotFoundException {
       Optional<Patient> patient=patientService.findById(id);
        if(patient.isPresent()){
         List<PatientUsedMedicamentDTO>patientUsedMedicaments=patientMedicamentService.getPatientUsedMedicamentByPatientId(id);
         return patientUsedMedicaments;
        }else {
            throw new PatientNotFoundException("patient not found");
        }
    }
}

