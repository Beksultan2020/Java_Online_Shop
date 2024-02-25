package SpringSecurity.Java_Online_Shop.api;


import SpringSecurity.Java_Online_Shop.dto.UserDto;
import SpringSecurity.Java_Online_Shop.modal.User;
import SpringSecurity.Java_Online_Shop.services.impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public UserDto getUser(@PathVariable(value = "id") Long id) {
        return userServiceImpl.getUser(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @PutMapping(value = "/updateName")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userServiceImpl.updateUser(userDto);
    }

    @PutMapping
    public String updatePassword(@RequestBody User user){
        return userServiceImpl.updatePassword(user);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userServiceImpl.deleteUser(id);
    }

    @GetMapping(value = "/searchUser/{text}")
    public List<UserDto> searchUser(@PathVariable(value = "text") String text){
        return userServiceImpl.searchUser(text);
    }

}
