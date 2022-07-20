/**
 * 
 */
package com.miu.Lab3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author laithnassar
 *
 */
@Data
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", initialValue = 1)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
	private int id;

	private String name;

	private int price;

	private int rating;
	
	@JsonBackReference
	@ManyToOne
	private Category category;

}
