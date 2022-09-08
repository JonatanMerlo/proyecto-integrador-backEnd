package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieFeignClient movieFeignClient;

	@Autowired
	public CatalogServiceImpl(MovieFeignClient MovieFeignClient) {
		this.movieFeignClient = MovieFeignClient;
	}

	public CatalogWS findByGenre(String genre){
		ResponseEntity<List<MovieWS>> movieResponse = movieFeignClient.findMovieByGenre(genre);
		if(movieResponse.getStatusCode().is2xxSuccessful()){
			return new CatalogWS(genre, movieResponse.getBody());
		}
		return null;
	}
}
