package it.diamondnet.springframework.radiochannel.service;

import it.diamondnet.springframework.radiochannel.dto.UserFeedbackDto;

import java.util.Set;
import java.util.UUID;

public interface UserFeedbackService {

    Set<UserFeedbackDto> getAllUserFeedbacks();

    UserFeedbackDto getUserFeedbackById(UUID id);

    UserFeedbackDto saveNewUserFeedback(UserFeedbackDto userFeedbackDto);

    void updateUserFeedback(UUID id, UserFeedbackDto userFeedbackDto);

    void deleteUserFeedback(UUID id);
}
