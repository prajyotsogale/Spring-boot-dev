package com.cruddemo.demo;

import com.cruddemo.demo.dao.AppDao;
import com.cruddemo.demo.entity.Instructor;
import com.cruddemo.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao){

        return runner ->{
            //createInstructor(appDao);
            //createMultipleInstructor(appDao);
            //findInstructor(appDao);
            deleteInstructor(appDao);
        };
    }

    private void deleteInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("deleting the instructor by id: "+id);
        appDao.deleteInstructorById(id);
    }

    private void findInstructor(AppDao appDao) {
        int id = 1;
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("The instructor with the id: "+id+" is "+instructor);

    }

    private void createMultipleInstructor(AppDao appDao) {
        Instructor instructor1 = new Instructor("Madhu", "Patel", "madhu@gmail.com");
        InstructorDetail instructorDetail = new
                InstructorDetail("www.yt.com/madhu", "gaming");
        instructor1.setInstructorDetail(instructorDetail);
        System.out.println("saving the instructor: "+instructor1);
        appDao.save(instructor1);

        Instructor instructor2 = new Instructor("Satoro", "Gojo", "satoro@gmail.com");
        InstructorDetail instructorDetail2 = new
                InstructorDetail("www.yt.com/satoro", "watching anime");
        instructor2.setInstructorDetail(instructorDetail2);
        System.out.println("saving the instructor: "+instructor2);
        appDao.save(instructor2);

        Instructor instructor3 = new Instructor("naruto", "us", "naruto@gmail.com");
        InstructorDetail instructorDetail3 = new
                InstructorDetail("www.yt.com/naruto", "anime");
        instructor3.setInstructorDetail(instructorDetail3);
        System.out.println("saving the instructor: "+instructor3);
        appDao.save(instructor3);

    }

    private void createInstructor(AppDao appDao) {
        Instructor instructor  =new Instructor("Chad", "derby", "chad@gmail.com");
        InstructorDetail instructorDetail =
                new InstructorDetail("www.youtube.com/chadd", "playing games");
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("saving the instructor: "+instructor);
        appDao.save(instructor);
    }

}
