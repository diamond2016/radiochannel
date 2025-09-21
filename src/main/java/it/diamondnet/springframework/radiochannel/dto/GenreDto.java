package it.diamondnet.springframework.radiochannel.dto;

import java.util.UUID;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto {
    private UUID id;
    private String name;
    private String description;
    private RadioStation radioStation;	// Stazione radio associata
    
    // Relazione: Genre ↔ RadioStation (molti-a-uno)
}
