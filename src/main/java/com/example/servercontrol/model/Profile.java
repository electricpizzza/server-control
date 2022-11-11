package com.example.servercontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String profileImage;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",unique = true)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    List<Post> posts;

    @ManyToMany
    List<User> folowers;

    private Timestamp createdDate;
    private Timestamp updatedDate;
}
