package AacademyCourse.demohomeworkmodule14.repository;

import AacademyCourse.demohomeworkmodule14.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
