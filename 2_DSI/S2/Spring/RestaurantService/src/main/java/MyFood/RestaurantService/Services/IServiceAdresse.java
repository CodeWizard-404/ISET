package MyFood.RestaurantService.Services;

import java.util.List;

import MyFood.RestaurantService.Entities.Adresse;


public interface IServiceAdresse {

	public List<Adresse> findAvailableRestaurants(String ville);
}
