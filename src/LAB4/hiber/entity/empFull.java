package LAB4.hiber.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@Entity
@Table(name = "\"empFull\"")
public class empFull implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "f_name")
    private String f_name;

    @Column(name= "l_name")
    private String l_name;

    @Column(name= "special")
    private String special;

    @Column(name= "area")
    private int area;

    @Column(name= "salary")
    private double salary;


    @ManyToOne(fetch = FetchType.LAZY)
    private department department;




}
