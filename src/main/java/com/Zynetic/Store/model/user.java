package com.Zynetic.Store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private UUID userID;

    @NotBlank(message = "Email is mandatory")
    @Size(max = 50)
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "password is mandatory")
    @Size(min = 6, max = 120,message = "Password must be between 6 and 120 characters")
    @Column(name = "password")
    private String password;

    public user(String username,String password,String email){
        this.password=password;
        this.email=email;
    }




}
