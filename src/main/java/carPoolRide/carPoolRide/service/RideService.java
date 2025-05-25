package carPoolRide.carPoolRide.service;
import carPoolRide.carPoolRide.exceptionhandleclass.InvalidPassengerOperationException;
import carPoolRide.carPoolRide.exceptionhandleclass.ResourceNotFoundException;
import carPoolRide.carPoolRide.model.Ride;
import carPoolRide.carPoolRide.repository.RideRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RideService {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ride not found with id: " + id));
    }

    public Ride updateRide(Long id, Ride rideDetails) {
        Ride ride = getRideById(id);
        ride.setDriverName(rideDetails.getDriverName());
        ride.setPickupLocation(rideDetails.getPickupLocation());
        ride.setDropoffLocation(rideDetails.getDropoffLocation());
        ride.setDepartureTime(rideDetails.getDepartureTime());
        ride.setAvailableSeats(rideDetails.getAvailableSeats());
        return rideRepository.save(ride);
    }

    public void deleteRide(Long id) {
        Ride ride = getRideById(id);
        rideRepository.delete(ride);
    }

    public List<Ride> searchRides(String pickup, String dropoff) {
        return rideRepository.findByPickupLocationAndDropoffLocation(pickup, dropoff);
    }

    @Transactional
    public Ride addPassenger(Long rideId, String passengerName) {
        Ride ride = getRideById(rideId);
        if (ride.getAvailableSeats() <= 0) {
            throw new InvalidPassengerOperationException("No available seats in this ride");
        }
        ride.getPassengerNames().add(passengerName);
        ride.setAvailableSeats(ride.getAvailableSeats() - 1);
        return rideRepository.save(ride);
    }

    @Transactional
    public Ride removePassenger(Long rideId, String passengerName) {
        Ride ride = getRideById(rideId);
        if (!ride.getPassengerNames().remove(passengerName)) {
            throw new InvalidPassengerOperationException("Passenger not found in this ride");
        }
        ride.setAvailableSeats(ride.getAvailableSeats() + 1);
        return rideRepository.save(ride);
    }

    public List<Ride> getRidesByDriver(String driverName) {
        return rideRepository.findByDriverName(driverName);
    }

    public List<Ride> getAvailableRides() {
        return rideRepository.findByAvailableSeatsGreaterThan(0);
    }
}