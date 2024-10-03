package MyFood.RestaurantService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import MyFood.RestaurantService.Entities.Adresse;
import MyFood.RestaurantService.Services.IServiceAdresse;



@RestController
@RequestMapping("/api/adresses")
public class AdresseRestController {
	
	@Autowired
	IServiceAdresse Sadresse;
	
    @GetMapping("/test")
    public String gettest() {
    	return "Test Adresse";
    }
	
	@GetMapping("/adresse")
    public ResponseEntity<List<Adresse>> getOneParm(@RequestParam("ville") String ville) {
        List<Adresse> adresse = Sadresse.findAvailableRestaurants(ville);
        if (adresse.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }
	

}
