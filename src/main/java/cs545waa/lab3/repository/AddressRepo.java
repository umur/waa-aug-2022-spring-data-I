package cs545waa.lab3.repository;

import cs545waa.lab3.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}
