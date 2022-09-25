package com.dh.catalogservice.api.client;


import com.dh.catalogservice.api.config.LoadBalancerConfig;
import com.dh.catalogservice.domain.model.dto.MovieDTO;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service", configuration = LoadBalancerConfig.class)
public interface MovieFeignClient {

    @GetMapping("movies/{genre}")
    ResponseEntity<List<MovieDTO>> findMovieByGenre(@PathVariable("genre") String genre);

    @GetMapping("movies/withErrors/{genre}")
    ResponseEntity<List<MovieDTO>> findMovieByGenreWithThrowError(@PathVariable("genre") String genre, @RequestParam("throwError") boolean throwError);

}
