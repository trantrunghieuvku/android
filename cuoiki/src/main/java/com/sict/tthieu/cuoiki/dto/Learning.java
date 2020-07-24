package com.sict.tthieu.cuoiki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Learning {
    private String word;
    private Integer id;
    private String proEn;
    private String type;
    private String category;
    private String transVn;

    public Learning(String word, Integer id, String proEn, String type, String category, String transVn) {
        this.word = word;
        this.id = id;
        this.proEn = proEn;
        this.type = type;
        this.category = category;
        this.transVn = transVn;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProEn() {
        return proEn;
    }

    public void setProEn(String proEn) {
        this.proEn = proEn;
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

    public String getTransVn() {
        return transVn;
    }

    public void setTransVn(String transVn) {
        this.transVn = transVn;
    }

    

    
    
}