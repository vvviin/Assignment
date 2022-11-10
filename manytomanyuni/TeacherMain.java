package com.tyss.manytomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeacherMain {


		// TODO Auto-generated method stub
		public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			Student student1 = new Student();
			student1.setName("Sonu");
			student1.setAge(10);
			student1.setStandard("Fifth");

			Student student2 = new Student();
			student2.setName("Monu");
			student2.setAge(8);
			student2.setStandard("Fourth");

			Student student3 = new Student();
			student3.setName("Suraj");
			student3.setAge(5);
			student3.setStandard("Second");

			Teacher t1 = new Teacher();
			t1.setName("Shiv");
			t1.setGender("Male");
			t1.setSubject("Science");
			List<Student> list1 = new ArrayList<Student>();
			list1.add(student1);
			list1.add(student3);
			t1.setStudent(list1);

			Teacher t2 = new Teacher();
			t2.setName("Arun");
			t2.setGender("Male");
			t2.setSubject("Math");
			List<Student> list2 = new ArrayList<Student>();
			list2.add(student1);
			list2.add(student2);
			t2.setStudent(list2);
			
			List<Teacher>ls1=new ArrayList<Teacher>();
			ls1.add(t2);
			ls1.add(t1);
			
			student1.setTeacher(ls1);
			student2.setTeacher(ls1);
	         student3.setTeacher(ls1);
	         
			entityTransaction.begin();
			entityManager.persist(student1);
			entityManager.persist(student2);
			entityManager.persist(student3);
			entityManager.persist(t1);
			entityManager.persist(t2);

			entityTransaction.commit();

		}

	}


