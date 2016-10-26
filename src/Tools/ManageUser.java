package Tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bpuser;


public class ManageUser {

	public static Bpuser getEmployer(long userid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Bpuser user = em.find(Bpuser.class, userid);
		return user;
	}

	public static void add(Bpuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Bpuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Bpuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static Bpuser getUserByEmail(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpuser u " + "where u.email = :email";
		TypedQuery<Bpuser> q = em.createQuery(qString, Bpuser.class);
		q.setParameter("email", email);
		Bpuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}

	public static List<Bpuser> getUserList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bpuser u";
		TypedQuery<Bpuser> q = em.createQuery(qString, Bpuser.class);
		List<Bpuser> users = null;
		try {
			users = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return users;

	}

	public static Bpuser isValidUser(String email, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		password = HashPassword.Hash(email, password);
		String qString = "Select b from Bpuser b " + "where b.email = :email and b.passwordhash = :pass";
		TypedQuery<Bpuser> q = em.createQuery(qString, Bpuser.class);
		Bpuser user = null;
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
