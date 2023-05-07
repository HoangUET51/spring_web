package com.example.demo.repository;

import com.example.demo.models.Classic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassicRepository extends JpaRepository<Classic,Integer> {

}
