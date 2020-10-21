package com.ssafy.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.SearchDto;

public interface BookDao {
	void insertBook(BookDto bookDto) throws SQLException;

	List<BookDto> searchAll(SearchDto search) throws SQLException;

	BookDto searchBook(String isbn) throws SQLException;

	void deleteBook(String isbn) throws SQLException;

}
