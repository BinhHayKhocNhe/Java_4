package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {

		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("ASM_2_PS32770");
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
