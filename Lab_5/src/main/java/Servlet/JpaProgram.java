package Servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Model.User;

public class JpaProgram {

	public static void main(String[] args) {
		findAll();
	}

	private static void create() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			User entity = new User();
			entity.setId("PS1400");
			entity.setFullname("Dương Minh Bình");
			entity.setEmail("binhdmps2@gmail.com");
			entity.setPassword("13habc");
			entity.setRole(false);

			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Thêm mới thành công !");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm thất bại!");
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void update() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			User entity = em.find(User.class, "PS32770");
			entity.setPassword("anhtu");
			entity.setRole(false);
			entity.setFullname("Đỗ Mỹ Thuận");
			em.merge(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("Update thành công!");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy lệnh
			System.out.println("Update thất bại!");
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void delete() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			User entity = em.find(User.class, "PS100");
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delte thành công1");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy lệnh
			System.out.println("Delete thất bại!");
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT u FROM User u";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Email: " + user.getEmail());
				System.out.println("Name: " + user.getFullname());
				System.out.println("Role: " + user.getRole());
			}
			em.getTransaction().commit();
			System.out.println("Truy vấn thành công !");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Truy vấn thất bại !");
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void findByRole(boolean role) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM User o WHERE o.Role=:role";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("role", role);

			// Truy váº¥n
			List<User> list = query.getResultList();

			// Hiá»ƒn thá»‹ káº¿t quáº£ truy váº¥n
			for (User user : list) {
				System.out.println(">>Email: " + user.getEmail());
				System.out.println(">>Is Admin: " + user.getRole());
			}
			em.getTransaction().commit();
			System.out.println("Truy vấn thành công !");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Truy vấn thất bại !");
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void findByKeyword(String email, String fullname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM User o WHERE o.Email LIKE ?0 OR o.Fullname LIKE ?1";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter(0, email);
			query.setParameter(1, fullname);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println(">>Email: " + user.getEmail());
				System.out.println(">>Is Admin: " + user.getRole());
			}
			em.getTransaction().commit();
			System.out.println("Truy vấn thành công !");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Truy vấn thất bại !");
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void findOne(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM User o WHERE o.id=:id AND o.Password=:pw";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("id", username);
			query.setParameter("pw", password);
			User user = query.getSingleResult();
			System.out.println(">>Email: " + user.getEmail());
			System.out.println(">>Is Admin: " + user.getRole());
			em.getTransaction().commit();
			System.out.println("Truy vấn thành công !");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Truy vấn thất bại !");
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void findPage(int page, int size) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM User o";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setFirstResult(page * size);
			query.setMaxResults(size);
			em.getTransaction().commit();
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println(">>Email: " + user.getEmail());
				System.out.println(">>Is Admin: " + user.getRole());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
