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

        Role role1 = new Role();
        role1.setType(roleType.ADMIN);

        Role role2 = new Role();
        role2.setType(roleType.CLIENT);

        Role role3 = new Role();
        role3.setType(roleType.USER);

        Role role4 = new Role();
        role4.setType(roleType.ADMIN);

        Role role5 = new Role();
        role5.setType(roleType.ADMIN);

        Set<Role> roles1 = Set.of(role1, role2, role3, role4);
        Set<Role> roles2 = Set.of(role2, role3, role4, role5);

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);
        roleRepository.save(role4);
        roleRepository.save(role5);

        User user1 = new User();
        user1.setFirstName("UserFirstName1");
        user1.setLastName("UserLastName1");
        user1.setEmail("user1@email.com");
        user1.setCreatedAt(Instant.now());
        user1.setRoles(roles1);

        User user2 = new User();
        user2.setFirstName("UserFirstName2");
        user2.setLastName("UserLastName2");
        user2.setEmail("user2@email.com");
        user2.setCreatedAt(Instant.now());
        user2.setRoles(roles2);

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

        userRepository.save(user1);
        userRepository.save(user2);

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
    }
}
