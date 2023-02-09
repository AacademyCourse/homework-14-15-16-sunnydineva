package AacademyCourse.demohomeworkmodule14.runner;

import AacademyCourse.demohomeworkmodule14.entity.Address;
import AacademyCourse.demohomeworkmodule14.entity.User;
import AacademyCourse.demohomeworkmodule14.repository.AddressRepository;
import AacademyCourse.demohomeworkmodule14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        createUser();
        getUser();
        createAddress();
        getAddress();
    }

    public void createUser() {
        User user1 = new User();
        user1.setFirstName("UserFirstName1");
        user1.setLastName("UserLastName1");
        user1.setEmail("user1@email.com");
        user1.setCreatedAt(Instant.now());

        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("UserFirstName2");
        user2.setLastName("UserLastName2");
        user2.setEmail("user2@email.com");
        user2.setCreatedAt(Instant.now());

        userRepository.save(user2);
    }

    public void createAddress() {
        Address address1 = new Address();
        address1.setCountry("Country1");
        address1.setCity("City1");
        address1.setStreet("Street1");
        address1.setStreetNumber("StNo1");

        addressRepository.save(address1);

        Address address2 = new Address();
        address2.setCountry("Country2");
        address2.setCity("City2");
        address2.setStreet("Street2");
        address2.setStreetNumber("StrNo2");

        addressRepository.save(address2);
    }

    public void getUser() {
        Optional<User> user1 = userRepository.findById(1L);
        user1.ifPresent(value -> System.out.println());

        Optional<User> user2 = userRepository.findById(2L);
        user2.ifPresent(value -> System.out.println());
    }

    public void getAddress() {
        Optional<Address> address1 = addressRepository.findById(1L);
        address1.ifPresent(value -> System.out.println());

        Optional<Address> address2 = addressRepository.findById(2L);
        address2.ifPresent(value -> System.out.println());
    }
}
