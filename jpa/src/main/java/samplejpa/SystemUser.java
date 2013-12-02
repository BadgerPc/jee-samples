package samplejpa;

import java.lang.*;
import java.io.*;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
class SystemUser implements Serializable {

    @Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer userId;

    @Column
    public String systemUserName;

    @Column
    public Departament department;

    public String toString() {
        return "SystemUser(" + systemUserName + ", " + department + ")";
    }
}


