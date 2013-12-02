package samplejpa;

import java.lang.*;
import java.io.*;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity @Table(name = "Departament")
class Departament {

    @Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer departmentId;

    @Column
    public String departamentName;

    public String toString() {
        return "Departament(" + departamentName + ")";
    }
}


