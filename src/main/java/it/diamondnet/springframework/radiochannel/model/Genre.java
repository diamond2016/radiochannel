package it.diamondnet.springframework.radiochannel.model;

import java.util.UUID;

public class Genre {
    UUID id;                // Identificativo univoco    name	String	Nome del genere
    String description;		// Descrizione opzionale
    
    //Relazione: RadioStation ↔ Genre (molti-a-molti)
}
