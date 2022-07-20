/**
 * 
 */
package com.miu.Lab3.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author laithnassar
 *
 */
@Data
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", initialValue = 1)
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
	private int id;

	private String email;
	private String password;
	private String firstName;
	private String lastname;
	
	@OneToOne(mappedBy = "user")
	private Address address;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;	
}
