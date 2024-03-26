package com.example.repositoryex.Controller;

import com.example.repositoryex.ApiResponce.ApiResponce;
import com.example.repositoryex.Model.User;
import com.example.repositoryex.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponce("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);

        return ResponseEntity.status(200).body(new ApiResponce("user updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        return ResponseEntity.status(200).body(new ApiResponce("user deleted"));

    }
    @GetMapping("/username/{username}/{password}")
    public ResponseEntity searchbyusernameandpassword(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(userService.searchByusernameandpassword(username,password));
    }

    @GetMapping("/searchemail/{email}")
    public ResponseEntity searchbyemail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.searchByEmail(email));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity searchbyrole(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.searchByrole(role));
    }
    @GetMapping("/age/{age}")
    public ResponseEntity searchbyage(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.searchByAge(age));
    }


    }
