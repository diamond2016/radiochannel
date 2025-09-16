package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;

import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;

@Mapper(componentModel = "spring")
public interface UserFeedbackMapper {
    UserFeedback toEntity(UserFeedbackDto dto);
    UserFeedbackDto toDto(UserFeedback entity);
}

