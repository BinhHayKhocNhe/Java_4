package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Categories;
import Utils.JpaUtils;

public class Categories_DAO implements myInterFace<Categories, Object> {

	private EntityManager em = null;


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


	@Override
	public Categories insert(Categories entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Categories update(Categories entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Categories delete(Object id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Categories findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void find(Categories entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Categories> findPage(int page, int size, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Categories> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Categories> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
