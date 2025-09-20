package it.diamondnet.springframework.radiochannel.repositories;

import it.diamondnet.springframework.radiochannel.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
