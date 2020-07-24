package com.sict.tthieu.cuoiki.repository;

import java.util.List;

import com.sict.tthieu.cuoiki.model.Words;

import org.springframework.data.jpa.repository.JpaRepository;
public interface WordsRepository extends JpaRepository<Words,Integer>,ICustomRepository{
    List<Words> findByWordContaining(String word);
}