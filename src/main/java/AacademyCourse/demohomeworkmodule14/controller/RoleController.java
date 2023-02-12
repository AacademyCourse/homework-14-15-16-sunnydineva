package AacademyCourse.demohomeworkmodule14.controller;

import AacademyCourse.demohomeworkmodule14.entity.Role;
import AacademyCourse.demohomeworkmodule14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/get/{id}")
    public Optional<Role> getRole(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping("/add")
    public Role createRole(@RequestBody Role role) {
        Role roleToBeCreated = new Role();
        roleToBeCreated.setType(role.getType());
        roleToBeCreated.setUsers(role.getUsers()); // ?
        return this.roleService.savedRole(roleToBeCreated);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteRole(@PathVariable Long id){
        this.roleService.deleteById(id);
        return String.format("Role with %s id is deleted", id);
    }
}
