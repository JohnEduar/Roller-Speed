package com.speedroller.demo.Controller;

import com.speedroller.demo.Config.JwtUtil;
import com.speedroller.demo.Model.User;
import com.speedroller.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Controller;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna la vista login.html
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return jwtUtil.generateToken(existingUser.getUsername());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public Map<String, String> register(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");
        response.put("username", user.getUsername());
        return response;
    }
}