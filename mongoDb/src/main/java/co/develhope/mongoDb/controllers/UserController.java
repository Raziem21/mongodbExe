package co.develhope.mongoDb.controllers;

import co.develhope.mongoDb.entities.User;
import co.develhope.mongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User createUser(@RequestBody User user) {
       return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @PutMapping("/{id")
    public User editUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }

}
