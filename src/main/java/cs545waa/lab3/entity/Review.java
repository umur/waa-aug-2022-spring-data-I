package cs545waa.lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String comment;

    @JsonManagedReference
    @ManyToOne
    private User user;

    @JsonManagedReference
    @ManyToOne
    private Product product;
}
