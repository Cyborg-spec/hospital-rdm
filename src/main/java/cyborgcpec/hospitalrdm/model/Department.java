package cyborgcpec.hospitalrdm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @Column(name = "department_id")
    private long departmentId;

    @Column(name = "department_name")
    private String departmentName;
}
