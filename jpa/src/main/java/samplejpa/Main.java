package samplejpa;

import java.util.*;
import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Engine instantiation:");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            "$objectdb/db/samplejpa.odb");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Clearing database:");
        em.createQuery("DELETE FROM SystemUser").executeUpdate();
        em.createQuery("DELETE FROM Departament").executeUpdate();

        System.out.println("Two objects created with 1-N association:");
        Departament d = new Departament();
        d.departamentName = "Dept1";
        em.persist(d);
        SystemUser u = new SystemUser();
        u.systemUserName = "User1";
        u.department = d;
        em.persist(u);

        System.out.println("Querying database:");
        TypedQuery<Departament> dq = em.createQuery("SELECT D FROM Departament D", Departament.class);
        for (Departament d2: dq.getResultList()) {
            System.out.println("Loaded: " + d2);
        }
        TypedQuery<SystemUser> sq = em.createQuery("SELECT S FROM SystemUser S", SystemUser.class);
        for (SystemUser s: sq.getResultList()) {
            System.out.println("Loaded: " + s);
        }

        em.getTransaction().commit();
    }
}


