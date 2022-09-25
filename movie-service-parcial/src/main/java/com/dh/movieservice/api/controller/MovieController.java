package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieService movieService;

	@Value("${server.port}")
	private String port;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable("genre") String genre, HttpServletResponse response) {
		response.addHeader("port", port);
		List<Movie> movies = movieService.getListByGenre(genre);
		return movies.isEmpty()
				? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(movies, HttpStatus.OK);
	}

	@GetMapping("/withErrors/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable("genre") String genre, @RequestParam("throwError") boolean throwError){
		return ResponseEntity.ok().body(movieService.getListByGenre(genre, throwError));
	}

	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(movieService.save(movie));
	}
}
