package com.sict.tthieu.cuoiki.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sict.tthieu.cuoiki.model.Words;


public class CustomeRepository implements ICustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Words> findByWord(String words) {
        // TODO Auto-generated method stub
        Query query = entityManager.createNativeQuery("SELECT * FROM words as w " + "WHERE w.word = ?", Words.class);
        query.setParameter(1, words + "%");
        return query.getResultList();
}

@Override
public List<Words> findByCategory(String category) {
    // TODO Auto-generated method stub
    Query query1 = entityManager.createNativeQuery("SELECT * FROM words as w " + "WHERE w.category = ?", Words.class);
        query1.setParameter(1, category + "%");
        return query1.getResultList();
}


}   