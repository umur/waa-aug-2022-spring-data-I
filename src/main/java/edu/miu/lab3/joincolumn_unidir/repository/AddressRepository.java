package edu.miu.lab3.joincolumn_unidir.repository;

import edu.miu.lab3.joincolumn_unidir.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
