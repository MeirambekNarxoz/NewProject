package Kolesa.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private Integer mileage;
    private String color;
    private String location;
    private byte[] imageData;
    private LocalDate releaseDate;
    private String description;
}
