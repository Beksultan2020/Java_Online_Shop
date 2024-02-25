package SpringSecurity.Java_Online_Shop.services;


import SpringSecurity.Java_Online_Shop.dto.UserDto;
import SpringSecurity.Java_Online_Shop.modal.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
List<UserDto> getAllUsers();
UserDto addUser(User user);

UserDto getUser(Long id);

UserDto updateUser(UserDto userDto);

String updatePassword(User user);

void deleteUser(Long id);

List<UserDto> searchUser(String text);
}
