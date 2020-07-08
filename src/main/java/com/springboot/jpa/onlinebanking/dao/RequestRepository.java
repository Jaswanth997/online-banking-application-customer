package com.springboot.jpa.onlinebanking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.onlinebanking.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{

}
