package br.com.consultmed.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(Contantes.PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void shutdown() {
		if(factory != null) {
			factory.close();
		}
	}
	
}
