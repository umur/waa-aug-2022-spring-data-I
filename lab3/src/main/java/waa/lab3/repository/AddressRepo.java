package waa.lab3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab3.entity.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
