package com.ssafy.book.model;

public class SearchDto {
	private String searchWord;
	private String searchType;

	public SearchDto() {
	}

	public SearchDto(String searchWord, String searchType) {
		this.searchWord = searchWord;
		this.searchType = searchType;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
}
