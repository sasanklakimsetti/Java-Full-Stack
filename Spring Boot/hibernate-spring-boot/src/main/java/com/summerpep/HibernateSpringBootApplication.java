package com.summerpep;

import com.summerpep.algo.PasswordAlgo;
import com.summerpep.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
		Student student=em.find(Student.class,101);
		System.out.println(student);
	}
}
