package UnitTests;

import org.junit.Test;

import Tools.ManageEmployer;
import Tools.HashPassword;
import model.Bpemployer;

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
		employer1.setEmail("ha@d.com");
		employer1.setHashpassword(HashPassword.Hash("ha@d.com", "password"));
		employer1.setName("Sam");
		employer1.setRole("hrassistant");
		ManageEmployer.add(employer1);

		Bpemployer employer2 = new Bpemployer();
		employer2.setEmail("hs@d.com");
		employer2.setHashpassword(HashPassword.Hash("hs@d.com", "password"));
		employer2.setName("Tom");
		employer2.setRole("hrspecialist");
		ManageEmployer.add(employer2);

		Bpemployer employer3 = new Bpemployer();
		employer3.setEmail("hcs@d.com");
		employer3.setHashpassword(HashPassword.Hash("hcs@d.com", "password"));
		employer3.setName("Jack");
		employer3.setRole("healthcarespecialist");
		ManageEmployer.add(employer3);

		Bpemployer employer4 = new Bpemployer();
		employer4.setEmail("hm@d.com");
		employer4.setHashpassword(HashPassword.Hash("hm@d.com", "password"));
		employer4.setName("John");
		employer4.setRole("hrmanager");
		ManageEmployer.add(employer4);

		Bpemployer employer5 = new Bpemployer();
		employer5.setEmail("him@d.com");
		employer5.setHashpassword(HashPassword.Hash("him@d.com", "password"));
		employer5.setName("oliver");
		employer5.setRole("hiringmanager");
		ManageEmployer.add(employer5);

		Bpemployer employer6 = new Bpemployer();
		employer6.setEmail("il@d.com");
		employer6.setHashpassword(HashPassword.Hash("il@d.com", "password"));
		employer6.setName("caramel");
		employer6.setRole("interviewleader");
		ManageEmployer.add(employer6);
		// assertTrue(hash ==
		// "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
