package AacademyCourse.demohomeworkmodule14.controller;

import AacademyCourse.demohomeworkmodule14.entity.User;
import AacademyCourse.demohomeworkmodule14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping(path = "add")
    public User createUser(@RequestBody User user) {
        User userToBeCreated = new User();
        userToBeCreated.setFirstName(user.getFirstName());
        userToBeCreated.setLastName(user.getLastName());
        userToBeCreated.setEmail(user.getPhone());
        userToBeCreated.setCreatedAt(user.getCreatedAt());
        userToBeCreated.setPhone(user.getPhone());

        return this.userService.saveUser(userToBeCreated);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteUser(@PathVariable Long id){
        this.userService.deleteById(id);
        return String.format("User with %s id is deleted", id);
    }
}
