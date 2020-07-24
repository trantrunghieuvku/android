package com.sict.tthieu.cuoiki.controller;

import java.util.List;
import com.sict.tthieu.cuoiki.dto.Learning;
import com.sict.tthieu.cuoiki.model.Words;
import com.sict.tthieu.cuoiki.repository.HistoryRepository;
import com.sict.tthieu.cuoiki.repository.UserRepository;
import com.sict.tthieu.cuoiki.service.EnglishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnglishController {

    @Autowired
    private EnglishService eService;

    @GetMapping("/word/")
    public List<Words> get(@RequestParam("s") String word) {
        return eService.search(word);
    }

    @GetMapping("/word/category/{category}")
    public List<Words> getWordByCategory(@PathVariable("category") String category) {
        return eService.getWordsByCategory(category);
    }

    @GetMapping("/listword")
    public List<Words> getWord() {
        return eService.listAll();
    }

    @PostMapping("/word")
    public void add(@RequestBody Words w) {
        eService.save(w);
    }
    @GetMapping("/insert/{idUser}/{idWord}")
    public void add(@PathVariable("idWord") Integer idWord,@PathVariable("idUser") Integer idUser) {
            eService.addHistory(idUser, idWord);
    }
    @DeleteMapping("/word/{id}")
    public void delete(@PathVariable("id") Integer id){
        eService.delete(id);
    }
    @GetMapping("/join")
    public List<Learning> getHistory() {
        return eService.getHistory();
    }

    

}   