package DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Model.User;
import Utils.JpaUtils;

public class UserDAO {

	private EntityManager em = JpaUtils.getEntityManager();

	public User create(User entity) {
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

	public User update(User entity) {
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

	public User delete(String id) {
		try {
			em.getTransaction().begin();
			User entity = this.findById(id);
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

	public User findById(String id) {
		return em.find(User.class, id);
	}

	public List<User> findByRole(boolean role) {
		String jpql = "SELECT u FROM User u WHERE u.admin = :role1";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("role1", role);
		return query.getResultList();
	}

	public List<User> findByKeyWord(String keyword) {
		String jpql = "SELECT u FROM User u WHERE u.fullname LIKE :name";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("name", "%" + keyword + "%");
		return query.getResultList();
	}

	public User findOne(String username, String password) {
		String jpql = "SELECT u FROM User u WHERE u.id = :userId AND u.password = :password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("userId", username);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Trả về null nếu không tìm thấy kết quả
		}
	}

	public User findByEmail(String email) {
		String jpql = "SELECT u FROM User u WHERE u.email = :email";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Trả về null nếu không tìm thấy kết quả
		}
	}

	public List<User> findPage(int page, int size) {
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class).setFirstResult(page * size).setMaxResults(size);
		return query.getResultList();
	}

	public List<User> findAll() {
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			System.err.println("Không có bản ghi User nào được tìm thấy.");
			return Collections.emptyList(); // Trả về danh sách trống
		}
	}

	public long countAll() {
		String jpql = "SELECT COUNT(u.id) FROM User u";

		TypedQuery<Long> query = em.createQuery(jpql, Long.class);

		return query.getSingleResult();
	}

}
