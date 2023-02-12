package AacademyCourse.demohomeworkmodule14.runner;

import AacademyCourse.demohomeworkmodule14.entity.Address;
import AacademyCourse.demohomeworkmodule14.entity.Role;
import AacademyCourse.demohomeworkmodule14.entity.User;
import AacademyCourse.demohomeworkmodule14.entity.roleType;
import AacademyCourse.demohomeworkmodule14.repository.AddressRepository;
import AacademyCourse.demohomeworkmodule14.repository.RoleRepository;
import AacademyCourse.demohomeworkmodule14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setFirstName("UserFirstName1");
        user1.setLastName("UserLastName1");
        user1.setEmail("user1@email.com");
        user1.setCreatedAt(Instant.now());

        User user2 = new User();
        user2.setFirstName("UserFirstName2");
        user2.setLastName("UserLastName2");
        user2.setEmail("user2@email.com");
        user2.setCreatedAt(Instant.now());

        Set<User> users1 = new HashSet<>();
        users1.add(user1);
        Set<User> users2 = new HashSet<>();
        users2.add(user2);
        Set<User> users3 = new HashSet<>();
        users3.add(user1);
        users3.add(user2);

        Address address1 = new Address();
        address1.setCountry("Country1");
        address1.setCity("City1");
        address1.setStreet("Street1");
        address1.setStreetNumber("StNo1");
        address1.setUser(user2);

        Address address2 = new Address();
        address2.setCountry("Country2");
        address2.setCity("City2");
        address2.setStreet("Street2");
        address2.setStreetNumber("StrNo2");
        address2.setUser(user2);

        Address address3 = new Address();
        address3.setCountry("Country3");
        address3.setCity("City3");
        address3.setStreet("Street3");
        address3.setStreetNumber("StNo3");
        address3.setUser(user1);

// userRepository.save(user1) not working with the following lines:
//        Set<Address> addresses1 = new HashSet<>();
//        addresses1.add(address3);
//
//        Set<Address> addresses2 = new HashSet<>();
//        addresses2.add(address1);
//        addresses2.add(address2);
//
//        user1.setAddresses(addresses1);
//        user2.setAddresses(addresses2);

        Role role1 = new Role();
        role1.setType(roleType.ADMIN);
        role1.setUsers(users1); //user1

        Role role2 = new Role();
        role2.setType(roleType.CLIENT);
        role2.setUsers(users2); //user2

        Role role3 = new Role();
        role3.setType(roleType.USER);
        role3.setUsers(users3); //users3 = user1 & user2

// when using the following lines: "Hibernate: insert into user_role..." only once
// userRepository.save(user1) not working

//        Set<Role> roles1 = new HashSet<>();
//        Role role4 = new Role();
//        role4.setType(roleType.ADMIN);
//        roles1.add(role4);
//variant A of roles1
//        Set<Role> roles2 = new HashSet<>();
//        Role role5 = new Role();
//        role5.setType(roleType.ADMIN);
//        roles2.add(role5);
//variant B of roles1
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(role2);

//        user1.setRoles(roles1);
//        user2.setRoles(roles2);

        userRepository.save(user1);
        userRepository.save(user2);

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
    }
}
