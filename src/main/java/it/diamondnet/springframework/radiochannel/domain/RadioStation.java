package it.diamondnet.springframework.radiochannel.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="radio_station")
public class RadioStation {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; 	        // identificativo univoco

    @Column(nullable = false)
    private String name;      // nome ufficiale della stazione

    @Column(nullable = false)
    private String streamUrl;	    // URL diretto al flusso audio (es. .mp3, .aac)

    @Column(nullable = false)
    private String website;         // 	Sito ufficiale

    @Column(nullable = true)
    private String country;	        // Paese di origine

    @Column(nullable = true)
    private String language;	    // Lingua principale

    @Column(nullable = true)
    private Integer bitrate;	    //	Qualità dello stream (es. 128 kbps)

    @Column(nullable = true)
    private String codec;	        // Formato audio (es. MP3, AAC)

    @Column(nullable = true)
    private String logoUrl;         //	URL immagine/logo

    @Column(nullable = true)
    private Boolean isActive;	    // Flag per indicare se il link è funzionante

    @Column(nullable = true)
    private String description;	    // Breve descrizione
    
    @ManyToMany
    @JoinTable(name = "radio_station_genre", joinColumns = @JoinColumn(name = "radio_station_id"), 
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;      // Generi associati (relazione molti-a-molti)

    @ManyToMany
    @JoinTable(name = "radio_station_tag", joinColumns = @JoinColumn(name = "radio_station_id"), 
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;        // Parole chiave (relazione molti-a-molti)
}
