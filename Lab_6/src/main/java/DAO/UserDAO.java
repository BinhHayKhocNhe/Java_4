package DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import Utils.JpaUtils;
import Entity.Users;

public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	public Users create(Users entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public Users update(Users entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public Users delete(String id) {
		try {
			em.getTransaction().begin();
			Users entity = this.findById(id);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public Users findById(String id) {
		return em.find(Users.class, id);
	}

	public List<Users> findByRole(boolean isAdmin) {
		String jpql = "SELECT u FROM Users u WHERE u.admin = :isAdmin";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("isAdmin", isAdmin);
		return query.getResultList();
	}

	public List<Users> findByKeyword(String keyword) {
		String jpql = "SELECT u FROM Users u WHERE u.fullname LIKE :keyword";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();
	}

	public Users findOne(String username, String password) {
		String jpql = "SELECT u FROM Users u WHERE u.id = :username AND u.password = :password";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.getSingleResult();
	}

	public Users findByEmail(String email) {
		String jpql = "SELECT u FROM Users u WHERE u.email = :email";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public List<Users> findPage(int page, int size) {
		String jpql = "SELECT u FROM Users u";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	public List<Users> findAll() {
		String jpql = "SELECT u FROM Users u";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		return query.getResultList();
	}
}
