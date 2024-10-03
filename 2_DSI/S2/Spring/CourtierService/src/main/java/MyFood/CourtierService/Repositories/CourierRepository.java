package MyFood.CourtierService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import MyFood.CourtierService.Entities.Courier;

public interface CourierRepository extends JpaRepository<Courier, Long> {

}
