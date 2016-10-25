package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BPSTAGES database table.
 * 
 */
@Entity
@Table(name="BPSTAGES")
@NamedQuery(name="Bpstage.findAll", query="SELECT b FROM Bpstage b")
public class Bpstage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bpstageid;

	private String stagecomment;

	private String stagename;

	private String stageresult;

	//bi-directional many-to-one association to Bpapplication
	@ManyToOne
	@JoinColumn(name="BPAPPLICATIONID")
	private Bpapplication bpapplication;

	//bi-directional many-to-one association to Bpemployer
	@ManyToOne
	@JoinColumn(name="BPEMPLOYERID")
	private Bpemployer bpemployer;

	public Bpstage() {
	}

	public long getBpstageid() {
		return this.bpstageid;
	}

	public void setBpstageid(long bpstageid) {
		this.bpstageid = bpstageid;
	}

	public String getStagecomment() {
		return this.stagecomment;
	}

	public void setStagecomment(String stagecomment) {
		this.stagecomment = stagecomment;
	}

	public String getStagename() {
		return this.stagename;
	}

	public void setStagename(String stagename) {
		this.stagename = stagename;
	}

	public String getStageresult() {
		return this.stageresult;
	}

	public void setStageresult(String stageresult) {
		this.stageresult = stageresult;
	}

	public Bpapplication getBpapplication() {
		return this.bpapplication;
	}

	public void setBpapplication(Bpapplication bpapplication) {
		this.bpapplication = bpapplication;
	}

	public Bpemployer getBpemployer() {
		return this.bpemployer;
	}

	public void setBpemployer(Bpemployer bpemployer) {
		this.bpemployer = bpemployer;
	}

}