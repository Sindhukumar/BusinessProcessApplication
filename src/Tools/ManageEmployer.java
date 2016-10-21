package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpemployer;


public class ManageEmployer {

	public static Bpemployer getEmployer(long bpemployerid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bpemployer employer = em.find(Bpemployer.class, bpemployerid);
		return employer;
	}

	public static void add(Bpemployer employer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(employer);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bpemployer employer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(employer);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bpemployer employer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(employer));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static Bpemployer getEmployerByEmail(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpemployer u " + "where u.email = :email";
		TypedQuery<Bpemployer> q = em.createQuery(qString, Bpemployer.class);
		q.setParameter("email", email);
		Bpemployer employer = null;
		try {
			employer = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return employer;

	}

	public static List<Bpemployer> getEmployerList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpemployer u";
		TypedQuery<Bpemployer> q = em.createQuery(qString, Bpemployer.class);
		List<Bpemployer> employers = null;
		try {
			employers = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return employers;

	}

	public static Bpemployer isValidEmployer(String email, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		password = HashPassword.Hash(email, password);
		String qString = "Select b from Bpemployer b " + "where b.email = :email and b.hashpassword = :pass";
		TypedQuery<Bpemployer> q = em.createQuery(qString, Bpemployer.class);
		Bpemployer user = null;
		q.setParameter("email", email);
		System.out.println("email" + email);
		q.setParameter("pass", password);
		System.out.println("password " + password);
		try {
			user = q.getSingleResult();
			System.out.println("valid user");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}



}
