package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_bill_history")
@Data
public class PatientBillHistory {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(generator = "patient_bill_id_gen")
    @SequenceGenerator(name = "patient_bill_id_gen",sequenceName = "patient_bill_id_seq",allocationSize = 1)
    private long billId;

    @Column(name = "patient_first_name")
    private String firstName;

    @Column(name = "patient_last_name")
    private String lastName;

    @Column(name = "bill_price")
    private long billPrice;
}
