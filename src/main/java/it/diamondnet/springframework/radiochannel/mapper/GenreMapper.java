package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;

import it.diamondnet.springframework.radiochannel.domain.Genre;
import it.diamondnet.springframework.radiochannel.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre toEntity(GenreDto dto);
    GenreDto toDto(Genre entity);
}
