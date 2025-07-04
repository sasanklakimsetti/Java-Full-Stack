package com.summerpep;

import com.summerpep.algo.PasswordAlgo;
import com.summerpep.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class HibernateSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(HibernateSpringBootApplication.class);
		PasswordAlgo algo=context.getBean(PasswordAlgo.class);  // spring has created an object of PasswordAlgo for us using getBean
		// Bean is called object in Spring
		String rev=algo.encrypt("Password@SpringBoot");
		System.out.println(rev);

		// we are retrieving the data about what objects have been created when we run the Main class
		String[] beans=context.getBeanDefinitionNames();
		for (String beanName: beans) System.out.println(beanName);

		testStudent(context);
	}
	public static void testStudent(ConfigurableApplicationContext context){
		// datasource, entityManagerFactory
		EntityManagerFactory emf=context.getBean(EntityManagerFactory.class);
		EntityManager em=emf.createEntityManager();
		Student student=em.find(Student.class,0);
		System.out.println(student);
		student.setSname("Arjun");
		em.getTransaction().begin();
		System.out.println(student);
//		em.remove(student);
//		System.out.println(student);
		Student s1=new Student(115,"Karthik","CSE","8919578542", Date.valueOf("2005-05-29"), 100, Student.Gender.male);
		em.persist(s1);
		// persist means save
//		Query query=em.createQuery("select s from Student");
//		query.getResultList().forEach(System.out::println);
		em.getTransaction().commit();
		// commit the changes until made
		em.close();
	}
}
