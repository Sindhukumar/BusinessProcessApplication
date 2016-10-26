package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpapplication;
import model.Bpstage;

public class ManageStage {

	public static Bpstage getStage(long bpstageid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bpstage stage = em.find(Bpstage.class, bpstageid);
		return stage;
	}

	public static void add(Bpstage stage) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(stage);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bpstage stage) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(stage);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bpstage stage) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(stage));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Bpstage> getStageList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpstage u";
		TypedQuery<Bpstage> q = em.createQuery(qString, Bpstage.class);
		List<Bpstage> stages = null;
		try {
			stages = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return stages;

	}
	
	public static List<Bpstage> getStagesByName(String stagename) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpstage u where lower(u.stagename) = lower(:stagename) and u.stageresult='inprogress'";
		TypedQuery<Bpstage> q = em.createQuery(qString, Bpstage.class);
		List<Bpstage> stages = null;
		q.setParameter("stagename", stagename);
		try {
			stages = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return stages;

	}
	
	public static List<Bpstage> getStagesByName(String stagename1,String stagename2) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpstage u where lower(u.stagename) in ( lower(:stagename1) ,  lower(:stagename2) ) and u.stageresult='inprogress'";
		TypedQuery<Bpstage> q = em.createQuery(qString, Bpstage.class);
		List<Bpstage> stages = null;
		q.setParameter("stagename1", stagename1);
		q.setParameter("stagename2", stagename2);
		try {
			stages = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return stages;

	}
	
	public static List<Bpstage> getStagesByName(String stagename1,String stagename2, String stagename3) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpstage u where lower(u.stagename) in (lower(:stagename1) , lower(:stagename2) , lower(:stagename3)) and u.stageresult='inprogress'";
		TypedQuery<Bpstage> q = em.createQuery(qString, Bpstage.class);
		List<Bpstage> stages = null;
		q.setParameter("stagename1", stagename1);
		q.setParameter("stagename2", stagename2);
		q.setParameter("stagename3", stagename3);
		try {
			stages = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return stages;

	}
	
	public static List<Bpstage> getStagesByApplication(Bpapplication application) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpstage u where u.bpapplication = :application";
		TypedQuery<Bpstage> q = em.createQuery(qString, Bpstage.class);
		List<Bpstage> stages = null;
		q.setParameter("application", application);
		try {
			stages = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return stages;

	}
}
