package it.diamondnet.springframework.radiochannel.controller;

import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;
import it.diamondnet.springframework.radiochannel.service.UserFeedbackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user-feedback")
public class UserFeedbackController {

    private final UserFeedbackService userFeedbackService;

    @GetMapping
    public Set<UserFeedbackDto> getUserFeedbacks() {
        log.debug("List UserFeedbacks - in controller");
        return userFeedbackService.getAllUserFeedbacks();
    }

    @GetMapping("{userFeedbackId}")
    public UserFeedbackDto getUserFeedbackById(@PathVariable("userFeedbackId") UUID userFeedbackId) {
        log.debug("get UserFeedback from id - in controller id: {}", userFeedbackId);
        return userFeedbackService.getUserFeedbackById(userFeedbackId);
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody UserFeedbackDto userFeedback) {
        UserFeedbackDto savedUserFeedback = userFeedbackService.saveNewUserFeedback(userFeedback);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/user-feedback/" + savedUserFeedback.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{userFeedbackId}")
    public ResponseEntity<Void> updateUserFeedbackById(@PathVariable("userFeedbackId") UUID userFeedbackId, @RequestBody UserFeedbackDto userFeedback) {
        userFeedbackService.updateUserFeedback(userFeedbackId, userFeedback);
        log.debug("update UserFeedback of ID - in controller id: {}", userFeedbackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{userFeedbackId}")
    public ResponseEntity<Void> deleteUserFeedbackById(@PathVariable("userFeedbackId") UUID userFeedbackId) {
        userFeedbackService.deleteUserFeedback(userFeedbackId);
        log.debug("delete UserFeedback of ID - in controller id: {}", userFeedbackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}