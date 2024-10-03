package MyFood.RestaurantService.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MyFood.RestaurantService.Entities.Adresse;


public interface AdresseRepository extends JpaRepository<Adresse,Integer>{

	List<Adresse> findByVille(String ville);
}
