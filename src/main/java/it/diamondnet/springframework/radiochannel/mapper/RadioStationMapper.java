package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import it.diamondnet.springframework.radiochannel.dto.RadioStationDto;

public interface RadioStationMapper {
@Mapper(componentModel = "spring")
public interface TagMapper {
    RadioStation toEntity(RadioStationDto dto);
    RadioStationDto toDto(RadioStation entity);
}
}
