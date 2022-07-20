/**
 * 
 */
package com.miu.Lab3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author laithnassar
 *
 */
@Data
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", initialValue = 1)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
	private int id;

	private String street;
	private String zip;
	private String city;

	@OneToOne
	private User user;
}
