package edu.miu.lab3springdata.repository;

import edu.miu.lab3springdata.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
