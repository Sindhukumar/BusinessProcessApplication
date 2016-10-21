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
		 final String Sunday = "sunday";
		switch (Sunday.toLowerCase()) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
			System.out.println("boring");
			break;
		case "Thursday":
			System.out.println("getting better");
		case "Friday":
		case "Saturday":
		case Sunday:
			System.out.println("much better");
			break;
		}
	}
}