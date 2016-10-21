package UnitTests;

import java.math.BigDecimal;
import org.junit.Test;
import Tools.ManageJob;
import model.Bpjob;

public class InsertJobs {

	@Test
	public void insert() {
		for (int i = 1; i < 6; i++) {
			Bpjob job = new Bpjob();
			job.setJobdescription(
					"Technical analyst in our company does all kinds of stuff which can not be explicitly mentioned or narrowed down");
			job.setJobtype("Technical");
			job.setOpenings(new BigDecimal(4));
			job.setTittle("Technical Analyst " + i);
			ManageJob.add(job);
		}
		// assertTrue(hash ==
		// "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
