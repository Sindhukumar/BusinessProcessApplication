package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpjob;

public class ManageJob {

	public static Bpjob getUser(long jobid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bpjob job = em.find(Bpjob.class, jobid);
		return job;
	}

	public static void add(Bpjob job) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(job);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bpjob job) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(job);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bpjob job) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(job));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Bpjob> getJobList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpjob u";
		TypedQuery<Bpjob> q = em.createQuery(qString, Bpjob.class);
		List<Bpjob> jobs = null;
		try {
			jobs = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return jobs;

	}

}
