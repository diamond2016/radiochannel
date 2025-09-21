package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;

@Mapper(componentModel = "spring")
public interface UserFeedbackMapper {
    //@Mapping(target = "radioStation", ignore = true)
    UserFeedback toEntity(UserFeedbackDto dto);

    @Mapping(source = "radioStationId", target = "radioStationId")
    UserFeedbackDto toDto(UserFeedback entity);
}
