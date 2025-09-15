package it.diamondnet.springframework.radiochannel.model;

import java.util.List;
import java.util.UUID;

public class RadioStation {
    UUID id; 	        // identificativo univoco
    String name;        // nome ufficiale della stazione
    String streamUrl;	// URL diretto al flusso audio (es. .mp3, .aac)
    String website;     // 	Sito ufficiale
    String country;	    // Paese di origine
    String language;	// Lingua principale
    Integer bitrate;	//	Qualità dello stream (es. 128 kbps)
    String codec;	    // Formato audio (es. MP3, AAC)
    String logoUrl;     //	URL immagine/logo
    Boolean isActive;	// Flag per indicare se il link è funzionante
    String description;	// Breve descrizione
    List<Genre> genres;	// Generi associati (relazione molti-a-molti)
    List<Tag> tags;	    // Parole chiave (relazione molti-a-molti)
}
