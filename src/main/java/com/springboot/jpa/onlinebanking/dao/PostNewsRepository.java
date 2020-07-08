package com.springboot.jpa.onlinebanking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.onlinebanking.entity.PostNews;

@Repository
public interface PostNewsRepository extends JpaRepository<PostNews, Integer>{

}
