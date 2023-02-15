package AacademyCourse.demohomeworkmodule14.service;

import AacademyCourse.demohomeworkmodule14.entity.Role;
import AacademyCourse.demohomeworkmodule14.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role savedRole(Role role){
        Role roleToBeCreated = new Role();
        roleToBeCreated.setType(role.getType());
        roleToBeCreated.setUsers(role.getUsers()); // ?
        return roleRepository.save(roleToBeCreated);
    }

    public Optional<Role> getById(Long id){
        return roleRepository.findById(id);
    }

    public void deleteById(Long id){
        this.roleRepository.deleteById(id);
    }
}
