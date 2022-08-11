package com.example.demo.entity.addressJiontable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserAddTable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String email;
   private String password;
   private  String firstName;
   private String lastname;

   @OneToOne(mappedBy = "user")
   private AddressTable address;

}
