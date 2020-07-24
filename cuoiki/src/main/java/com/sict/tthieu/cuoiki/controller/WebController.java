package com.sict.tthieu.cuoiki.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sict.tthieu.cuoiki.model.Words;
import com.sict.tthieu.cuoiki.service.EnglishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {
    
    @Autowired
    private EnglishService eService;

    
   @GetMapping("/")
	public String home() {
		return "redirect:/employee";
	}
    @GetMapping("/employee")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("wordlist", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/employee/page/1";
    }

    @GetMapping("/employee/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("wordlist");
		int pagesize = 5;
		List<Words> list = eService.listAll();
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("wordlist", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/employee/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("words", pages);

		return "list";
    }
    @GetMapping("/employee/search/")	
	public String search(@RequestParam("s") String s, Model model, HttpServletRequest request) {	
		if (s.equals("")) {	
			return "redirect:/employee";	
        }	
        int pageNumber=1;
		List<Words> list = eService.search(s);	
		if (list == null) {	
			return "redirect:/employee";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("wordlist");	
		int pagesize = 5;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = pageNumber - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("wordlist", pages);	
		int current = pages.getPage() + 1;	
		int begin = Math.max(1, current - list.size());	
		int end = Math.min(begin + 5, pages.getPageCount());	
		int totalPageCount = pages.getPageCount();	
		String baseUrl = "/employee/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("words", pages);	
		return "list";	
	}
    @GetMapping("/add")
    public String add(Model model) {
    model.addAttribute("word", new Words());
    return "form";
    }
    
    @PostMapping("/save")
        public String save(@Validated Words words, BindingResult result, RedirectAttributes redirect) {
            if (words.getProEn().isEmpty() || words.getWord().isEmpty() || words.getCategory().isEmpty()||words.getTransVn().isEmpty() ||
            words.getType().isEmpty()) {
                redirect.addFlashAttribute("failMessage", " Save unsuccessfully!");
                return "redirect:/add";
    }
    else{
        
    eService.save(words);
    redirect.addFlashAttribute("successMessage", "Saved successfully!");
    return "redirect:/";
    }
    }

    @PostMapping("/update/{id}")
        public String update(@Validated Words word,@PathVariable Integer id, BindingResult result, RedirectAttributes redirect) {
    if (word.getProEn().isEmpty() || word.getWord().isEmpty() || word.getCategory().isEmpty()||word.getTransVn().isEmpty() ||
            word.getType().isEmpty()) {
                redirect.addFlashAttribute("failMessage", " Update unsuccessfully!");
                return "redirect:/edit/{id}";
    }
    else{
        Words w = new Words();
        w.setId(id);
        w.setCategory(word.getCategory());
        w.setProEn(word.getProEn());
        w.setTransVn(word.getTransVn());
        w.setWord(word.getWord());
        w.setType(word.getType());
    eService.save(w);
    redirect.addFlashAttribute("successMessage", "Updated successfully!");
    return "redirect:/";
    }

    }
    

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Words wordEdit = eService.get(id);
    model.addAttribute("words", wordEdit);
    return "edit";
    }
    
    @GetMapping("/english/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
	eService.delete(id);
    redirect.addFlashAttribute("successMessage", "Deleted  successfully!");
    return "redirect:/";
}

    
}