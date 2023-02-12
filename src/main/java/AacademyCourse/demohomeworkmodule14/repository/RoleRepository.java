package AacademyCourse.demohomeworkmodule14.repository;

import AacademyCourse.demohomeworkmodule14.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
