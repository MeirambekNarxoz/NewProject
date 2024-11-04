package Kolesa.Service;

import Kolesa.Dto.WheelRequest;
import Kolesa.Model.Wheel;
import Kolesa.Repository.WheelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WheelService {
    private final WheelRepository repository;

    public void addWheel(WheelRequest wheelRequest) {
        // Convert WheelRequest DTO to Wheel entity
        Wheel wheelEntity = new Wheel();
        wheelEntity.setSize(wheelRequest.getSize());
        wheelEntity.setType(wheelRequest.getType());
        wheelEntity.setPrice(wheelRequest.getPrice());
        wheelEntity.setBrand(wheelRequest.getBrand());
        wheelEntity.setDescription(wheelRequest.getDescription());

        repository.save(wheelEntity);
    }

    public List<Wheel> getAllWheels() {
        return repository.findAll();
    }

    public Optional<Wheel> getWheelById(Long id) {
        return repository.findById(id);
    }

    public void deleteWheel(Long id) {
        repository.deleteById(id);
    }

    public Wheel updateWheel(Long id, WheelRequest updateWheel) {
        return repository.findById(id).map(existingWheel -> {
            if (updateWheel.getSize() != null) {
                existingWheel.setSize(updateWheel.getSize());
            }
            if (updateWheel.getType() != null) {
                existingWheel.setType(updateWheel.getType());
            }
            if (updateWheel.getPrice() != null) {
                existingWheel.setPrice(updateWheel.getPrice());
            }
            if (updateWheel.getBrand() != null) {
                existingWheel.setBrand(updateWheel.getBrand());
            }
            if (updateWheel.getDescription() != null) {
                existingWheel.setDescription(updateWheel.getDescription());
            }
            return repository.save(existingWheel);
        }).orElse(null);
    }
}
