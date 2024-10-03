package MyFood.CourtierService.Services;

import MyFood.CourtierService.Entities.Courier;
import MyFood.CourtierService.Entities.Location;
import MyFood.CourtierService.Repositories.CourierRepository;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl implements CourierService{

    private final CourierRepository courierRepository;

    public CourierServiceImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    public String updateCourierLocation(Long courierId, Location locationDto) {
        Courier courier = courierRepository.findById(courierId).orElseThrow();

        Location location = courier.getLocation();
        if (location == null) {
            location = new Location();
            location.setCourier(courier);
        }

        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());

        courierRepository.save(courier);
		return null;
    }

}
