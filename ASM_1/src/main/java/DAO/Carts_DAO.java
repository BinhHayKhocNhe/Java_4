package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Carts;
import Utils.JpaUtils;

public class Carts_DAO implements myInterFace<Carts, Object>{
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	public Carts insert(Carts entity) {
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
	public Carts update(Carts entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carts delete(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carts findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void find(Carts entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carts> findPage(int page, int size, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carts> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carts> selectAll() {
		String jpql = "SELECT c FROM Cart c";
		TypedQuery<Carts> query = em.createQuery(jpql, Carts.class);
		return query.getResultList();
	}

}
