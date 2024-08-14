package com.transunion.homework.persistence.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.transunion.homework.persistence.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Object> {

  List<Employee> findAll();
  
  List<Employee> findByTitle(String title);

  List<Employee> findByDateOfBirthLessThanEqual(Date oldDate);

  List<Employee> findByTitleAndDateOfBirthLessThanEqual(String title, Date oldDate);
}
