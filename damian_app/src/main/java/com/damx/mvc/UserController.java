package com.damx.mvc;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.damx.security.TokenGenerator;

import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "/showCustomer", method = RequestMethod.POST)
    public Customer customer(@RequestParam(value="firstname", defaultValue="Jack") String name)
    {
        return new Customer(name, "Sit");
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/findByLastName", method = RequestMethod.POST)
    public @ResponseBody List<User> findUserByLastName(@RequestParam String name)
    {
        return userRepository.findByLastName(name);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String firstName,
                                            @RequestParam String lastName,
                                            @RequestParam String email,
                                            @RequestParam String password,
                                            @RequestParam String height,
                                            @RequestParam String weight,
                                            @RequestParam String position
                                            ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if(!userRepository.findByEmail(email).isEmpty())
        {
            return "-1";//email already exist
        }
        User n = new User();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        n.setPassword(password);
        n.setHeight(height);
        n.setWeight(weight);
        n.setPosition(position);
        // for each sign up assign a token for em and save the token w/ user info. Return this token
        TokenGenerator tkg = new TokenGenerator();
        String token = tkg.nextToken();
        n.setToken(token);
        userRepository.save(n);
        return token;
    }

    @RequestMapping(value="/all", method = RequestMethod.POST)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(value="/getToken", method = RequestMethod.POST)
    public @ResponseBody String getToken(@RequestParam String email, @RequestParam String password)
    {
        if (!userRepository.findByEmail(email).isEmpty())
        {
            User usr = userRepository.findByEmail(email).get(0);
            if(password.equals(usr.getPassword()))
                return usr.getToken();
            else
                return "-1"; //wrong password
        }
        else
        {
            return "-2"; //no such email
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam String email, @RequestParam String password)
    {
        if (!userRepository.findByEmail(email).isEmpty())
        {
            User usr = userRepository.findByEmail(email).get(0);
            if(password.equals(usr.getPassword()))
                return usr.getId().toString();
            else
                return "-1"; //wrong password
        }
        else
        {
            return "-2"; //no such email
        }
    }




}
