package com.fin.manager.User.business_rules;

import com.fin.manager.User.DTOs.LoginRequestDTO;
import com.fin.manager.User.DTOs.RegisterRequestDTO;
import com.fin.manager.User.DTOs.ResponseDTO;
import com.fin.manager.User.adapters.TokenProvider;
import com.fin.manager.User.entity.User;
import com.fin.manager.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthBusinessService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public ResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user = this.repository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = this.tokenProvider.generateToken(user);
        return new ResponseDTO(user.getName(), token);
    }

    public ResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        repository.findByEmail(registerRequestDTO.email())
                .ifPresent(u -> { throw new RuntimeException("User already exists"); });

        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(registerRequestDTO.password()));
        newUser.setEmail(registerRequestDTO.email());
        newUser.setName(registerRequestDTO.name());
        this.repository.save(newUser);

        String token = this.tokenProvider.generateToken(newUser);
        return new ResponseDTO(newUser.getName(), token);
    }
}