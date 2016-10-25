package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BPQUESTIONS database table.
 * 
 */
@Entity
@Table(name="BPQUESTIONS")
@NamedQuery(name="Bpquestion.findAll", query="SELECT b FROM Bpquestion b")
public class Bpquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long questionid;

	private String question;

	private String questiontype;

	private String tittle;

	public Bpquestion() {
	}

	public long getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestiontype() {
		return this.questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

}