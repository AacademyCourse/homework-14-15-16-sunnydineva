package AacademyCourse.demohomeworkmodule14.service;

import AacademyCourse.demohomeworkmodule14.entity.User;
import AacademyCourse.demohomeworkmodule14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User userToBeCreated = new User();
        userToBeCreated.setFirstName(user.getFirstName());
        userToBeCreated.setLastName(user.getLastName());
        userToBeCreated.setEmail(user.getEmail());
        userToBeCreated.setPhone(user.getPhone());

        return userRepository.save(userToBeCreated);
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }
}
