package carPoolRide.carPoolRide;

import carPoolRide.carPoolRide.model.Ride;
import carPoolRide.carPoolRide.repository.RideRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import java.time.LocalDateTime;

@SpringBootApplication
public class CarPoolRideApplication implements CommandLineRunner {

	private final RideRepository rideRepository;

	public CarPoolRideApplication(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarPoolRideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ride ride1 = new Ride();
		ride1.setDriverName("Petar");
		ride1.setPickupLocation("Downtown");
		ride1.setDropoffLocation("Airport");
		ride1.setDepartureTime(LocalDateTime.now().plusHours(2));
		ride1.setAvailableSeats(3);

		Ride ride2 = new Ride();
		ride2.setDriverName("Andrej");
		ride2.setPickupLocation("Suburbs");
		ride2.setDropoffLocation("City Center");
		ride2.setDepartureTime(LocalDateTime.now().plusHours(1));
		ride2.setAvailableSeats(2);

		rideRepository.save(ride1);
		rideRepository.save(ride2);
	}
}