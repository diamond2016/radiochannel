package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import it.diamondnet.springframework.radiochannel.dto.RadioStationDto;
import it.diamondnet.springframework.radiochannel.mapper.GenreMapper;
import it.diamondnet.springframework.radiochannel.mapper.RadioStationMapper;
import it.diamondnet.springframework.radiochannel.mapper.TagMapper;
import it.diamondnet.springframework.radiochannel.mapper.UserFeedbackMapper;
import it.diamondnet.springframework.radiochannel.repositories.RadioStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RadioStationServiceImpl implements RadioStationService {

    private final RadioStationRepository radioStationRepository;
    private final RadioStationMapper radioStationMapper;
    private final GenreMapper genreMapper;
    private final TagMapper tagMapper;
    private final UserFeedbackMapper userFeedbackMapper;

    @Override
    public Set<RadioStationDto> getAllRadioStations() {
        return radioStationRepository.findAll()
                .stream()
                .map(radioStationMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public RadioStationDto getRadioStationById(UUID id) {
        return radioStationRepository.findById(id)
                .map(radioStationMapper::toDto)
                .orElse(null);
    }

    @Override
    public RadioStationDto saveNewRadioStation(RadioStationDto radioStationDto) {
        RadioStation radioStation = radioStationMapper.toEntity(radioStationDto);
        if (radioStation.getFeedbacks() != null) {
            radioStation.getFeedbacks().forEach(feedback -> feedback.setRadio_station_id(radioStation.getId()));
        }
        return radioStationMapper.toDto(radioStationRepository.save(radioStation));
    }

    @Override
    public void updateRadioStation(UUID id, RadioStationDto radioStationDto) {
        radioStationRepository.findById(id).ifPresent(radioStation -> {
            radioStation.setName(radioStationDto.getName());
            radioStation.setStreamUrl(radioStationDto.getStreamUrl());
            radioStation.setWebsite(radioStationDto.getWebsite());
            radioStation.setCountry(radioStationDto.getCountry());
            radioStation.setLanguage(radioStationDto.getLanguage());
            radioStation.setBitrate(radioStationDto.getBitrate());
            radioStation.setCodec(radioStationDto.getCodec());
            radioStation.setLogoUrl(radioStationDto.getLogoUrl());
            radioStation.setIsActive(radioStationDto.getIsActive());
            radioStation.setDescription(radioStationDto.getDescription());
            if (radioStationDto.getGenres() != null) {
                radioStation.setGenres(radioStationDto.getGenres().stream()
                        .map(genreMapper::toEntity)
                        .collect(Collectors.toSet()));
            }
            if (radioStationDto.getTags() != null) {
                radioStation.setTags(radioStationDto.getTags().stream()
                        .map(tagMapper::toEntity)
                        .collect(Collectors.toSet()));
            }
            if (radioStationDto.getFeedbacks() != null) {
                radioStation.setFeedbacks(radioStationDto.getFeedbacks().stream()
                        .map(userFeedbackMapper::toEntity)
                        .collect(Collectors.toSet()));
                radioStation.getFeedbacks().forEach(feedback -> feedback.setRadio_station_id(radioStation.getId()));
            }
            radioStationRepository.save(radioStation);
        });
    }

    @Override
    public void deleteRadioStation(UUID id) {
        radioStationRepository.deleteById(id);
    }
}
