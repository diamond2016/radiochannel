package it.diamondnet.springframework.radiochannel.controller;

import org.springframework.http.HttpHeaders;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.diamondnet.springframework.radiochannel.dto.GenreDto;
import it.diamondnet.springframework.radiochannel.service.GenreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/genre") //no final shash
public class GenreController {
    private final GenreService genreService;

    @GetMapping("{genreId}")
    public GenreDto getGenreById(@PathVariable("genreId") UUID genreId) {

        log.debug("get Genre from id - in controller id: {}", genreId);
        
        return genreService.getGenreById(genreId);
    }

    @GetMapping
    public Set<GenreDto> getGenres() {

        log.debug("List Genres - in controller ");
        
        return genreService.getGenres();
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody GenreDto genre) {

        GenreDto savedGenre = genreService.saveNewGenre(genre); 

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/genre" + savedGenre.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{genreId}")
    public ResponseEntity<Void> updateGenreById(@PathVariable("genreId") UUID genreId, @RequestBody GenreDto genre) {

        genreService.updateGenreById(genreId, genre);
        log.debug("update Genre of ID - in controller id: {}", genreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{genreId}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable("genreId") UUID genreId) {

        genreService.deleteGenreById(genreId);
        log.debug("delete Genre of ID - in controller id: {}", genreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
