package com.fin.manager.User.controller;

import com.fin.manager.User.DTOs.LoginRequestDTO;
import com.fin.manager.User.DTOs.RegisterRequestDTO;
import com.fin.manager.User.DTOs.ResponseDTO;
import com.fin.manager.User.business_rules.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        ResponseDTO response = authBusinessService.login(loginRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        ResponseDTO response = authBusinessService.register(registerRequestDTO);
        return ResponseEntity.ok(response);
    }
}
