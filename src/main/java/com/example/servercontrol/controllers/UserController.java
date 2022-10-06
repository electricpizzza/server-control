package com.example.servercontrol.controllers;

import com.example.servercontrol.model.Profile;
import com.example.servercontrol.model.User;
import com.example.servercontrol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return this.userService.getAllUsers();
    }

    @GetMapping("{username}")
    public User getById(@PathVariable("username") String username) throws ChangeSetPersister.NotFoundException {
        return this.userService.getUserByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userService.create(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User user) throws ChangeSetPersister.NotFoundException {
        return this.userService.update(id,user);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return  this.userService.delete(id);
    }

    @GetMapping("{id}/profile")
    public Profile getProfile(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.userService.getUserProfile(id);
    }
}
