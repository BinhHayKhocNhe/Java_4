package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;

public class Categories_DAO implements myInterFace<Categories_DAO, Object> {

	private EntityManager em = null;

	@Override
	public Categories_DAO insert(Categories_DAO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categories_DAO update(Categories_DAO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categories_DAO delete(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categories_DAO findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void find(Categories_DAO entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categories_DAO> findPage(int page, int size, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categories_DAO> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categories_DAO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String CategoryName(String categoryId) {
		try {
			em = JpaUtils.getEntityManager();
			String jpqlQuery = "SELECT c.CategoryName FROM Categories c WHERE c.CategoryID = :categoryId";
			TypedQuery<String> query = em.createQuery(jpqlQuery, String.class);
			query.setParameter("categoryId", categoryId);
			return query.getSingleResult();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

}
