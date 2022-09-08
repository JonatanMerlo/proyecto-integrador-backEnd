package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieFeignClient movieFeignClient;

	@Autowired
	public CatalogServiceImpl(MovieFeignClient movieFeignClient) {
		this.movieFeignClient = movieFeignClient;
	}


	public CatalogWS findByGenre(String genre){
		ResponseEntity<List<MovieWS>> movieResponse = movieFeignClient.findMovieByGenre(genre);
		System.out.println("Puerto utilizado :" + movieResponse.getHeaders().get("port"));
		CatalogWS catalogo = new CatalogWS(genre, movieResponse.getBody());
		if(movieResponse.getStatusCode().is2xxSuccessful()){
			return catalogo;
		}
		return null;
	}
}
