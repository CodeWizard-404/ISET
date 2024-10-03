package MyFood.CourtierService.Services;


import MyFood.CourtierService.Entities.Location;

public interface CourierService {
    String updateCourierLocation(Long courierId, Location location);

}
