package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.dto.GenreDto;
import it.diamondnet.springframework.radiochannel.mapper.GenreMapper;
import it.diamondnet.springframework.radiochannel.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public Set<GenreDto> getGenres() {
        return genreRepository.findAll()
                .stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public GenreDto saveNewGenre(GenreDto genre) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genre)));
    }

    @Override
    public void updateGenreById(UUID genreId, GenreDto genre) {
        genreRepository.findById(genreId).ifPresent(foundGenre -> {
            foundGenre.setName(genre.getName());
            foundGenre.setDescription(genre.getDescription());
            genreRepository.save(foundGenre);
        });
    }

    @Override
    public void deleteGenreById(UUID genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    public GenreDto getGenreById(UUID genreId) {
        return genreRepository.findById(genreId)
                .map(genreMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}