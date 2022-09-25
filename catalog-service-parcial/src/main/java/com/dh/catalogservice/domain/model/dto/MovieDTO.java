package com.dh.catalogservice.domain.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
