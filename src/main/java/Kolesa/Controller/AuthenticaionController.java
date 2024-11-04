package Kolesa.Controller;

import Kolesa.Dto.AuthenticationRequest;
import Kolesa.Dto.RegisterRequest;
import Kolesa.Model.User;
import Kolesa.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/authentication")
@RequiredArgsConstructor
public class AuthenticaionController {
    private final AuthenticationService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody RegisterRequest request) {
        return service.register(request);
    }
    @PostMapping(value = "/login")
    public User login(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return service.updateUserById(id,updateUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
    }
}
