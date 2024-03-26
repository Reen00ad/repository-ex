package com.example.repositoryex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 4,message = "name length must be greater than 4")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotEmpty(message = "username should not be empty")
    @Size(min = 4,message = "username length must be greater than 4")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;
    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "varchar(15) not null ")
    private String password;
    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "role should not be null")
    @Pattern(regexp ="^(user|Admin)$", message = "role must be Admin or user only")
    @Column(columnDefinition = "varchar(5) not null check ( role='user' or role='Admin')")
    private String role;
    @NotNull(message = "age should not be null")
    //@Pattern(regexp = "^[0-9]+$",message = "age must be a number")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
