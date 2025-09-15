package it.diamondnet.springframework.radiochannel.model;

import java.util.UUID;

public class Tag {
    UUID id;	        // I dentificativo univoco
    String label;	    // Testo del tag
    
    // Relazione: RadioStation ↔ Tag (molti-a-molti)
}
