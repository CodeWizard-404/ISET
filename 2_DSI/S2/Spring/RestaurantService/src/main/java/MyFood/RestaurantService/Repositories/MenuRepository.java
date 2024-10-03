package MyFood.RestaurantService.Repositories;

import java.awt.Menu;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository extends JpaRepository<Menu,Integer>{
	List<Menu> findByNom(String nom);

}
