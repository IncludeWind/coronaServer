package com.example.demo.repository;

import com.example.demo.model.countryCenter;
import com.example.demo.model.locationAndData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface geoRepository extends JpaRepository<countryCenter, Integer> {


}
