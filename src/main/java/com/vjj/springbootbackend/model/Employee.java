package com.vjj.springbootbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {
	
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Field
private Long id;

//@Indexed(name="firstName", type="string")
@Field
@Column(name="first_name")
private String firstName;

//@Indexed(name="middleName", type="string")
@Field
@Column(name="middle_name")
private String middleName;

//@Indexed(name="lastName", type="string")
@Field
@Column(name="last_name")
private String lastName;

//@Indexed(name="mobileNo", type="string")
@Field
@Column(name="mobileNo")
private String mobileNo;

//@Indexed(name="emailId", type="string")
@Field
@Column(name="emailId")
private String emailId;

//@Indexed(name="address", type="string")
@Field
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn
private Address address;

//@Indexed(name="active", type="boolean")
@Field
@Column(name="active")
private Boolean active;

public Employee(Long id, String firstName, String middleName, String lastName, String mobileNo, String emailId,
		Address address, Boolean active) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.mobileNo = mobileNo;
	this.emailId = emailId;
	this.address = address;
	this.active= active;
}



public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
			+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", address=" + address + ", active=" + active + "]";
}



}
