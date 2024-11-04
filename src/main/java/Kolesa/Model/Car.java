package Kolesa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private Integer mileage;
    private String color;
    private String location;
    private byte[] imageData;
    private LocalDate release_date;
    @Column(columnDefinition = "TEXT")
    private String description;
    public LocalDate getReleaseDate() {
        return release_date;
    }
}
