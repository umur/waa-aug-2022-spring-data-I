package com.lab3.waaaug2022springdatai.jointable_bidir.repository;

import com.lab3.waaaug2022springdatai.jointable_bidir.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
