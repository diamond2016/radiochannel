package it.diamondnet.springframework.radiochannel.repositories;

import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RadioStationRepository extends JpaRepository<RadioStation, UUID> {
}
