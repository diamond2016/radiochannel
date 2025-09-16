package it.diamondnet.springframework.radiochannel.repositories;

import it.diamondnet.springframework.radiochannel.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
