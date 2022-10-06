package com.example.servercontrol.services;

import com.example.servercontrol.model.Profile;
import com.example.servercontrol.model.User;
import com.example.servercontrol.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    public User getUserById(Long id) throws NotFoundException {
        return this.userRepo.findById(id).orElseThrow(NotFoundException::new);
    }
    public User getUserByUsername(String username) throws NotFoundException {
        return this.userRepo.findByUsername(username);
    }

    public User findByUsername(String userName){
        return null;
    }

    public User create(User user){
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return this.userRepo.save(user);
    }

    public User update(Long id,User user) throws NotFoundException {
       return this.userRepo.findById(id).map(usr -> {
            usr.setName(user.getName());
            usr.setEmail(user.getEmail());
            usr.setUsername(user.getUsername());
            usr.setPassword(user.getPassword());
            usr.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
           return this.userRepo.save(usr);
        }).orElseThrow(NotFoundException::new);

    }

    public Boolean delete(Long id) throws NotFoundException {
        return this.userRepo.findById(id).map(user -> {
             this.userRepo.delete(user);
             return true;
        }).orElseThrow(NotFoundException::new);
    }

    public Profile getUserProfile(Long id) throws NotFoundException {
        return this.userRepo.findById(id).map(user -> user.getProfile()).orElseThrow(NotFoundException::new);
    }
}
