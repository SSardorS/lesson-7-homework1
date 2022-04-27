package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.exeptions.ResourseNotFoundExeption;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.RegisterDto;
import uz.pdp.homework1.repository.RoleRepository;
import uz.pdp.homework1.repository.UserRepository;
import uz.pdp.homework1.utils.AppConstans;


@Service
public class AuthServie implements UserDetailsService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository usertRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPrePassword())){
            return new ApiResponse("Password mos emas berildi", false);
        }

        if (usertRepository.existsByUsername(registerDto.getUserName())){
            return new ApiResponse("Bunday user name avval royhatdan otgan", false);
        }

        User user = new User(registerDto.getFullName(), registerDto.getUserName(),  passwordEncoder.encode(registerDto.getPassword()), roleRepository.findByName(AppConstans.user).orElseThrow(()-> new ResourseNotFoundExeption("Role", "name", AppConstans.user)), true);
        usertRepository.save(user);
        return new ApiResponse("Muvafaqiyatli royhatdan otildi", true);
    }

    public UserDetails loadUserByUsername(String userName) {
        return  usertRepository.findByUsername(userName).orElseThrow(()->new UsernameNotFoundException(userName));
    }
}
