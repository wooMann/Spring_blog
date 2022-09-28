package com.example.spring_blog.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("spring_blog");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                closeEntityManagerFactory();
            }
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        try {
            entityManagerFactory.close();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("HibernateUtil Connection Error");
        }
    }
}
