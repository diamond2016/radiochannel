package it.diamondnet.springframework.radiochannel.mapper;

import org.mapstruct.Mapper;

import it.diamondnet.springframework.radiochannel.domain.Tag;
import it.diamondnet.springframework.radiochannel.dto.TagDto;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag toEntity(TagDto dto);
    TagDto toDto(Tag entity);
}
