package Kolesa.Mapper;

import Kolesa.Dto.Request.WheelRequest;
import Kolesa.Model.Wheel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WheelMapper {
    WheelRequest toDto(Wheel wheel);
    Wheel toModel(WheelRequest request);
    List<WheelRequest> toDtoList(List<Wheel> wheelList);
    List<Wheel> toModelList(List<WheelRequest> requestList);
}
