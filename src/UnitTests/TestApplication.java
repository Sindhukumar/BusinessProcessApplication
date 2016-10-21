package UnitTests;

import java.util.List;

import org.junit.Test;

import Tools.ManageApplication;
import Tools.ManageJob;
import model.Bpapplication;
import model.Bpjob;

public class TestApplication {
	@Test
	public void listapplication() {
		List<Bpapplication> applications = ManageApplication.getApplicationsatStage("nationality");

		for (Bpapplication application : applications) {
			System.out.println(application.getFullname());
		}
	}

}
