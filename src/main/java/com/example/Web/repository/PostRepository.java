package com.example.Web.repository;

import com.example.Web.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <PostEntity, Long> {
}
