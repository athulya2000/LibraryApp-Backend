package com.example.LibraryApp_backend.dao;

import com.example.LibraryApp_backend.model.Libaray;
import org.springframework.data.repository.CrudRepository;

public interface LibraryDao extends CrudRepository<Libaray,Integer> {
}
