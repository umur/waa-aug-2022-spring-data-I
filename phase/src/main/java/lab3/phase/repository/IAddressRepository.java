package lab3.phase.repository;

import lab3.phase.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address, Integer> {
}
