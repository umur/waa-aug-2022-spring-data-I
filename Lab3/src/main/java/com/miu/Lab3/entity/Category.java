/**
 * 
 */
package com.miu.Lab3.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(name = "CATEGORY_SEQ", sequenceName = "CATEGORY_SEQ", initialValue = 1)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
	private int id;

	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private List<Product> products;

}
