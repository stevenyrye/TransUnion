package com.transunion.homework.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;
  
  @Column(name = "address")
  private String address;
  
  @Column(name = "dob")
  private Date dateOfBirth;

  @Column(name = "phone_no")
  private String phoneNo;

  @Column(name = "title")
  private String title;

  @Column(name = "sin")
  private String sin;
  
  @Override
  public String toString() {
	  return "Employee: "
			  + "id = " + this.id + "; "
			  + "name = " + this.name + "; "
			  + "address = " + this.address + "; "
			  + "dateOfBirth = " + this.dateOfBirth + "; "
			  + "phoneNo = " + this.phoneNo + "; "
			  + "title = " + this.title + "; "
			  + "sin = " + this.sin + "; "
			  ;
  }

}

