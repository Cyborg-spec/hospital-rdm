package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_bill")
@Data
public class PatientBill {
    @Id
    @Column(name = "bill_id")
    private long billId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
