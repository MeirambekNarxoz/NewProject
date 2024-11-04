package Kolesa.Service;

import Kolesa.Dto.AuthenticationRequest;
import Kolesa.Dto.RegisterRequest;
import Kolesa.Model.Role;
import Kolesa.Model.User;
import Kolesa.Repository.RoleRepository;
import Kolesa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUserById(Long id, User updateUser) {
        User existingUser = repository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }

        if (updateUser.getName() != null) {
            existingUser.setName(updateUser.getName());
        }
        if (updateUser.getEmail() != null) {
            existingUser.setEmail(updateUser.getEmail());
        }
        if (updateUser.getContact() != null) {
            existingUser.setContact(updateUser.getContact());
        }
        if (updateUser.getPassword() != null) {
            existingUser.setPassword(hashPassword(updateUser.getPassword()));
        }
        return repository.save(existingUser); // Возвращаем обновленного пользователя
    }

    public boolean deleteUserById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public User register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(hashPassword(request.getPassword()));
        user.setContact(request.getContact());

        Role defaultRole = roleRepository.findById(2L).orElseThrow(() ->
                new IllegalStateException("Default role not found"));

        user.setRole(defaultRole);
        return repository.save(user); // Возвращаем созданного пользователя
    }

    public User authenticate(AuthenticationRequest request) {
        User user = repository.findByEmail(request.getEmail()).orElseThrow(() ->
                new RuntimeException("Invalid email or password"));

        if (!checkPassword(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 hashing error", e);
        }
    }

    private boolean checkPassword(String rawPassword, String hashedPassword) {
        return hashPassword(rawPassword).equals(hashedPassword);
    }
}
