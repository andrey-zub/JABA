package LAB4.hiber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter

@Entity
public class department implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="dep_name")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<empFull> employee = new ArrayList<>();

    public void setEmployee(List<empFull> employee) {
        this.employee = employee;

        for (empFull el : employee){
            el.setDepartment(this);
        }
    }
}
