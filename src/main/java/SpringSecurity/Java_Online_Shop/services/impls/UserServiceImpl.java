package SpringSecurity.Java_Online_Shop.services.impls;

import SpringSecurity.Java_Online_Shop.dto.UserDto;
import SpringSecurity.Java_Online_Shop.mapper.UserMapper;

import SpringSecurity.Java_Online_Shop.modal.Permission;
import SpringSecurity.Java_Online_Shop.modal.User;

import SpringSecurity.Java_Online_Shop.repositories.PermissionRepository;
import SpringSecurity.Java_Online_Shop.repositories.UserRepository;
import SpringSecurity.Java_Online_Shop.services.UserService;

import SpringSecurity.Java_Online_Shop.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("USER NOT FOUND!");
        }

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userMapper.toDtoList(userList);
        return userDtoList;
    }

    @Override
    public UserDto addUser(User user) {
        User newUser = userRepository.findByEmail(user.getEmail());
        if (newUser == null) {
            User user1 = new User();
            Permission role = permissionRepository.findByRole(Constants.ROLE_DEFAULT);
            user1.setRoles(List.of(role));
            user1.setFullName(user.getFullName());
            user1.setEmail(user.getEmail());
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            User saveInDto = userRepository.save(user1);
            return userMapper.toDto(saveInDto);

        }
        return null;
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDto userDto = userMapper.toDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            user.setFullName(userDto.getFullName());
            User updateUser = userRepository.save(user);
            return userMapper.toDto(updateUser);
        }
        return null;
    }

    @Override
    public String updatePassword(User user) {
        User currentUser=userRepository.findByEmail(user.getEmail());
        if(currentUser!=null){
            currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
             userRepository.save(currentUser);
             return "success";
        }
        return "error";
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> searchUser(String text) {
        List<User> userList = userRepository.findAllByFullNameContainsIgnoreCase(text);
        return userMapper.toDtoList(userList);
    }
}
