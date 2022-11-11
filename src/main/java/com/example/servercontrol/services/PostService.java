package com.example.servercontrol.services;

import com.example.servercontrol.model.Post;
import com.example.servercontrol.model.User;
import com.example.servercontrol.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public List<Post> getAllPosts(){
        return this.postRepo.findAll();
    }

    public  Post createPost(User user, Post post){
        user.getProfile().setPosts(Arrays.asList(post));
        post.setProfile(user.getProfile());
        post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return this.postRepo.save(post);
    }
}
