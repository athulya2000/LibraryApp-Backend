package com.example.LibraryApp_backend.controller;

import com.example.LibraryApp_backend.dao.LibraryDao;
import com.example.LibraryApp_backend.model.Libaray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/signup",consumes = "application/json",produces = "application/json")
    public Map<String,String> Usersignup(@RequestBody Libaray l){
        System.out.println(l.getName().toString());
        System.out.println(l.getAadharNo().toString());
        System.out.println(l.getAddress().toString());
        System.out.println(l.getPincode().toString());
        System.out.println(l.getDateOfBirth().toString());
        System.out.println(l.getEmail().toString());
        System.out.println(l.getPhonenumber().toString());
        System.out.println(l.getUsername().toString());
        System.out.println(l.getPassword().toString());
        System.out.println(l.getConfirmpassword().toString());
        dao.save(l);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/login",consumes = "application/json",produces = "application/json")
    public List<Libaray> UserLogin(@RequestBody Libaray l){
        String username=l.getUsername().toString();
        String password= l.getPassword().toString();
        System.out.println(username);
        System.out.println(password);
        return (List<Libaray>) dao.Login(l.getUsername(),l.getPassword());
    }
}
