package MyFood.RestaurantService.Services;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyFood.RestaurantService.Repositories.MenuRepository;



@Service
public class ServiceMenu implements IServiceMenu{

	@Autowired
	MenuRepository menuRepository;
	
	@Override
	public List<Menu> findRestaurantMenu(String mot) {
		return menuRepository.findByNom(mot);
	}

}
