package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	// Đối tượng này cho phép tạo ra EntityManager để bắt đầu lập trình truy vấn và
	// thao tác dữ liệu.
	private static EntityManagerFactory factory;

	//Cho phép thao tác (thêm, sửa, xóa) và truy vấn 1 thực thể
	public static EntityManager getEntityManager() {

		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("PolyOE");
		}
		return factory.createEntityManager();

	}

	public static void shutDown() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}

	public static void closeEntityManager(EntityManager em) {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}
}
