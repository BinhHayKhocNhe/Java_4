package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import Entity.Users;
import Utils.JpaUtils;

public class Users_DAO implements myInterFace<Users, Object> {

	private EntityManager em = null;

	@Override
	public Users insert(Users entity) {
		em = JpaUtils.getEntityManager();
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

	@Override
	public Users update(Users entity) {
		return null;
	}

	@Override
	public Users delete(Object id) {
		return null;
	}

	@Override
	public Users findById(Object id) {
		em = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT u FROM Users u WHERE u.Username = :username";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("username", (String) id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	@Override
	public void find(Users entity) {

	}

	@Override
	public List<Users> findPage(int page, int size, String categoryId) {

		return null;
	}

	@Override
	public List<Users> findByKeyword(String keyword) {

		return null;
	}

	@Override
	public List<Users> selectAll() {
		return null;
	}

}
