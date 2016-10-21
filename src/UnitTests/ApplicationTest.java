package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Tools.ManageApplication;
import Tools.ManageJob;
import model.Bpapplication;

public class ApplicationTest {

	@Test
	public void test() {

		
		Bpapplication application = new Bpapplication();
		
		application.setFullname("John Doe");
		application.setEmail("johndoe@test.com");
		application.setAddress("Test Address");	
		application.setBirthday("21 October 1900" );
		application.setEducation("Engineer");
		application.setJobhistory("IPS");
		application.setReferences("fake reference");
		application.setDruguse("No");
		application.setVeteran("Yes");
		application.setCitizenship("Australian");
		application.setBpjob(ManageJob.getjob(1));
		application.setStatus("Processing");		
		
		ManageApplication.add(application);
		System.out.println("Application Added!");
		
		
		
	}

}
