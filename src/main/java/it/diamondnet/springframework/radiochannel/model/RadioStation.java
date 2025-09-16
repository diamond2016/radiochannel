package it.diamondnet.springframework.radiochannel.model;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

// Represents a radio station available for streaming.
@Builder
@Data
public class RadioStation {
    private final UUID id; 	        // identificativo univoco
    private final String name;      // nome ufficiale della stazione
    private String streamUrl;	    // URL diretto al flusso audio (es. .mp3, .aac)
    private String website;         // 	Sito ufficiale
    private String country;	        // Paese di origine
    private String language;	    // Lingua principale
    private Integer bitrate;	    //	Qualità dello stream (es. 128 kbps)
    private String codec;	        // Formato audio (es. MP3, AAC)
    private String logoUrl;         //	URL immagine/logo
    private Boolean isActive;	    // Flag per indicare se il link è funzionante
    private String description;	    // Breve descrizione
    private List<Genre> genres;	    // Generi associati (relazione molti-a-molti)
    private List<Tag> tags;	        // Parole chiave (relazione molti-a-molti)
}
