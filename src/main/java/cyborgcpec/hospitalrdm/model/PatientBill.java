package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_bill")
@Data
public class PatientBill {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(generator = "patient_bill_id_gen")
    @SequenceGenerator(name = "patient_bill_id_gen",sequenceName = "patient_bill_id_seq",allocationSize = 1)
    private long billId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "bill_price")
    private long billPrice;
}
