package it.diamondnet.springframework.radiochannel.repositories;

import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, UUID> {
}
