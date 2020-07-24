package com.sict.tthieu.cuoiki.repository;

import java.util.List;

import com.sict.tthieu.cuoiki.model.Words;

public interface ICustomRepository {
    List<Words> findByWord(String words);
    List<Words> findByCategory(String category);
    
}