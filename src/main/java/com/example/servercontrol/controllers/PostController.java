package com.example.servercontrol.controllers;

import com.example.servercontrol.model.Post;
import com.example.servercontrol.model.User;
import com.example.servercontrol.services.PostService;
import com.example.servercontrol.services.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @PostMapping("{username}")
    public Post createPost(@PathVariable String username, @RequestBody Post post) throws ChangeSetPersister.NotFoundException {
        User user = this.userService.getUserByUsername(username);
        return this.postService.createPost(user,post);
    }
}
