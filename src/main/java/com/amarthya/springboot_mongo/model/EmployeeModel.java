package com.amarthya.springboot_mongo.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="employee")
public class EmployeeModel {
	
	@Id
	private String id;
	
	@NotBlank(message = "Name should'nt be empty")
	private String name;
	
	@Email
	@NotBlank(message = "Email should'nt be empty")
	private String emailId;
	
	@Pattern(regexp = "([0-9]{10})", message = "Please provide correct phone number")
	private String mobileNumber;

	@Valid
	private Address address;

	private int experience;

	private List<Comments> comments;
	

	public EmployeeModel(String name, String emailId, String mobileNumber, Address address, int experience,
			List<Comments> comments) {

		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.experience = experience;
		this.comments = comments;
	}


}
