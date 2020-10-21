package com.ssafy.book.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dao.BookDao;
import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.SearchDto;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;

	@Override
	public void insertBook(BookDto bookDto) throws SQLException {
		dao.insertBook(bookDto);
	}

	@Override
	public List<BookDto> searchAll(SearchDto search) throws SQLException {
		return dao.searchAll(search);
	}

	@Override
	public BookDto searchBook(String isbn) throws SQLException {
		return dao.searchBook(isbn);
	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		dao.deleteBook(isbn);
	}

}
