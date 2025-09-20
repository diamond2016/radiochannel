package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.dto.RadioStationDto;

@Mapper(componentModel = "spring", uses = {TagMapper.class, GenreMapper.class, UserFeedback.class})
public interface RadioStationMapper {
    RadioStation toEntity(RadioStationDto dto);
    RadioStationDto toDto(RadioStation entity);
}
