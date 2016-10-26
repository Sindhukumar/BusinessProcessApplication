package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BPUSERS database table.
 * 
 */
@Entity
@Table(name="BPUSERS")
@NamedQuery(name="Bpuser.findAll", query="SELECT b FROM Bpuser b")
public class Bpuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userid;

	private String address;

	private String awards;

	private String education;

	private String email;

	private String objective;

	private String passwordhash;

	private String skills;

	private String summary;

	public Bpuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAwards() {
		return this.awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObjective() {
		return this.objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getPasswordhash() {
		return this.passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}