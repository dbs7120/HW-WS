package com.ssafy.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.SearchDto;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	DataSource ds;

	@Override
	public void insertBook(BookDto bookDto) throws SQLException {
		final String SQL = "insert into book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bookDto.getIsbn());
			pstmt.setString(2, bookDto.getTitle());
			pstmt.setString(3, bookDto.getCatalogue());
			pstmt.setString(4, bookDto.getNation());
			pstmt.setString(5, bookDto.getPublishDate());
			pstmt.setString(6, bookDto.getPublisher());
			pstmt.setString(7, bookDto.getAuthor());
			pstmt.setInt(8, bookDto.getPrice());
			pstmt.setString(9, bookDto.getCurrency());
			pstmt.setString(10, bookDto.getDescription());
			pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}

	}

	@Override
	public List<BookDto> searchAll(SearchDto search) throws SQLException {
		List<BookDto> list = new ArrayList<BookDto>();
		StringBuffer SQL = new StringBuffer();
		SQL.append("select * from book ");
		String searchType = search.getSearchType();
		if (searchType != null && searchType.length() != 0) { // 데이터가 있는 경우, where 절 추가
			String query = "";
			if ("price".equals(searchType)) { // 가격이 일정이하
				query = " < ? "; // select * from book where price < ?
			} else if ("title".equals(searchType)) {
				query = " like ? "; // select * from book where like ?
			}
			SQL.append("where " + searchType + query);

		}
		SQL.append("order by isbn ");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.toString());

			if (searchType != null && searchType.length() != 0) { // 데이터가 있는 경우, where 절 추가
				if ("price".equals(searchType)) {
					pstmt.setInt(1, Integer.valueOf(search.getSearchWord()));
				} else if ("title".equals(searchType)) {
					pstmt.setString(1, "%" + search.getSearchWord() + "%");
				}
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookDto book = new BookDto();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setAuthor(rs.getString("author"));

				list.add(book);

			}
			return list;

		} finally {
			rs.close();
			pstmt.close();
			conn.close();

		}

	}

	@Override
	public BookDto searchBook(String isbn) throws SQLException {
		final String SQL = "select * from book where isbn = ?";
		BookDto book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new BookDto();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setNation(rs.getString("nation"));
				book.setPublishDate(rs.getString("publish_Date"));
				book.setPublisher(rs.getString("publisher"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setCurrency(rs.getString("currency"));
				book.setDescription(rs.getString("description"));
			}

			return book;

		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		final String SQL = "delete from book where isbn = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, isbn);
			pstmt.executeUpdate();

		} finally {
			pstmt.close();
			conn.close();
		}
	}

}
