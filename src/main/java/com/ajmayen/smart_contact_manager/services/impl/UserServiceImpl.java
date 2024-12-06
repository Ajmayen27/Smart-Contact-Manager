package com.ajmayen.smart_contact_manager.services.impl;

import com.ajmayen.smart_contact_manager.helper.ResourceNotFoundException;
import com.ajmayen.smart_contact_manager.model.User;
import com.ajmayen.smart_contact_manager.repositories.UserRepository;
import com.ajmayen.smart_contact_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {

        User existingUser = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        existingUser.setAbout(user.getAbout());
        existingUser.setProfilePic(user.getProfilePic());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setEmailVerified(user.isEmailVerified());
        existingUser.setPhoneVerified(user.isPhoneVerified());
        existingUser.setProviders(user.getProviders());
        existingUser.setProviderUserId(user.getProviderUserId());

        return Optional.of(userRepository.save(existingUser));
    }


    @Override
    public void deleteUser(String id) {
       User existingUser = userRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("User not found"));
       userRepository.delete(existingUser);
    }


    @Override
    public boolean isUserExist(String userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(null);
        return existingUser != null ? true : false;
    }


    @Override
    public boolean isUserExistByEmail(String email) {
        User existingUser = userRepository.findByEmail(email).orElseThrow(null);
        return existingUser != null ? true : false;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
