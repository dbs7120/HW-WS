package com.ssafy.book;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.SearchDto;
import com.ssafy.book.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertBook(BookDto book) {
		System.out.println(book.toString());
		try {
			bookService.insertBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list?searchType=&searchWord=";
	}

	@RequestMapping(value = "/delete")
	public String deleteBook(@RequestParam("isbn") String isbn, Model model) {
		try {
			System.out.println(isbn);
			bookService.deleteBook(isbn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list?searchType=&searchWord=";
	}

	@RequestMapping(value = "/bookView", method = RequestMethod.GET)
	public String bookView(@RequestParam("isbn") String isbn, Model model) {
		BookDto book;
		System.out.println(isbn);
		try {
			book = bookService.searchBook(isbn);
			model.addAttribute("book", book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "bookView";
	}

	@RequestMapping(value = "/mvadd", method = RequestMethod.GET)
	public String add(Locale locale, Model model) {
		return "form";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookList(@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchWord", required = false) String searchWord, Model model) {
		List<BookDto> list;
		try {
			list = bookService.searchAll(new SearchDto(searchWord, searchType));
			model.addAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}

}
