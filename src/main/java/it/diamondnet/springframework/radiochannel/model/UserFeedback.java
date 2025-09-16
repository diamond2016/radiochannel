package it.diamondnet.springframework.radiochannel.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

// Allows users to leave comments, ratings, or reports.
@Builder
@Data
public class UserFeedback {
    private final UUID id;	                    // Identificativo univoco
    private final UUID radioId;	                // Stazione radio associata
    private UUID userId;	                    // Utente (se autenticato)
    private final Integer rating;	            // Valutazione (es. da 1 a 5)
    private final String comment;	            // Testo libero feedback
    private final LocalDateTime   timestamp;	// Data e ora del feedback
}
