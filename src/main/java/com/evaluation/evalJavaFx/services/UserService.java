package com.evaluation.evalJavaFx.services;

import com.evaluation.evalJavaFx.dtos.LocalUserDTO;
import com.evaluation.evalJavaFx.models.LocalUser;
import com.evaluation.evalJavaFx.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LocalUser addUser(LocalUserDTO userFormDTO) {
        LocalUser newUser = new LocalUser();
        newUser.setUsername(userFormDTO.username());
        newUser.setPassword(passwordEncoder.encode(userFormDTO.password()));
        newUser.setRole("USER");
        userRepository.save(newUser);

        return newUser;
    }
}
