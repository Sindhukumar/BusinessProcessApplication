package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BPAPPLICATIONS database table.
 * 
 */
@Entity
@Table(name="BPAPPLICATIONS")
@NamedQuery(name="Bpapplication.findAll", query="SELECT b FROM Bpapplication b")
public class Bpapplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bpapplicationid;

	private String address;

	private String birthday;

	private String citizenship;

	private String druguse;

	private String education;

	private String email;

	private String fullname;

	private String jobhistory;

	@Column(name="\"REFERENCES\"")
	private String references;

	private String status;

	private String veteran;

	//bi-directional many-to-one association to Bpjob
	@ManyToOne
	@JoinColumn(name="JOBID")
	private Bpjob bpjob;

	//bi-directional many-to-one association to Bpstage
	@OneToMany(mappedBy="bpapplication")
	private List<Bpstage> bpstages;

	public Bpapplication() {
	}

	public long getBpapplicationid() {
		return this.bpapplicationid;
	}

	public void setBpapplicationid(long bpapplicationid) {
		this.bpapplicationid = bpapplicationid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getDruguse() {
		return this.druguse;
	}

	public void setDruguse(String druguse) {
		this.druguse = druguse;
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

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getJobhistory() {
		return this.jobhistory;
	}

	public void setJobhistory(String jobhistory) {
		this.jobhistory = jobhistory;
	}

	public String getReferences() {
		return this.references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVeteran() {
		return this.veteran;
	}

	public void setVeteran(String veteran) {
		this.veteran = veteran;
	}

	public Bpjob getBpjob() {
		return this.bpjob;
	}

	public void setBpjob(Bpjob bpjob) {
		this.bpjob = bpjob;
	}

	public List<Bpstage> getBpstages() {
		return this.bpstages;
	}

	public void setBpstages(List<Bpstage> bpstages) {
		this.bpstages = bpstages;
	}

	public Bpstage addBpstage(Bpstage bpstage) {
		getBpstages().add(bpstage);
		bpstage.setBpapplication(this);

		return bpstage;
	}

	public Bpstage removeBpstage(Bpstage bpstage) {
		getBpstages().remove(bpstage);
		bpstage.setBpapplication(null);

		return bpstage;
	}

}