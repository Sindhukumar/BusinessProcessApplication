package UnitTests;

import java.util.List;

import org.junit.Test;

import Tools.ManageApplication;
import Tools.ManageEmployer;
import Tools.ManageJob;
import Tools.ManageStage;
import model.Bpapplication;
import model.Bpjob;
import model.Bpstage;

public class InsertStage {
	@Test
	public void insert() {

		List<Bpapplication> applications = ManageApplication.getApplicationList();
		int i = 1;
		for (Bpapplication application : applications) {
			Bpstage stage = new Bpstage();
			stage.setBpapplication(application);
			stage.setBpemployer(ManageEmployer.getEmployerByEmail("c@d.com"));
			stage.setStagecomment("compliance officer comment "+i);
			stage.setStagename("nationality");
			stage.setStageresult("inprogress");
			ManageStage.add(stage);
			i++;
		}
		// assertTrue(hash ==
		// "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
