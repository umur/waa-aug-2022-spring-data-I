package edu.miu.lab3.repository;

import edu.miu.lab3.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address,Integer> {
}
