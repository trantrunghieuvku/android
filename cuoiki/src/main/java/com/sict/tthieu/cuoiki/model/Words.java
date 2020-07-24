package com.sict.tthieu.cuoiki.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Words  {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String word;
    @Column
    private String proEn;
    @Column
    private String transVn;
    @Column
    private String type;
    @Column
    private String category;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getProEn() {
        return proEn;
    }

    public void setProEn(String proEn) {
        this.proEn = proEn;
    }

    public String getTransVn() {
        return transVn;
    }

    public void setTransVn(String transVn) {
        this.transVn = transVn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }   
  
}