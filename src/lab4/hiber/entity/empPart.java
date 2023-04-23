package lab4.hiber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter

public class empPart implements Serializable {
@Id
@GeneratedValue ( strategy = GenerationType.IDENTITY)
private long id;
private String f_name;
private String l_name;
private String special;
private int area;
private double salary;
private String contract;
}
