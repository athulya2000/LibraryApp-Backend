package com.example.LibraryApp_backend.dao;

import com.example.LibraryApp_backend.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksDao extends CrudRepository<Books,Integer> {

    @Query(value="SELECT `id`, `description`, `distributor`, `language`, `publisher`, `released_year`, `author`, `image`, `price`, `title` FROM `book_entry` WHERE `title` LIKE %:title%",nativeQuery = true)
    List<Books> Search(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM `book_entry` WHERE `id`=:id",nativeQuery = true)
    void DeleteBook(@Param("id") Integer id);
}
