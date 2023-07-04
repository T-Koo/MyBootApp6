package jp.te4a.spring.boot.myapp13.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.te4a.spring.boot.myapp13.form.BookForm;
import jp.te4a.spring.boot.myapp13.service.BookService;


@Controller

//　/booksにアクセスされた時のコントローラ
@RequestMapping("books")

public class BookController {
	@Autowired
	BookService bookService;
	@ModelAttribute
	BookForm setUpForm() {
		return new BookForm();
	}
	
	// /booksにGET要求
	@GetMapping
	String list(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "books/list";
	}
	
	// /books/createにPOST要求
	@PostMapping(path="create")
	String create(@Validated BookForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return list(model);
		}
		bookService.create(form);
		return "redirect:/books";
	}
	
	// /books/editにパラメタformを含むPOST要求
	@PostMapping(path="edit", params="form")
	String editForm(@RequestParam Integer id, BookForm form) {
		BookForm bookForm = bookService.findOne(id);
		BeanUtils.copyProperties(bookForm, form);
		return "books/edit";
	}
	
	// /books/editにPOST要求
	@PostMapping(path="edit")
	String edit(@RequestParam Integer id,@Validated BookForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "books/edit";
		}
		bookService.update(form);
		return "redirect:/books";
	}
	
	// /books/deleteにPOST要求
	@PostMapping(path="delete")
	String delete(@RequestParam Integer id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
	// /books/editにパラメタgoToTopを含むPOST要求
	@PostMapping(path="edit", params="goToTop")
	String goToTop() {
		return "redirect:/books";
	}
}