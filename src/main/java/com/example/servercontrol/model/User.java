package com.example.servercontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne(mappedBy = "user")
    private Profile profile;
/*
    @ManyToMany
    List<Profile> following;
*/
    private Timestamp createdDate;
    private Timestamp updatedDate;


}
