package com.masai.Mapping1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    // Create EntityManagerFactory
    static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Raushan");
    }

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create companies
        Company samsung = new Company();
        samsung.setCompanyName("Samsung");
        samsung.setESTDYear(1938);

        Company nokia = new Company();
        nokia.setCompanyName("Nokia");
        nokia.setESTDYear(1865);

        // Create mobiles for Samsung
        Mobile mobile1 = new Mobile();
        mobile1.setModelNumber("M31");
        mobile1.setPrice(13400.0);
        mobile1.setCompany(samsung);
        samsung.getMobiles().add(mobile1);

        Mobile mobile2 = new Mobile();
        mobile2.setModelNumber("A31");
        mobile2.setPrice(21400.0);
        mobile2.setCompany(samsung);
        samsung.getMobiles().add(mobile2);

        // Create mobiles for Nokia
        Mobile mobile3 = new Mobile();
        mobile3.setModelNumber("M6610");
        mobile3.setPrice(16542.0);
        mobile3.setCompany(nokia);
        nokia.getMobiles().add(mobile3);

        Mobile mobile4 = new Mobile();
        mobile4.setModelNumber("GenZ");
        mobile4.setPrice(21587.0);
        mobile4.setCompany(nokia);
        nokia.getMobiles().add(mobile4);

        // Persist the companies
        em.persist(samsung);
        em.persist(nokia);

        // Commit the transaction
        em.getTransaction().commit();

        // Query mobile details
        List<Mobile> mobiles = em.createQuery(
                "SELECT m FROM Mobile m JOIN FETCH m.company",
                Mobile.class
        ).getResultList();

        for (Mobile mobile : mobiles) {
            String modelNumber = mobile.getModelNumber();
            double price = mobile.getPrice();
            String companyName = mobile.getCompany().getCompanyName();

            String message = "The " + modelNumber + " of INR " + price + " is made by " + companyName + ".";
            System.out.println(message);
        }

        // Close EntityManager
        em.close();
        emf.close();
    }
}