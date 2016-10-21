package UnitTests;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import Tools.ManageApplication;
import Tools.ManageJob;
import model.Bpapplication;
import model.Bpjob;

public class InsertApplication {
	@Test
	public void insert() {
		
		List<Bpjob> jobs = ManageJob.getJobList();
		int i=1;
		for (Bpjob job:jobs) {
			Bpapplication application = new Bpapplication();
			application.setBirthday(i+"st Jan 1990");
			application.setBpjob(job);
			application.setCitizenship("US");
			application.setDruguse("no");
			application.setEducation("Awesome University");
			application.setEmail("e"+i+"@d.com");
			application.setFullname("Name "+i);
			application.setJobhistory("History "+i);
			application.setReferences("Refrences "+i);
			application.setVeteran("no");
			application.setStatus("processing");
			ManageApplication.add(application);
			i++;
		}
		// assertTrue(hash ==
		// "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
