package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BPEMPLOYERS database table.
 * 
 */
@Entity
@Table(name="BPEMPLOYERS")
@NamedQuery(name="Bpemployer.findAll", query="SELECT b FROM Bpemployer b")
public class Bpemployer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bpemployerid;

	private String email;

	private String hashpassword;

	private String name;

	@Column(name="\"ROLE\"")
	private String role;

	//bi-directional many-to-one association to Bpstage
	@OneToMany(mappedBy="bpemployer")
	private List<Bpstage> bpstages;

	public Bpemployer() {
	}

	public long getBpemployerid() {
		return this.bpemployerid;
	}

	public void setBpemployerid(long bpemployerid) {
		this.bpemployerid = bpemployerid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashpassword() {
		return this.hashpassword;
	}

	public void setHashpassword(String hashpassword) {
		this.hashpassword = hashpassword;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Bpstage> getBpstages() {
		return this.bpstages;
	}

	public void setBpstages(List<Bpstage> bpstages) {
		this.bpstages = bpstages;
	}

	public Bpstage addBpstage(Bpstage bpstage) {
		getBpstages().add(bpstage);
		bpstage.setBpemployer(this);

		return bpstage;
	}

	public Bpstage removeBpstage(Bpstage bpstage) {
		getBpstages().remove(bpstage);
		bpstage.setBpemployer(null);

		return bpstage;
	}

}