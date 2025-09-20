package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.dto.GenreDto;

import java.util.Set;
import java.util.UUID;

public interface GenreService {

    // all genres existing
    Set<GenreDto> getGenres();

    // insert new Genre
    GenreDto saveNewGenre(GenreDto genre);

    // update existing Genre
    void updateGenreById(UUID genreId, GenreDto genre);

    // delete existing Genre
    void deleteGenreById(UUID genreId);
}
