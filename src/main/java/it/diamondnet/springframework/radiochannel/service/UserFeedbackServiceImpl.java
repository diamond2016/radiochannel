package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;
import it.diamondnet.springframework.radiochannel.mapper.UserFeedbackMapper;
import it.diamondnet.springframework.radiochannel.repositories.RadioStationRepository;
import it.diamondnet.springframework.radiochannel.repositories.UserFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFeedbackServiceImpl implements UserFeedbackService {

    private final UserFeedbackRepository userFeedbackRepository;
    private final UserFeedbackMapper userFeedbackMapper;
    private final RadioStationRepository radioStationRepository;

    @Override
    public Set<UserFeedbackDto> getAllUserFeedbacks() {
        return userFeedbackRepository.findAll()
                .stream()
                .map(userFeedbackMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UserFeedbackDto getUserFeedbackById(UUID id) {
        return userFeedbackRepository.findById(id)
                .map(userFeedbackMapper::toDto)
                .orElse(null);
    }

    @Override
    public UserFeedbackDto saveNewUserFeedback(UserFeedbackDto userFeedbackDto) {
        UserFeedback userFeedback = userFeedbackMapper.toEntity(userFeedbackDto);
        RadioStation radioStation = radioStationRepository.findById(userFeedbackDto.getRadioStationId()).orElseThrow();
        userFeedback.setRadio_station_id(radioStation.getId());
        return userFeedbackMapper.toDto(userFeedbackRepository.save(userFeedback));
    }

    @Override
    public void updateUserFeedback(UUID id, UserFeedbackDto userFeedbackDto) {
        userFeedbackRepository.findById(id).ifPresent(userFeedback -> {
            RadioStation radioStation = radioStationRepository.findById(userFeedbackDto.getRadioStationId()).orElseThrow();
            userFeedback.setRadio_station_id(radioStation.getId());
            userFeedback.setUserId(userFeedbackDto.getUserId());
            userFeedback.setRating(userFeedbackDto.getRating());
            userFeedback.setComment(userFeedbackDto.getComment());
            userFeedback.setTimestamp(userFeedbackDto.getTimestamp());
            userFeedbackRepository.save(userFeedback);
        });
    }

    @Override
    public void deleteUserFeedback(UUID id) {
        userFeedbackRepository.deleteById(id);
    }
}
