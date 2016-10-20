package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the BPJOBS database table.
 * 
 */
@Entity
@Table(name="BPJOBS")
@NamedQuery(name="Bpjob.findAll", query="SELECT b FROM Bpjob b")
public class Bpjob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long jobid;

	private String jobdescription;

	private String jobtype;

	private BigDecimal openings;

	private String tittle;

	//bi-directional many-to-one association to Bpapplication
	@OneToMany(mappedBy="bpjob")
	private List<Bpapplication> bpapplications;

	public Bpjob() {
	}

	public long getJobid() {
		return this.jobid;
	}

	public void setJobid(long jobid) {
		this.jobid = jobid;
	}

	public String getJobdescription() {
		return this.jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public BigDecimal getOpenings() {
		return this.openings;
	}

	public void setOpenings(BigDecimal openings) {
		this.openings = openings;
	}

	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public List<Bpapplication> getBpapplications() {
		return this.bpapplications;
	}

	public void setBpapplications(List<Bpapplication> bpapplications) {
		this.bpapplications = bpapplications;
	}

	public Bpapplication addBpapplication(Bpapplication bpapplication) {
		getBpapplications().add(bpapplication);
		bpapplication.setBpjob(this);

		return bpapplication;
	}

	public Bpapplication removeBpapplication(Bpapplication bpapplication) {
		getBpapplications().remove(bpapplication);
		bpapplication.setBpjob(null);

		return bpapplication;
	}

}