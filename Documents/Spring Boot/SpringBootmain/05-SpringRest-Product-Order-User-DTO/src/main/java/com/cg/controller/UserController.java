package com.cg.controller;
 
import com.cg.dto.UserDTO;
import com.cg.entity.User;
import com.cg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.stream.Collectors;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
    @Autowired
    IUserService userService;
 
    @GetMapping("/getuserbyid/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        User user = userService.findAllByid(id);
        return user != null ? UserDTO.fromEntity(user) : null; // Return null if user not found
    }
 
}
