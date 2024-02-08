package ru.practicum.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserRepository userRepository;

    @GetMapping
    public List<UserDto> getAll(){
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(UserMapper.mapToUserDto(user)));
        return users;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto){
        userRepository.save(UserMapper.mapToNewUser(userDto));
        return userDto;
    }
}
