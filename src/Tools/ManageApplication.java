package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpapplication;

public class ManageApplication {

	public static Bpapplication getApplication(long bpapplicationid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bpapplication bpapplication = em.find(Bpapplication.class, bpapplicationid);
		return bpapplication;
	}

	public static Bpapplication add(Bpapplication bpapplication) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		Bpapplication application;
		try {
			trans.begin();
			em.persist(bpapplication);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {

			application = bpapplication;
			em.close();
		}
		return application;
	}

	public static void update(Bpapplication bpapplication) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(bpapplication);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bpapplication application) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(application));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Bpapplication> getApplicationList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpapplication u";
		TypedQuery<Bpapplication> q = em.createQuery(qString, Bpapplication.class);
		List<Bpapplication> userList = null;
		try {
			userList = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return userList;

	}
	
	public static List<Bpapplication> getApplicationsatStage(String stagename) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u.bpapplication from Bpstage u where lower(u.stagename) = lower(:stagename)";
		TypedQuery<Bpapplication> q = em.createQuery(qString, Bpapplication.class);
		List<Bpapplication> userList = null;
		q.setParameter("stagename", stagename);
		try {
			userList = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return userList;

	}

}
