package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable("genre") String genre) {
		List<Movie> movies = movieService.getListByGenre(genre);
		return movies.isEmpty()
				? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(movies, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(movieService.save(movie));
	}
}
