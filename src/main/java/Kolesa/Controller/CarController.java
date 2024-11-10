package Kolesa.Controller;

import Kolesa.Dto.Request.CarRequest;
import Kolesa.Model.Car;
import Kolesa.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping
    public List<CarRequest> getAllCars() {
        return service.getAllCars();
    }

    @GetMapping(value = "/{id}")
    public CarRequest getCarById(@PathVariable Long id) {
       return service.getCarById(id);
    }

    @PostMapping
    public void addCar(@RequestBody CarRequest carRequest) {
        service.addCar(carRequest);
    }

    @PutMapping(value = "/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody CarRequest updateCar) {
         service.updateCar(id, updateCar);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable Long id) {
        service.deleteCar(id);
    }
}
