package com.amarthya.springboot_mongo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@NotBlank(message = "County should'nt be empty")
	private String country;
	@NotBlank(message = "State should'nt be empty")
	private String state;
	@NotBlank(message = "City should'nt be empty")
	private String city;
	@Pattern(regexp = "([1-9]{1}[0-9]{5})", message = "Please provide a valid pincode")
	private String pinCode;

}
