package com.dh.catalogservice.domain.model.dto;


import java.util.List;

public class CatalogWS {
	private String genre;
	private List<MovieDTO> movies;

	public CatalogWS(){
		//No args constructor
	}

	public CatalogWS(String genre, List<MovieDTO> movies) {
		this.genre = genre;
		this.movies = movies;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
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
