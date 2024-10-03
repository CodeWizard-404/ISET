package MyFood.RestaurantService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyFood.RestaurantService.Entities.Adresse;
import MyFood.RestaurantService.Repositories.AdresseRepository;



@Service
public class ServiceAdresse implements IServiceAdresse{

	@Autowired
	AdresseRepository adresseRepository;
	@Override
	public List<Adresse> findAvailableRestaurants(String ville) {
		return adresseRepository.findByVille(ville);
	}

}
