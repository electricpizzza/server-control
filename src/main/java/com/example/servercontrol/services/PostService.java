package com.example.servercontrol.services;

import com.example.servercontrol.model.Post;
import com.example.servercontrol.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public List<Post> getAllPosts(){
        return this.postRepo.findAll();
    }


}
