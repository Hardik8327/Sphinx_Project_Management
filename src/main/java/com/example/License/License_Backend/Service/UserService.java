package com.example.License.License_Backend.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.License.License_Backend.Entity.User;
@Service
public class UserService {
	static int count=0;

	static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(++count,"aakash","1234","Aakash"));
		users.add(new User(++count,"aadra","1234","Aadra"));
		users.add(new User(++count,"hardik","1234","Hardik"));
		users.add(new User(++count,"tejas","1234","Tejas"));
	}
	
    public void addUser(User user) {
        users.add(user);
    }
    
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // If user with given id is not found
    }
    
    public void updateUser(int id, String username, String password, String name) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                return;
            }
        }
        // If user with given id is not found, you might handle this case accordingly
    }
    
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
    public List<User> getAllUsers(){
    	return users;
    }
	
	
}
