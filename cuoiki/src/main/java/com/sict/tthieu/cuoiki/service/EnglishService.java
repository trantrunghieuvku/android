package com.sict.tthieu.cuoiki.service;

import java.util.List;

import com.sict.tthieu.cuoiki.dto.Learning;
import com.sict.tthieu.cuoiki.model.Words;
import com.sict.tthieu.cuoiki.repository.HistoryRepository;
import com.sict.tthieu.cuoiki.repository.UserRepository;
import com.sict.tthieu.cuoiki.repository.WordsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnglishService {

    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HistoryRepository historyRepository;

    public List<Words> listAll() {
        return wordsRepository.findAll();
    }

    public void save(Words words) {
        wordsRepository.save(words);
    }

    public Words get(Integer id) {
        return wordsRepository.findById(id).get();
    }

    public void delete(Integer id) {
        wordsRepository.deleteById(id);
    }

    public List<Words> getWords(String word) {
        return wordsRepository.findByWord(word);
    }

    public List<Words> getWordsByCategory(String category) {
        return wordsRepository.findByCategory(category);
    }

    public List<Words> search(String word) {
        return wordsRepository.findByWordContaining(word);
    }
    public List<Learning> getHistory(){ return  historyRepository.findWordHistory();}
    public void addHistory(Integer idUser ,Integer idWord){
        historyRepository.insertHi(idUser,idWord);
    }

}