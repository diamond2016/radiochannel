package it.diamondnet.springframework.radiochannel.dto;

import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Represents a radio station available for streaming.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadioStationDto {
    private UUID id; 	               // identificativo univoco
    private String name;           // nome ufficiale della stazione
    private String streamUrl;	    // URL diretto al flusso audio (es. .mp3, .aac)
    private String website;         // 	Sito ufficiale
    private String country;	        // Paese di origine
    private String language;	    // Lingua principale
    private Boolean isActive;	    // Flag per indicare se il link è funzionante
    private String description;	    // Breve descrizione
    private Set<GenreDto> genres;	 // Generi associati (relazione molti-a-molti)
    private Set<TagDto> tags;	     // Parole chiave (relazione molti-a-molti)
    private Set<UserFeedbackDto> feedbacks;	     // Feedback utenti sulla radio (relazione uno-a-molti)
}
