package SpringSecurity.Java_Online_Shop.mapper;


import SpringSecurity.Java_Online_Shop.dto.UserDto;
import SpringSecurity.Java_Online_Shop.modal.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);


    User toEntity(UserDto userDto);
    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> userDtos);

}
