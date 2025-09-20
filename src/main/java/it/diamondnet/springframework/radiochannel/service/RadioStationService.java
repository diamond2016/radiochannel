package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.dto.RadioStationDto;

import java.util.Set;
import java.util.UUID;

public interface RadioStationService {

    Set<RadioStationDto> getAllRadioStations();

    RadioStationDto getRadioStationById(UUID id);

    RadioStationDto saveNewRadioStation(RadioStationDto radioStationDto);

    void updateRadioStation(UUID id, RadioStationDto radioStationDto);

    void deleteRadioStation(UUID id);
}
