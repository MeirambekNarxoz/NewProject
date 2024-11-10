package Kolesa.Mapper;

import Kolesa.Dto.Response.UserResponse;
import Kolesa.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "role.name", target = "role")
    UserResponse toDto(User user);
    @Mapping(source = "role", target = "role.name")
    User toModel(UserResponse response);

    List<UserResponse> toDtoList(List<User> userList);
    List<User> toModelList(List<UserResponse> responseList);
}
