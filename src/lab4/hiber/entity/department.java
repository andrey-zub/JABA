package lab4.hiber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter

@Entity
@Table(name = "\"department\"")
public class department implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="dep_name")
    private String name;

    @Column(name = "emp_id")
    private Long empid;


}
