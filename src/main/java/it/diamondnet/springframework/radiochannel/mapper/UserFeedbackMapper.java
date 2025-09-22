package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;

@Mapper(componentModel = "spring")
public interface UserFeedbackMapper {
    @Mapping(source = "radioStationId", target = "radio_station_id")
    UserFeedback toEntity(UserFeedbackDto dto);

    @Mapping(source = "radio_station_id", target = "radioStationId")
    UserFeedbackDto toDto(UserFeedback entity);
}
