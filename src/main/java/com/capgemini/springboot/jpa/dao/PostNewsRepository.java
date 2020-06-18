package com.capgemini.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.jpa.entity.PostNews;

@Repository
public interface PostNewsRepository extends JpaRepository<PostNews, Integer>{

}
