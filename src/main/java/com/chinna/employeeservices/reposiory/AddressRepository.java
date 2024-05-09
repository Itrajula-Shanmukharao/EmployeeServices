package com.chinna.employeeservices.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinna.employeeservices.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
