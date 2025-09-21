package it.diamondnet.springframework.radiochannel.service;

import java.util.Set;
import java.util.UUID;

import it.diamondnet.springframework.radiochannel.dto.TagDto;

public interface TagService {
    // all tags existing
    Set<TagDto> getTags();

    // insert new Tag
    TagDto saveNewTag(TagDto tag);

    // update existing Tag
    void updateTagById(UUID tagId, TagDto tag);

    // delete existing Tag
    void deleteTagById(UUID tagId);

    // get single Tag
    TagDto getTagById(UUID tagId);
}
