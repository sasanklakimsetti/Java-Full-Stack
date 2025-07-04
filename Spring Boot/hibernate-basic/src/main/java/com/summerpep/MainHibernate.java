package com.summerpep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class MainHibernate {
    public static void main(String[] args){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Student");
        EntityManager em=emf.createEntityManager();
        Student student = em.find(Student.class,101);
        System.out.println(student);
        Student s1=new Student("Yuvaraj","CSE","8978987389", Date.valueOf("2004-11-14"), 85, Student.Gender.male);
        em.close();
        emf.close();
    }
}
