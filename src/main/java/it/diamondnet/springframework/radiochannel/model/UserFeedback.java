package it.diamondnet.springframework.radiochannel.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserFeedback {
    UUID id;	                // Identificativo univoco
    UUID radioId;	            // Stazione radio associata
    UUID userId;	            // Utente (se autenticato)
    Integer rating;	            // Valutazione (es. da 1 a 5)
    String comment;	            // Testo libero feedback
    LocalDateTime   timestamp;	// Data e ora del feedback
}
