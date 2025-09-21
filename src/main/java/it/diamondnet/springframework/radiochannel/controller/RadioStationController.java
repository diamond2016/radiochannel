package it.diamondnet.springframework.radiochannel.controller;

import it.diamondnet.springframework.radiochannel.dto.RadioStationDto;
import it.diamondnet.springframework.radiochannel.service.RadioStationService;
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
@RequestMapping("/api/v1/radio-station")
public class RadioStationController {

    private final RadioStationService radioStationService;

    @GetMapping
    public Set<RadioStationDto> getRadioStations() {
        log.debug("List RadioStations - in controller");
        return radioStationService.getAllRadioStations();
    }

    @GetMapping("{radioStationId}")
    public RadioStationDto getRadioStationById(@PathVariable("radioStationId") UUID radioStationId) {
        log.debug("get RadioStation from id - in controller id: {}", radioStationId);
        return radioStationService.getRadioStationById(radioStationId);
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody RadioStationDto radioStation) {
        RadioStationDto savedRadioStation = radioStationService.saveNewRadioStation(radioStation);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/radio-station/" + savedRadioStation.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{radioStationId}")
    public ResponseEntity<Void> updateRadioStationById(@PathVariable("radioStationId") UUID radioStationId, @RequestBody RadioStationDto radioStation) {
        radioStationService.updateRadioStation(radioStationId, radioStation);
        log.debug("update RadioStation of ID - in controller id: {}", radioStationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{radioStationId}")
    public ResponseEntity<Void> deleteRadioStationById(@PathVariable("radioStationId") UUID radioStationId) {
        radioStationService.deleteRadioStation(radioStationId);
        log.debug("delete RadioStation of ID - in controller id: {}", radioStationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}