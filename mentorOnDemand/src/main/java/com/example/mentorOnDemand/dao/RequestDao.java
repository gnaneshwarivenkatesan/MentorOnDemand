package com.example.mentorOnDemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mentorOnDemand.model.Request;

public interface RequestDao extends JpaRepository<Request, Integer> {

}
