package Kolesa.Service;

import Kolesa.Model.Car;
import Kolesa.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import Kolesa.Dto.Request.CarRequest;  // Import the CarRequest DTO

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;

    public void addCar(CarRequest request) {
        Car car = new Car();
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setPrice(request.getPrice());
        car.setMileage(request.getMileage());
        car.setColor(request.getColor());
        car.setLocation(request.getLocation());
        car.setImageData(request.getImageData());
        car.setRelease_date(request.getReleaseDate());
        car.setDescription(request.getDescription());

        repository.save(car);
    }

    public Car getCarById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Car updateCar(Long id, CarRequest updateRequest) {
        if (this.repository.existsById(id)) {
            Car existingCar = this.repository.findById(id).orElse(null);
            if (existingCar != null) {
                if (updateRequest.getMake() != null) {
                    existingCar.setMake(updateRequest.getMake());
                }
                if (updateRequest.getModel() != null) {
                    existingCar.setModel(updateRequest.getModel());
                }
                if (updateRequest.getYear() != null) {
                    existingCar.setYear(updateRequest.getYear());
                }
                if (updateRequest.getPrice() != null) {
                    existingCar.setPrice(updateRequest.getPrice());
                }
                if (updateRequest.getMileage() != null) {
                    existingCar.setMileage(updateRequest.getMileage());
                }
                if (updateRequest.getColor() != null) {
                    existingCar.setColor(updateRequest.getColor());
                }
                if (updateRequest.getLocation() != null) {
                    existingCar.setLocation(updateRequest.getLocation());
                }
                if (updateRequest.getImageData() != null) {
                    existingCar.setImageData(updateRequest.getImageData());
                }
                if (updateRequest.getReleaseDate() != null) {
                    existingCar.setRelease_date(updateRequest.getReleaseDate());
                }
                if (updateRequest.getDescription() != null) {
                    existingCar.setDescription(updateRequest.getDescription());
                }
                return repository.save(existingCar);
            }
        }
        return null;
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}

