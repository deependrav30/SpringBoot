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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="address")
public class Address {
	
	
@Id
@Field
private Long id;

//@Indexed(name="firstName", type="string")
@Field
private String address;


@Field
private String post;


public Address(Long id, String address, String post) {
	super();
	this.id = id;
	this.address = address;
	this.post = post;
}


public Address() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "Address [id=" + id + ", address=" + address + ", post=" + post + "]";
}






}
