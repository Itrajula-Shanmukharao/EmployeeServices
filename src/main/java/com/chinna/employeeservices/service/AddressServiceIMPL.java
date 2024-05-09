package com.chinna.employeeservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinna.employeeservices.entity.Address;
import com.chinna.employeeservices.reposiory.AddressRepository;

@Service
public class AddressServiceIMPL implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public List<Address> getAllAddress(){
		return addressRepository.findAll();
	}
	
	public Address getAddress(int id) {
		return addressRepository.findById(id).get();
	}
	
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

}
