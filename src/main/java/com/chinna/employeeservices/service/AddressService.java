package com.chinna.employeeservices.service;

import java.util.List;

import com.chinna.employeeservices.entity.Address;

public interface AddressService {
	
	public Address addAddress(Address address);
	public List<Address> getAllAddress();
	public Address getAddress(int id);
	public Address updateAddress(Address address);

}
