package com.example.repositoryex.Service;

import com.example.repositoryex.ApiResponce.ApiExeption;
import com.example.repositoryex.Model.User;
import com.example.repositoryex.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }


    public void updateUser(Integer id,User user){
        User u=userRepository.findUserById(id);
        if(u==null){
            throw new ApiExeption("wrong id");

        }
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setAge(user.getAge());

        userRepository.save(u);

    }


    public void deleteUser(Integer id){
        User u=userRepository.findUserById(id);
        if(u==null){
            throw new ApiExeption("wrong id");

        }
        userRepository.delete(u);

    }
    public User searchByusernameandpassword(String username,String password){
        User u=userRepository.findUserByUsernameAndPassword(username,password);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }

    public User searchByEmail(String email){
        User u=userRepository.findUserByEmail(email);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }

    public List<User> searchByrole(String role){
        List<User> u=userRepository.findUserByRole(role);
        if(u.isEmpty()){
            throw new ApiExeption("not found");
        }
        return u;
    }

    public List<User> searchByAge(Integer age){
        List<User> u=userRepository.findUserByAgeGreaterThanEqual(age);
        if(u.isEmpty()){
            throw new ApiExeption("not found");
        }
        return u;
    }



}
