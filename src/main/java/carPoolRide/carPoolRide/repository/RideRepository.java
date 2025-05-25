package carPoolRide.carPoolRide.repository;

import carPoolRide.carPoolRide.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByPickupLocationAndDropoffLocation(String pickupLocation, String dropoffLocation);
    List<Ride> findByDriverName(String driverName);
    List<Ride> findByAvailableSeatsGreaterThan(int seats);
}