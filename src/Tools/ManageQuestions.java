package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpquestion;

public class ManageQuestions {
	public static List<Bpquestion> getStagesByTitle(String tittle,String questiontype) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpquestion u where u.tittle = :tittle and u.questiontype = :questiontype";
		TypedQuery<Bpquestion> q = em.createQuery(qString, Bpquestion.class);
		List<Bpquestion> questions = null;
		q.setParameter("tittle", tittle);
		q.setParameter("questiontype", questiontype);
		try {
			questions = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return questions;

	}
}
