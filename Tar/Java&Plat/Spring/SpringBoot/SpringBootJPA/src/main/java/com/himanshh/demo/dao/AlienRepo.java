package com.himanshh.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.himanshh.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
