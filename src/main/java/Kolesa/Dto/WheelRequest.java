package Kolesa.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WheelRequest {
    private String size;
    private String type;
    private Double price;
    private String brand;
    private String description;
}
