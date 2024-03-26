package com.example.repositoryex.Repository;

import com.example.repositoryex.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByEmail(String email);

    List<User> findUserByRole(String role);

    List<User> findUserByAgeGreaterThanEqual(Integer age);

    User findUserByUsernameAndPassword(String username,String password);
}
