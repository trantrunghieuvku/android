package com.sict.tthieu.cuoiki.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Words.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="id_word")
    private List<Words> words;

    @Column
    private Integer idUser;


    public void setId(Integer id) {
        this.id = id;
    }

   

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<Words> getWords() {
        return words;
    }

    public void setWords(List<Words> words) {
        this.words = words;
    }
    
}