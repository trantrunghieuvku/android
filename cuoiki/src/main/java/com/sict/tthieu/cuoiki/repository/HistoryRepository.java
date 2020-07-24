package com.sict.tthieu.cuoiki.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.sict.tthieu.cuoiki.dto.Learning;
import com.sict.tthieu.cuoiki.model.History;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryRepository  extends JpaRepository<History,Integer>{
    
    @Query("SELECT new com.sict.tthieu.cuoiki.dto.Learning(w.word,w.id,w.proEn,w.type,w.category,w.transVn) FROM History h JOIN h.words w where h.idUser=1")
     List<Learning> findWordHistory();

     @Modifying
     @Query(value = "INSERT INTO history (id_user,id_word) VALUES (:idUser,:idWord)", nativeQuery = true)
     @Transactional
     void insertHi(@Param("idUser") Integer idUser, @Param("idWord") Integer idWord);

}