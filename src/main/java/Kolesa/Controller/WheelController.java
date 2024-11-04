package Kolesa.Controller;

import Kolesa.Dto.WheelRequest;
import Kolesa.Model.Wheel;
import Kolesa.Service.WheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wheel")
@RequiredArgsConstructor
public class WheelController {
    private final WheelService service;

    @GetMapping
    public List<Wheel> getAllWheels() {
        return service.getAllWheels();
    }

    @GetMapping(value = "/{id}")
    public Wheel getWheelById(@PathVariable Long id) {
        return service.getWheelById(id).orElse(null);
    }

    @PostMapping
    public void addWheel(@RequestBody WheelRequest wheelRequest) {
        service.addWheel(wheelRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteWheel(@PathVariable Long id) {
        service.deleteWheel(id);
    }

    @PutMapping(value = "/{id}")
    public Wheel updateWheel(@PathVariable Long id, @RequestBody WheelRequest updateWheel) {
        return service.updateWheel(id, updateWheel);
    }
}
