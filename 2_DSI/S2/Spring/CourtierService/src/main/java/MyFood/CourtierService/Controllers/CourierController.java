package MyFood.CourtierService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import MyFood.CourtierService.Entities.Location;
import MyFood.CourtierService.Services.CourierService;

@RestController
@RequestMapping("/api/courtiers")
public class CourierController implements CourierService{

    @Autowired
    private CourierService courierService;
    
    @GetMapping("/test")
    public String gettest() {
    	return "Test Courier";
    }

    @PutMapping("/{courierId}/update-location")
    public String updateCourierLocation(@PathVariable Long courierId, @RequestBody Location location) {
        try {
            courierService.updateCourierLocation(courierId, location);
            return "Courier location updated successfully.";
        } catch (RuntimeException e) {
            return "notFound";
        }
    }
}
