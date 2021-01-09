package com.amarthya.springboot_mongo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amarthya.springboot_mongo.model.EmployeeModel;

@Repository
public interface EmployeeRepository
		extends MongoRepository<EmployeeModel, String>, PagingAndSortingRepository<EmployeeModel, String> {

	Page<EmployeeModel> findAll(Pageable pageable);

	List<EmployeeModel> findByExperienceBetween(int low, int high);

	Page<EmployeeModel> findByExperienceBetween(int low, int high, Pageable pageable);

	@Query("{'address.city':?0}")
	List<EmployeeModel> findByCity(String city);

	@Query("{'address.city':?0}")
	Page<EmployeeModel> findByCityByPage(String city, Pageable pageable);

}
