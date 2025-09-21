package it.diamondnet.springframework.radiochannel.dto;

import java.util.UUID;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Musical or thematic category of the radio (e.g., Rock, Jazz, News, Talk).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDto {
    private UUID id;	                // Identificativo univoco
    private String label;	            // Testo del tag
    private RadioStation radioStation;	// Stazione radio associata
    
    // Relazione: Tag ↔ RadioStation (molti-a-uno)
}
