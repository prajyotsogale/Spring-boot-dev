package com.cruddemo.demo;

import com.cruddemo.demo.dao.AppDao;
import com.cruddemo.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao){

        return runner ->{
            //createCourseAndStudents(appDao);
            //findCourseAndStudents(appDao);
            //findStudentAndCourses(appDao);
            //addMoreCoursesToStudent(appDao);
            //deleteCourseById(appDao);
            deleteStudent(appDao);
        };
    }

    private void deleteStudent(AppDao appDao) {
        int id = 1;
        appDao.deleteStudentById(id);
    }

    private void addMoreCoursesToStudent(AppDao appDao) {
        int id = 2;
        Student student = appDao.findStudentAndCoursesByStudentId(id);
        Course course = new Course("rubix cube solving");
        Course course2 = new Course("game dev");
        student.add(course2);
        student.add(course);
        appDao.update(student);
        System.out.println("done");
    }

    private void findStudentAndCourses(AppDao appDao) {
        int id = 2;
        Student student = appDao.findStudentAndCoursesByStudentId(id);
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    private void findCourseAndStudents(AppDao appDao) {
        int id = 10;
        Course course = appDao.findCourseAndStudentsByCourseId(id);
        System.out.println("the course is: "+course);
        System.out.println(course.getStudents());
    }

    private void createCourseAndStudents(AppDao appDao) {
        Course course = new Course("Pacman");
        Student student1 = new Student("Marko","rubio","mark@gmail.com");
        Student student2 = new Student("Marko","zuckerburg","mz@gmail.com");
        course.add(student1);
        course.add(student2);
        System.out.println("saving the course: "+course);
        System.out.println("associate students are: "+course.getStudents());
        appDao.save(course);
        System.out.println("Done");
    }

    private void deleteCoursesAndReviews(AppDao appDao) {
        int id = 10;
        appDao.deleteCourseById(id);

    }

    private void retrieveCourseAndReviews(AppDao appDao) {
        int id = 10;
        System.out.println("Retrieving courses and reviews by course id: "+id);
        Course course = appDao.findCourseAndReviewsByCourseId(id);
        System.out.println("The course is: "+course);
        System.out.println("reviews: "+course.getReviews());
        System.out.println("done");
    }

    private void createCoursesAndReviews(AppDao appDao) {
        Course course = new Course("pacman");
        course.add(new Review("great"));
        course.add(new Review("fun"));
        course.add(new Review("love it"));
        System.out.println("saving the course");
        appDao.save(course);
        System.out.println("Done");
    }

    private void deleteCourseById(AppDao appDao) {
        int id = 11;
        System.out.println("Deleting the course by id: "+id);
        appDao.deleteCourseById(id);
    }

    private void updateCourse(AppDao appDao) {
        int id = 10;
        System.out.println("finding course by id: "+id);
        Course course = appDao.findCourseById(id);
        System.out.println("course is: "+course);
        course.setTitle("pokemon catching");
        System.out.println("updating course");
        appDao.updateCourse(course);
        System.out.println("done");

    }

    private void updateInstructor(AppDao appDao) {
        int id = 1;
        Instructor instructor = appDao.findInstructorById(id);
        instructor.setLastName("doe");
        appDao.update(instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        int id = 1;
        System.out.println("finding the instructor with id: "+id);
        Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

        System.out.println("the instructor: "+instructor);
        System.out.println("the associate courses : "+instructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("finding instructor with id: "+id);
        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("The instructor is: "+instructor);

        List<Course> list = appDao.findCoursesByInstructorId(id);
        instructor.setCourses(list);
        System.out.println("The associated courses are: "+instructor.getCourses());
        System.out.println("done");

    }

    private void findInstructorWithCourses(AppDao appDao) {
        int id = 1;
        System.out.println("finding instructor with id: "+id);
        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("The instructor is: "+instructor);
        System.out.println("The associated courses are: "+instructor.getCourses());
        System.out.println("done");

    }

    private void createInstructorWithCourses(AppDao appDao) {
        Instructor instructor = new Instructor("John", "doe", "john@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("www.yt.com/john", "playing");
        instructor.setInstructorDetail(instructorDetail);
        Course course = new Course("Java");
        Course course1 = new Course("Python");
        instructor.add(course);
        instructor.add(course1);

        System.out.println("saving the instructor: "+instructor);
        System.out.println("Courses are: "+instructor.getCourses());
        appDao.save(instructor);
        System.out.println("done");

    }

    private void deleteInstructorDetail(AppDao appDao) {
        int id = 2;
        System.out.println("Deleting instructor detail by id: "+id);
        appDao.deleteInstructorDetailById(id);
    }

    private void findInstructorDetail(AppDao appDao) {
        int id = 2;
        System.out.println("id: "+id);
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
        System.out.println("instructor Detail: "+instructorDetail);
        System.out.println("associated instructor is: "+instructorDetail.getInstructor());
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
