package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Products;
import Utils.JpaUtils;

public class Products_DAO implements myInterFace<Products, Object> {

	private EntityManager em = null;

	@Override
	public Products insert(Products entity) {
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
	public Products update(Products entity) {
		em = JpaUtils.getEntityManager();
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

	@Override
	public Products delete(Object id) {
		em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			Products entity = this.findById(id);
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

	@Override
	public Products findById(Object id) {
		return em.find(Products.class, id);
	}

	@Override
	public void find(Products entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Products> findPage(int page, int size, String categoryId) {
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT p FROM Products p WHERE p.CategoryID = :categoryId";
			TypedQuery<Products> query = em.createQuery(jpql, Products.class).setParameter("categoryId", categoryId)
					.setFirstResult(page * size).setMaxResults(size);
			return query.getResultList();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	@Override
	public List<Products> findByKeyword(String keyword) {
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT p FROM Products p WHERE p.ProductName LIKE :name"; // Sửa tên biến
			TypedQuery<Products> query = em.createQuery(jpql, Products.class);
			query.setParameter("name", "%" + keyword + "%");
			return query.getResultList();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	@Override
	public List<Products> selectAll() {
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT p FROM Products p";
			TypedQuery<Products> query = em.createQuery(jpql, Products.class);
			return query.getResultList();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public long countProductID(String categoryId) {
		em = JpaUtils.getEntityManager();
		String jpql = "SELECT COUNT(p) FROM Products p WHERE p.CategoryID = :categoryId";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("categoryId", categoryId);
		return query.getSingleResult();

	}
}
