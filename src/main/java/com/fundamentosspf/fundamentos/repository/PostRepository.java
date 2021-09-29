package com.fundamentosspf.fundamentos.repository;

import com.fundamentosspf.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post,Long>{
}
