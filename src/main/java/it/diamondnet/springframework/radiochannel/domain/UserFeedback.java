package it.diamondnet.springframework.radiochannel.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="user_feedback")
public class UserFeedback {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;	                    // Identificativo univoco
    
    @ManyToOne
    @JoinColumn(name = "radio_station_id")
    private RadioStation radioStation;

    @Column(nullable = true)
    private UUID userId;	                // Utente (se autenticato)

    @Column(nullable = false)
    private Integer rating;	            // Valutazione (es. da 1 a 5)

    @Column(nullable = false)
    private String comment;	            // Testo libero feedback

    @Column(nullable = false)
    private LocalDateTime   timestamp;	// Data e ora del feedback
}
