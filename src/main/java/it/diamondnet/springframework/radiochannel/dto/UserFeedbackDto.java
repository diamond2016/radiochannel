package it.diamondnet.springframework.radiochannel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Allows users to leave comments, ratings, or reports.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFeedbackDto {
    private UUID id;	                // Identificativo univoco
    private RadioStation radioStation;	            // Stazione radio associata
    private UUID userId;	            // Utente (se autenticato)
    private Integer rating;	            // Valutazione (es. da 1 a 5)
    private String comment;	            // Testo libero feedback
    private LocalDateTime   timestamp;	// Data e ora del feedback
}
