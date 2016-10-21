package UnitTests;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import Tools.ManageApplication;
import Tools.ManageEmployer;
import Tools.ManageJob;
import Tools.HashPassword;
import model.Bpapplication;
import model.Bpemployer;
import model.Bpjob;

public class InsertEmployers {
	@Test
	public void insert() {
		
		Bpemployer employer = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("c@d.com", "password"));
		employer.setName("Ram");
		employer.setRole("complianceofficer");
		ManageEmployer.add(employer);
		
		Bpemployer employer1 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("ha@d.com", "password"));
		employer.setName("Sam");
		employer.setRole("hrassistant");
		ManageEmployer.add(employer1);
		
		Bpemployer employer2 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("hs@d.com", "password"));
		employer.setName("Tom");
		employer.setRole("hrspecialist");
		ManageEmployer.add(employer2);
		
		Bpemployer employer3 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("hcs@d.com", "password"));
		employer.setName("Jack");
		employer.setRole("healthcarespecialist");
		ManageEmployer.add(employer3);
		
		Bpemployer employer4 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("hm@d.com", "password"));
		employer.setName("John");
		employer.setRole("hrmanager");
		ManageEmployer.add(employer4);
		
		Bpemployer employer5 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("him@d.com", "password"));
		employer.setName("oliver");
		employer.setRole("hiringmanager");
		ManageEmployer.add(employer5);
		
		Bpemployer employer6 = new Bpemployer();
		employer.setEmail("c@d.com");
		employer.setHashpassword(HashPassword.Hash("il@d.com", "password"));
		employer.setName("caramel");
		employer.setRole("interviewleader");
		ManageEmployer.add(employer6);
		// assertTrue(hash ==
		// "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
