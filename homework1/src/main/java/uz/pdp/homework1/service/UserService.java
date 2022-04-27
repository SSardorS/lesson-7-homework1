package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.Role;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.UserDto;
import uz.pdp.homework1.repository.RoleRepository;
import uz.pdp.homework1.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository usertRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addUser(UserDto userDto) {
        Optional<User> byUsername = usertRepository.findByUsername(userDto.getUserName());
        Optional<Role> roleById = roleRepository.findById(userDto.getRoleId());
        if (!byUsername.isPresent() && !roleById.isPresent())
            return new ApiResponse("Bunday user allaqachon qoshilgan", false);


        User user = new User(userDto.getFullName(), userDto.getUserName(), passwordEncoder.encode(userDto.getPassword()), roleById.get(), true);
        usertRepository.save(user);
        return new ApiResponse("Added", true);
    }
}
