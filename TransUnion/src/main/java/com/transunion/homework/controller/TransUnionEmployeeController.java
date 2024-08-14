package com.transunion.homework.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transunion.homework.persistence.entity.Employee;
import com.transunion.homework.persistence.repository.EmployeeRepository;


@RestController
@RequestMapping
public class TransUnionEmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransUnionEmployeeController.class);

	@Autowired
	EmployeeRepository repository;

	@GetMapping(value = "/employee", produces = { "application/json" })
	public ResponseEntity<List<Employee>> findEmployee(@RequestParam(required = false) Integer age,
			@RequestParam(required = false) String title) {
		
		LOGGER.info("GET: employee age = {}; title = {}", age, title);
		List<Employee> ret = null;
		try {
			if (age == null && !StringUtils.hasText(title)) {
				ret = repository.findAll();
				LOGGER.info("get ALL employee succeed");
			} else {
				Date pastDate = null;
				if (age != null) {
					LocalDate currentDate = LocalDate.now();
					pastDate = Date.from(currentDate.minusYears(age).atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				if (StringUtils.hasText(title) && pastDate != null) {
					ret = repository.findByTitleAndDateOfBirthLessThanEqual(title, pastDate);
					LOGGER.info("get employee by title and age succeed");
				}
				if (StringUtils.hasText(title) && pastDate == null) {
					ret = repository.findByTitle(title);
					LOGGER.info("get employee by title succeed");
				}
				if (!StringUtils.hasText(title) && pastDate != null) {
					ret = repository.findByDateOfBirthLessThanEqual(pastDate);
					LOGGER.info("get employee by age succeed");
				}
			}
			
			if (ret == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(ret, HttpStatus.OK);
			}
		} catch (Throwable t) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	  @PostMapping(value = "/employee", produces = { "application/json" })
	  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	    LOGGER.info("Processing POST url: /employee; payload: {}", employee);
		if (employee.getAddress() == null || employee.getDateOfBirth() == null || employee.getName() == null
				|| employee.getPhoneNo() == null || employee.getSin() == null || employee.getTitle() == null) {
			LOGGER.error("invalid employee data: {}", employee);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (employee.getSin().length() > 4) {
			employee.setSin(employee.getSin().substring(employee.getSin().length()-4));
		}
		try {
			Employee ret = repository.save(employee);
	        LOGGER.info("record inserted into db. record = {}", ret); 
	        return new ResponseEntity<>(ret, HttpStatus.OK);

		} catch (Throwable t) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }

}
