package MyFood.RestaurantService.Controllers;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import MyFood.RestaurantService.Services.IServiceMenu;



@RestController
@RequestMapping("/api/menu")

public class MenuRestController {

	@Autowired
	IServiceMenu Smenu;
	
    @GetMapping("/test")
    public String gettest() {
    	return "Test Menu";
    }
	
	@GetMapping("/menu")
    public ResponseEntity<List<Menu>> getOneParm(@RequestParam("mot") String mot) {
        List<Menu> menu = Smenu.findRestaurantMenu(mot);
        if (menu.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
}

