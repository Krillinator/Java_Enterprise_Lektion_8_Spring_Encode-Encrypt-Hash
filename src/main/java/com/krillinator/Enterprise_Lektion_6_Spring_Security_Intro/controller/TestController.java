package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.controller;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.authorities.UserRole;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.config.AppPasswordConfig;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.model.CustomUser;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestController {

    private final AppPasswordConfig appPasswordConfig;
    private final UserRepository userRepository;

    @Autowired
    public TestController(AppPasswordConfig appPasswordConfig, UserRepository userRepository) {
        this.appPasswordConfig = appPasswordConfig;
        this.userRepository = userRepository;
    }

    @GetMapping("/hash")
    public String testHash() {

        return appPasswordConfig.bcryptPasswordEncoder().encode("123");
    }

    @GetMapping("/createUser")
    public CustomUser testCreateUser(BCryptPasswordEncoder bCryptPasswordEncoder) {

        CustomUser customUser = new CustomUser(
                "Benny",
                bCryptPasswordEncoder.encode("123"),
                UserRole.ADMIN,
                true,
                true,
                true,
                true
        );

        userRepository.save(customUser);

        return customUser;
    }

    @GetMapping("/findUser")
    public Optional<CustomUser> findUser(@RequestParam String username) {

        return userRepository.findByUsername(username);
    }

}

