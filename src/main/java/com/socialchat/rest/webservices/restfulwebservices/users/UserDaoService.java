package com.socialchat.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    //JPA/Hibernate > Database  --JPA/Hibernate to talk to the database
    //For now creating static list
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Saket", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(21)));
    }

    public static List<User> getUsers() {
        return users;
    }

    public User findOne(int id)
    {
        User u = null;
        int flag = 0;
        for(User user1:users)
        {
            if(user1.getId()==id) {
                flag=1;
                u = user1;
                break;
            }
        }
        if(flag==1){
            return u;
        }
        else{
            return null;
        }
    }

    public User saveUser(User user)
    {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUserbyId(int id)
    {
        int flag = 0;
        for(User user1:users)
        {
            if(user1.getId()==id) {
                flag=1;
                users.remove(user1);
                break;
            }
        }
        if(flag==1){
            System.out.println("User deleted successfully");
        }
        else{
            System.out.println("User with mentioned Id does not exists");
        }
    }
}
