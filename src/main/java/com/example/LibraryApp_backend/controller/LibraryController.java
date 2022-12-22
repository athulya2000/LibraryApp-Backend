package com.example.LibraryApp_backend.controller;

import com.example.LibraryApp_backend.dao.BooksDao;
import com.example.LibraryApp_backend.dao.LibraryDao;
import com.example.LibraryApp_backend.model.Books;
import com.example.LibraryApp_backend.model.Libaray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;
    @Autowired
    private BooksDao dao1;

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

    @CrossOrigin(origins = "*")
    @PostMapping(path="/entry",consumes = "application/json",produces = "application/json")
    public Map<String,String> Entry(@RequestBody Books b){
        System.out.println(b.getTitle().toString());
        System.out.println(b.getAuthor().toString());
        System.out.println(b.getPrice().toString());
        System.out.println(b.getImage().toString());
        dao1.save(b);
        HashMap<String,String> map=new HashMap<>();
        map.put("Status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Books> View(){
        return (List<Books>) dao1.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/search",consumes = "application/json",produces = "application/json")
    public List<Books> SearchBook(@RequestBody Books b){
        String title=b.getTitle();
        System.out.println(title);
        return (List<Books>) dao1.Search(b.getTitle());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/delete",consumes = "application/json",produces = "application/json")
    public Map<String,String> Delete(@RequestBody Books b){
        String id=String.valueOf(b.getId());
        System.out.println(id);
        dao1.DeleteBook(b.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }

}
