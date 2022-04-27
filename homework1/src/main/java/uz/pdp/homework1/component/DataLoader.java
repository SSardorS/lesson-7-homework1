package uz.pdp.homework1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.homework1.entity.Role;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.entity.enums.Permission;
import uz.pdp.homework1.repository.RoleRepository;
import uz.pdp.homework1.repository.UserRepository;
import uz.pdp.homework1.utils.AppConstans;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository usertRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            Permission[] permissions = Permission.values();
            Role admin = roleRepository.save(new Role(
                    AppConstans.admin,
                    Arrays.asList(permissions),
                    "sitema egasi"
            ));

            Role user = roleRepository.save(new Role(
                    AppConstans.user,
                    Arrays.asList(Permission.ADD_COMMET, Permission.EDIT_COMMET, Permission.DELETE_COMMET),
                    "odiy foydalanuvchi"
            ));

            usertRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true


            ));

            usertRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true


            ));
        }

    }
}
