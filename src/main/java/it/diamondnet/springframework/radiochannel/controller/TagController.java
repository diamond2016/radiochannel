package it.diamondnet.springframework.radiochannel.controller;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.diamondnet.springframework.radiochannel.dto.TagDto;
import it.diamondnet.springframework.radiochannel.service.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tag") //no final shash
public class TagController {
    private final TagService tagService;

    @GetMapping("{tagId}")
    public TagDto getGenreById(@PathVariable("tagId") UUID tagId) {

        log.debug("get Tag from id - in controller id: {}", tagId);
        
        return tagService.getTagById(tagId);
    }

    @GetMapping
    public Set<TagDto> getTags() {

        log.debug("List Tags - in controller ");
        
        return tagService.getTags();
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody TagDto tag) {

        TagDto savedTag = tagService.saveNewTag(tag); 

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/tag" + savedTag.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{tagId}")
    public ResponseEntity<Void> updateTagById(@PathVariable("tagId") UUID tagId, @RequestBody TagDto tag) {

        tagService.updateTagById(tagId, tag);
        log.debug("update Tag of ID - in controller id: {}", tagId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{tagId}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable("tagId") UUID tagId) {

        tagService.deleteTagById(tagId);
        log.debug("delete Tag of ID - in controller id: {}", tagId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}