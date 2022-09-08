package com.dh.catalogservice.domain.model.dto;


import java.util.List;

public class CatalogWS {
	private String genre;
	private List<MovieWS> movies;

	public CatalogWS(){
		//No args constructor
	}

	public CatalogWS(String genre, List<MovieWS> movies) {
		this.genre = genre;
		this.movies = movies;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<MovieWS> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieWS> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "CatalogWS{" +
				"genre='" + genre + '\'' +
				", movies=" + movies +
				'}';
	}
}
