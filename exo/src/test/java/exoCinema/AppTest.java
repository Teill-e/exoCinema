package exoCinema;

import java.time.LocalDate;
import java.time.LocalTime;


import exoCinema.context.JpaContext;
import exoCinema.entities.Categorie;
import exoCinema.entities.Film;
import exoCinema.repositories.DaoFilm;

public class AppTest {

	public static void main(String[] args) {
		
		Film f1 = new Film();
		f1.setId(1L);
		f1.setNom("Avatar 2");
		f1.setSortie(LocalDate.parse("2022-12-14"));
		f1.setDuree(LocalTime.parse("03:12"));
		f1.setDisponible(true);
		f1.setCategorie(Categorie.Animation);
		
		DaoFilm daoFilm = JpaContext.getDaoFilm();
		
		daoFilm.insert(f1);
		
	}

}
