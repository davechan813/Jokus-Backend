/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.damx.security.TokenGenerator;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkController {

    @Autowired
    private ParkRepository parkRepository;
    @Autowired
    private UserRepository userRepository;

    private AmazonClient amazonClient;

    @Autowired
    ParkController(AmazonClient amazonClient)
    {
        this.amazonClient = amazonClient;
    }

    @RequestMapping(value= "/park/all", method = RequestMethod.POST)
    public @ResponseBody Iterable<Park> allParks()
    {
        return parkRepository.findAll();
    }


    /*
    *
    * String name
String description
String[] hours [08002300, 08002300, 08002300, 08002300, 08002300, 08002300, 08002300, 99999999]
String address
List<User> users . //ManyToMany*/

// return the park id in String
    @RequestMapping(value= "/park/add", method = RequestMethod.POST)
    public @ResponseBody String addPark(@RequestParam String name,
                                        @RequestParam String coord,
                                        @RequestParam String description,
                                        @RequestParam String hours,
                                        @RequestParam String address)
    {
        if(!parkRepository.findByName(name).isEmpty())
            return "-1";//already exists
        if(hours.length() != 56)
            return "-2"; //wrong format of buz hrs

        Park park = new Park();
        park.setName(name);
        park.setDescription(description);
        park.setAddress(address);
        String[] hrs = new String[7];
        for(int i = 0; i < 7; i++)
        {
            hrs[i] = hours.substring(i*8, i*8+8);
        }

        park.setHours(hrs);
        park.setCoord(coord);
        park.setUsers(new ArrayList<User>());
        parkRepository.save(park);
        return park.getId().toString();
    }

    @RequestMapping(value="/park/checkin", method = RequestMethod.POST)
    public @ResponseBody String checkin(@RequestParam String token,
                                        @RequestParam String parkId)
    {
        List<Park> tmp = parkRepository.findById(Integer.parseInt(parkId));
        if(tmp.isEmpty())
        {
            return "-1"; //wrong park id
        }
        else {
            Park myPark = tmp.get(0);
            User usr = userRepository.findByToken(token);
            if (usr == null)
                return "-2"; //wrong token
            if(myPark.getUsers().contains(usr))
                return "-3"; // already checked in
            myPark.getUsers().add(usr);
            parkRepository.save(myPark);
            return new Integer(myPark.getUsers().size()).toString(); //return how many people checked in
        }
    }


    @RequestMapping(value="/park/removeUser", method = RequestMethod.POST)
    public @ResponseBody String removeUser(@RequestParam String token,
                                        @RequestParam String parkId)
    {
        List<Park> tmp = parkRepository.findById(Integer.parseInt(parkId));
        if(tmp.isEmpty())
        {
            return "-1"; //wrong park id
        }
        else {
            Park myPark = tmp.get(0);
            User usr = userRepository.findByToken(token);
            if (usr == null)
                return "-2"; //wrong token
            myPark.getUsers().remove(usr);
            parkRepository.save(myPark); //caution!!
            return new Integer(myPark.getUsers().size()).toString(); //return how many people checked in
        }
    }

    @RequestMapping(value="/park/getUsers", method = RequestMethod.POST)
    public @ResponseBody Iterable<User> getUsers(@RequestParam String parkId)
    {
        List<Park> tmp = parkRepository.findById(Integer.parseInt(parkId));
        if(tmp.isEmpty())
        {
            return new ArrayList<User>(); //wrong park id
        }
        else
        {
            Park myPark = tmp.get(0);
            return myPark.getUsers(); //return a list of checked in users
        }
    }


    @RequestMapping(value="/park/getParkCoverPic", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<byte[]> getParkCoverPic(@RequestParam String id)
    {
        int parkid = Integer.parseInt(id);
        BucketController buck = new BucketController(this.amazonClient);
        try {
            return buck.download("park_" + Integer.toString(parkid) + "_cover.jpg");
        }
        catch(Exception e)
        {
            return null;
        }

    }
}
