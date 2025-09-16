package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.domain.Tag;
import it.diamondnet.springframework.radiochannel.dto.TagDto;
import it.diamondnet.springframework.radiochannel.mapper.TagMapper;
import it.diamondnet.springframework.radiochannel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public Set<TagDto> getSetTags() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public TagDto saveNewTag(String label) {
        Tag newTag = Tag.builder().label(label).build();
        Tag savedTag = tagRepository.save(newTag);
        return tagMapper.toDto(savedTag);
    }

    @Override
    public void updateTagById(UUID tagId, TagDto tag) {
        //TO DO // TO DO implement correctly update
        //TagDto existingTag = tagRepository.findById(tagId);
        //existingTag.setLabel(tag.getLabel());

    }

    @Override
    public void deleteTagById(UUID tagId) {
        // TO DO implement correctly delete
        //return tagRepository.findById(tagId).map(tag -> {
        //    tagRepository.delete(tag);
        //}).orElse(null); // Or throw an exception
    }
}
