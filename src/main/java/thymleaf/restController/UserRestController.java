package thymleaf.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import thymleaf.movil.entity.User;
import thymleaf.movil.repository.UserRepository;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserRestController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping(value="/")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping(value="/")
    public User updateUser(@RequestBody User user) {
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        return userRepository.save(oldUser);
    }
    
    @DeleteMapping(value="/{id}")
    public Integer deleteUserById (@PathVariable Integer id){
        userRepository.deleteById(id);
        return id;
    }
    

}
