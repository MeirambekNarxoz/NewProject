package Kolesa.Service;

import Kolesa.Mapper.CarMapper;
import Kolesa.Model.Car;
import Kolesa.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import Kolesa.Dto.Request.CarRequest;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;
    public void addCar(CarRequest request) {
        Car car = mapper.toModel(request);

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

        Car savedCar = repository.save(car);
        mapper.toDto(savedCar);
    }


    public CarRequest getCarById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public List<CarRequest> getAllCars() {
       return mapper.toDtoList(repository.findAll());
    }

    public void updateCar(Long id, CarRequest updateRequest) {
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
                Car savedCar = repository.save(existingCar);
                mapper.toDto(savedCar);
            }
        }
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}

