package miu.edu.lab03.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
