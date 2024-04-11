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
	public Users delete(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			Users entity = findID_Em(em, (int) id);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
	    em = JpaUtils.getEntityManager();
	    try {
	        String jpql = "SELECT u FROM Users u WHERE u.Username LIKE :keyword OR u.Fullname LIKE :keyword";
	        TypedQuery<Users> query = em.createQuery(jpql, Users.class);
	        query.setParameter("keyword", "%" + keyword + "%");
	        return query.getResultList();
	    } catch (Exception e) {
	        return null;
	    } finally {
	        JpaUtils.closeEntityManager(em);
	    }
	}


	public static void main(String[] args) {
		Users_DAO dao = new Users_DAO();
        List<Users> users = dao.findByKeyword("User One");
        if (users != null) {
            for (Users user : users) {
                System.out.println("ID: " + user.getID_User());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Fullname: " + user.getFullname());
                // In thêm các thông tin khác nếu cần
            }
        } else {
            System.out.println("Không tìm thấy người dùng.");
        }
	}
	@Override
	public List<Users> selectAll() {
		return null;
	}

	public long countAll() {
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT COUNT(u.id) FROM Users u";
			TypedQuery<Long> query = em.createQuery(jpql, Long.class);
			return query.getSingleResult();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public List<Users> findPage(int page, int size) {
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT u FROM Users u";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class).setFirstResult(page * size).setMaxResults(size);
			return query.getResultList();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	public Users findID(int id) {
		em = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT u FROM Users u WHERE u.ID_User = :userId";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("userId", id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public Users findID_Em(EntityManager em, int id) {
		try {
			String jpql = "SELECT u FROM Users u WHERE u.ID_User = :userId";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("userId", id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
}
