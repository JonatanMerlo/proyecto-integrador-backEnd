package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.client.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.MovieDTO;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final MovieFeignClient movieClient;

    public MovieService(MovieFeignClient movieClient){
        this.movieClient = movieClient;
    }

    public ResponseEntity<List<MovieDTO>> findMovieByGenre(String genre) {
        LOG.info("Se va a incluir el llamado al movie-service");
        return movieClient.findMovieByGenre(genre);
    }

    @CircuitBreaker(name = "movies", fallbackMethod = "moviesFallbackMethod")
    public ResponseEntity<List<MovieDTO>> findMovieByGenre(String genre, Boolean throwError){
        LOG.info("Se va a incluir el llamado al movie-service");
        return movieClient.findMovieByGenreWithThrowError(genre, throwError);
    }

    private ResponseEntity<List<MovieDTO>> moviesFallbackMethod(CallNotPermittedException exception){
        LOG.info("Se activo el circuit beaker");
        return new ResponseEntity(new ArrayList<>(), HttpStatus.OK);
    }
}
