package com.chinna.employeeservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinna.employeeservices.entity.Address;
import com.chinna.employeeservices.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Address>> getAllAddress(){
		return new ResponseEntity<>(addressService.getAllAddress(),HttpStatus.OK);
	}
	
	@GetMapping("/getAddress/{id}")
	public Address getAddress(@PathVariable int id) {
		return addressService.getAddress(id);
	}
	
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}

}
