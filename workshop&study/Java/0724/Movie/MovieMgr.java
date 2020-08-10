package com.ssafy.Movie;

public class MovieMgr {

	private Movie[] movies = new Movie[100];
	private int index = 0;

	static MovieMgr moviemgr = null;

	private MovieMgr() {
	}

	public static MovieMgr getInstance() {
		if (moviemgr == null) {
			moviemgr = new MovieMgr();
		}
		return moviemgr;
	}

	public void add(Movie m) {
		movies[index] = new Movie(m.getTitle(), m.getDirector(), m.getGrade(), m.getGenre(), m.getSummary());
		index++;
	}

	public Movie[] search() {

		return movies;

	}

	public Movie[] search(String title) {
		Movie[] temp = new Movie[100];
		int j = 0;
		for (int i = 0; i < index; i++) {
			if ((movies[i].getTitle()).equals(title)) {
				temp[j] = movies[i];
				j++;
			}

		}
		return temp;

	}

	public Movie[] searchDirector(String name) {
		Movie[] temp = new Movie[100];
		int j = 0;
		for (int i = 0; i < index; i++) {
			if ((movies[i].getDirector()).equals(name)) {
				temp[j] = movies[i];
				j++;
			}

		}
		return temp;
	}

	public Movie[] searchGenre(String genre) {
		Movie[] temp = new Movie[100];
		int j = 0;
		for (int i = 0; i < index; i++) {
			if ((movies[i].getGenre()).equals(genre)) {
				temp[j] = movies[i];
				j++;
			}

		}
		return temp;

	}

	public void delete(String title) {
		for (int i = 0; i < index - 2; i++) {
			if (movies[i].getTitle() == title) {
				movies[i] = movies[i + 1];
				movies[i + 1] = movies[i + 2];
				index--;
				break;
			}
		}

	}

	public int getSize() {
		int cnt = 0;
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle() != null)
				cnt++;
		}
		return cnt;
	}

}
