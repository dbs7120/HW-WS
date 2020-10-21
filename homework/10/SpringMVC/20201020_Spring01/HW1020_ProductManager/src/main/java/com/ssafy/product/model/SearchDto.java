package com.ssafy.product.model;

public class SearchDto {
	private String searchWord;
	private String searchType;

	public SearchDto() {
		super();
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

	@Override
	public String toString() {
		return "SearchDto [searchWord=" + searchWord + ", searchType=" + searchType + "]";
	}

}