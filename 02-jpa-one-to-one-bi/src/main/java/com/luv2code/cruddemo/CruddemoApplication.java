package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetails;
import com.luv2code.cruddemo.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
		    //  createInstructor(appDao);
		    //  findThatInstructor(appDao);
              deleteInstructor(appDao);
			//  findInstructorDetails(appDao);
			//  deleteDetailsById(appDao);

		};
	}

	private void deleteDetailsById(AppDao appDao) {
		int theId=2;
		System.out.println("deleting instructor details with id :"+theId);
		appDao.deleteInstructorDetailsById(theId);
		System.out.println("done");

	}

	private void findInstructorDetails(AppDao appDao) {
		int theId=2;
		InstructorDetails tempInstructorDetails = appDao.findDetailsById(theId);
		System.out.println("details of instructor with id "+theId+" is: " +tempInstructorDetails);
		System.out.println("associated instructor: "+tempInstructorDetails.getInstructor());
		System.out.println("done");
	}

	private void deleteInstructor(AppDao appDao) {
		int theId=2;
		System.out.println("deleting the instructor with id: "+theId);
		appDao.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findThatInstructor(AppDao appDao) {
		int theId=2;
		System.out.println("finding instructor by id : "+theId);
		Instructor tempInstructor=appDao.findById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructor details are : "+tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDao appDao) {

		//create the instructor
		Instructor tempInstructor=new Instructor("chad","darby","darby1234@gmail.com");

		//create the instructor details
		InstructorDetails tempInstructionDetails = new InstructorDetails(
				"http://www.luv2code.com",
				"coding"
		);

 /*


		//create the instructor
		Instructor tempInstructor=new Instructor("MADHU","PATEL","maddy1234@gmail.com");

		//create the instructor details
		InstructorDetails tempInstructionDetails = new InstructorDetails(
				"http://www.luv2code.com",
				"dancing"
		);
*/
		//associate the objects
		tempInstructor.setInstructorDetails(tempInstructionDetails);

		//saving the instructor and this will also save the instructor details
		// as the instructor and instructor details are cascasded
		System.out.println("saving the instructor :"+tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("done dona done");
	}


}
