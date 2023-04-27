package exoCinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoCinema.context.JpaContext;
import exoCinema.entities.Film;


public class DaoFilmJpaImpl implements DaoFilm {

	@Override
	public void insert(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();		
	}

	@Override
	public Film update(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
		
	}

	@Override
	public void deletebyKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Film.class, key));
		tx.commit();
		em.close();
		
	}

	@Override
	public Film findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Film film = em.find(Film.class, key);
		em.close();
		return film;
	}

	@Override
	public List<Film> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film", Film.class);
		//On utilise le nom de classe pour Film, attention à la majuscule
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	

}
