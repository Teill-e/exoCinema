package exoCinema.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exoCinema.repositories.DaoFilm;
import exoCinema.repositories.DaoFilmJpaImpl;

public class JpaContext {
	//singleton : objet qui garantit qu'on aura une seul fois cet objet en mémoire
	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoFilm daoFilm = new DaoFilmJpaImpl();
	
	public static DaoFilm getDaoFilm() {
		return daoFilm;
	}
	
	//static : rattaché à une classe (vs rattaché à une instance), il n'y en a qu'une seule version qui est chargé lorsque la classe est chargée en mémoire
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("exocinema");
		}
		return entityManagerFactory;
		//on a créé le singleton
	}
	
	public static void destroy() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
}
