package Kolesa.Mapper;

import Kolesa.Dto.Request.CarRequest;
import Kolesa.Model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "releaseDate", target = "release_date")
    Car toModel(CarRequest request);
    @Mapping(source = "release_date", target = "releaseDate")
    CarRequest toDto(Car car);
    List<CarRequest> toDtoList(List<Car> carList);
    List<Car> toModelList(List<CarRequest> requestList);
}
