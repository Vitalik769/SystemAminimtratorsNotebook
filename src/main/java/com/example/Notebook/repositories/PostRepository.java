package com.example.Notebook.repositories;

import com.example.Notebook.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
