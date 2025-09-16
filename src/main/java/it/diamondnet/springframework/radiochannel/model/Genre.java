package it.diamondnet.springframework.radiochannel.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

// Free labels for filtering or categorizing (e.g., “indie”, “politics”, “local”, “live”)
@Builder
@Data
public class Genre {
    private final UUID id;                // Identificativo univoco    name	String	Nome del genere
    private final String description;	  // Descrizione
    
    //Relazione: RadioStation ↔ Genre (molti-a-molti)
}
