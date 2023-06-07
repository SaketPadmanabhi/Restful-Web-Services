package com.socialchat.rest.webservices.restfulwebservices.jpa;

import com.socialchat.rest.webservices.restfulwebservices.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

}
