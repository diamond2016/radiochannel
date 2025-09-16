package it.diamondnet.springframework.radiochannel.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

// Musical or thematic category of the radio (e.g., Rock, Jazz, News, Talk).
@Builder
@Data
public class Tag {
    private final UUID id;	        // Identificativo univoco
    private final String label;	    // Testo del tag
    
    // Relazione: RadioStation ↔ Tag (molti-a-molti)
}
