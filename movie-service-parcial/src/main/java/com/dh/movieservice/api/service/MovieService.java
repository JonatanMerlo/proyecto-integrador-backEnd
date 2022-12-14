package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;

import java.util.List;

public interface MovieService {
	List<Movie> getListByGenre(String genre);
	List<Movie> getListByGenre(String genre, boolean throwError);
	Movie save(Movie movie);
}
