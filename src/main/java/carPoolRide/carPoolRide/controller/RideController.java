package carPoolRide.carPoolRide.controller;

import carPoolRide.carPoolRide.model.Ride;
import carPoolRide.carPoolRide.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ride createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public Ride getRideById(@PathVariable Long id) {
        return rideService.getRideById(id);
    }

    @PutMapping("/{id}")
    public Ride updateRide(@PathVariable Long id, @RequestBody Ride rideDetails) {
        return rideService.updateRide(id, rideDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRide(@PathVariable Long id) {
        rideService.deleteRide(id);
    }

    @GetMapping("/search")
    public List<Ride> searchRides(@RequestParam String pickup, @RequestParam String dropoff) {
        return rideService.searchRides(pickup, dropoff);
    }

    @PostMapping("/{id}/passengers")
    public Ride addPassenger(@PathVariable Long id, @RequestBody String passengerName) {
        return rideService.addPassenger(id, passengerName);
    }

    @DeleteMapping("/{id}/passengers")
    public Ride removePassenger(@PathVariable Long id, @RequestBody String passengerName) {
        return rideService.removePassenger(id, passengerName);
    }

    @GetMapping("/driver/{driverName}")
    public List<Ride> getRidesByDriver(@PathVariable String driverName) {
        return rideService.getRidesByDriver(driverName);
    }

    @GetMapping("/available")
    public List<Ride> getAvailableRides() {
        return rideService.getAvailableRides();
    }
}