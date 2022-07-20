/**
 * 
 */
package com.miu.Lab3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name = "REVIEW_SEQ", sequenceName = "REVIEW_SEQ", initialValue = 1)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_SEQ")
	private int id;

	private String comment;

	@JsonBackReference
	@ManyToOne
	private User user;

}
