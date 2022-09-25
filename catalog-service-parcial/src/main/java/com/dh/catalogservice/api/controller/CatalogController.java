package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.MovieFeignClient;
import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.MovieService;
import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private final MovieService movieService;

	@Autowired
	public CatalogController( MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<List<MovieDTO>> getCatalogByGenre(@PathVariable String genre) {
		return movieService.findMovieByGenre(genre);
	}

	@GetMapping("/withErrors/{genre}")
	ResponseEntity<List<MovieDTO>> getGenre(@PathVariable String genre, @RequestParam("throwError") boolean throwError){
		return movieService.findMovieByGenre(genre, throwError);
	}
}
