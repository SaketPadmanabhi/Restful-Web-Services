package com.socialchat.rest.webservices.restfulwebservices.users;

import com.socialchat.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.socialchat.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class User_JPA_Controller {

    private UserRepository userRepository;

    private PostRepository postRepository;
    public User_JPA_Controller(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository=postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();   // here the findAll() function fetches data from the database, this is not the static data that we declared in the userDao, this function with help of JPA queries the DB
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUserbyId(@PathVariable  int id){
        Optional<User> user =  userRepository.findById(id);   //JPA function

        if(user.isEmpty()){
            throw new UserNotFoundExpection("id:"+id);
        }
        else{
            EntityModel<User> entityModel = EntityModel.of(user.get());
            WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
            entityModel.add(link.withRel("all-users"));
            return entityModel;
        }
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        //return uri of user which is newly created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable  int id){
        userRepository.deleteById(id);
    }

    @GetMapping ("/jpa/users/{id}/posts")
    public List<Post> retrievePostforUser(@PathVariable  int id){
        Optional<User> user =  userRepository.findById(id);   //JPA function

        if(user.isEmpty()){
            throw new UserNotFoundExpection("id:"+id);
        }
        else{
            return user.get().getPostList();
        }
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Objects> createPostforUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user =  userRepository.findById(id);   //JPA function

        if(user.isEmpty()){
            throw new UserNotFoundExpection("id:"+id);
        }
        else{
            post.setUser(user.get());
            Post savedPost = postRepository.save(post);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedPost.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
    }
}
