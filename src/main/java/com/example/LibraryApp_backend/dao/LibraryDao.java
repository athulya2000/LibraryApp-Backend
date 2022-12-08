package com.example.LibraryApp_backend.dao;

import com.example.LibraryApp_backend.model.Libaray;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibraryDao extends CrudRepository<Libaray,Integer> {

    @Query(value="SELECT `id`, `aadhar_no`, `address`, `confirmpassword`, `date_of_birth`, `email`, `name`, `password`, `phonenumber`, `pincode`, `username` FROM `signup` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Libaray> Login(@Param("username") String username,@Param("password") String password);
}
