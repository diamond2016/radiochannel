package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.domain.Tag;
import it.diamondnet.springframework.radiochannel.dto.TagDto;
import it.diamondnet.springframework.radiochannel.mapper.TagMapper;
import it.diamondnet.springframework.radiochannel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public Set<TagDto> getTags() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public TagDto saveNewTag(TagDto tag) {
        Tag newTag = Tag.builder()
            .id(UUID.randomUUID())
            .label(tag.getLabel())
            .build();

        Tag savedTag = tagRepository.save(newTag);
        return tagMapper.toDto(savedTag);
    }

    @Override
    public void updateTagById(UUID tagId, TagDto tag) {
        tagRepository.findById(tagId).ifPresent(foundTag -> {
            foundTag.setLabel(tag.getLabel());
            tagRepository.save(foundTag);
        });
    }

    @Override
    public void deleteTagById(UUID tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public TagDto getTagById(UUID tagId) {
        return tagRepository.findById(tagId)
            .map(tagMapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
