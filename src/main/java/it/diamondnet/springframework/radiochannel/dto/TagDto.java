package it.diamondnet.springframework.radiochannel.dto;

import java.util.UUID;

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
    private UUID id;	        // Identificativo univoco
    private String label;	    // Testo del tag
    
    // Relazione: RadioStation ↔ Tag (molti-a-molti)
}
