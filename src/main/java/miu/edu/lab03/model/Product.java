package miu.edu.lab03.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double price;
    private Double rating;

    @ManyToOne
    private Category category;

//    @JoinColumn
//    @OneToMany
//    private List<Review> reviews;
}
