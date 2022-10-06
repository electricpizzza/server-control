package com.example.servercontrol.model;

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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String caption;

    @ManyToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany
    private List<User> likes;

    private Timestamp createdDate;
    private Timestamp updatedDate;
}
