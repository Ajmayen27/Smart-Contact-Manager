package com.ajmayen.smart_contact_manager.repositories;

import com.ajmayen.smart_contact_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
