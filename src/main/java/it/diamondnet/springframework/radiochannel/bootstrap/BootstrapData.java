package it.diamondnet.springframework.radiochannel.bootstrap;

import it.diamondnet.springframework.radiochannel.domain.Genre;
import it.diamondnet.springframework.radiochannel.domain.RadioStation;
import it.diamondnet.springframework.radiochannel.domain.Tag;
import it.diamondnet.springframework.radiochannel.domain.UserFeedback;
import it.diamondnet.springframework.radiochannel.repositories.GenreRepository;
import it.diamondnet.springframework.radiochannel.repositories.RadioStationRepository;
import it.diamondnet.springframework.radiochannel.repositories.TagRepository;
import it.diamondnet.springframework.radiochannel.repositories.UserFeedbackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final RadioStationRepository radioStationRepository;
    private final GenreRepository genreRepository;
    private final TagRepository tagRepository;
    private final UserFeedbackRepository userFeedbackRepository;

    public BootstrapData(RadioStationRepository radioStationRepository, GenreRepository genreRepository, TagRepository tagRepository, UserFeedbackRepository userFeedbackRepository) {
        this.radioStationRepository = radioStationRepository;
        this.genreRepository = genreRepository;
        this.tagRepository = tagRepository;
        this.userFeedbackRepository = userFeedbackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadGenres();
        loadTags();
        loadRadioStationsAndFeedback();
    }

    private void loadGenres() {
        if (genreRepository.count() == 0) {
            Genre rock = Genre.builder().name("Rock").description("Rock music").build();
            Genre pop = Genre.builder().name("Pop").description("Pop music").build();

            genreRepository.saveAll(Arrays.asList(rock, pop));
        }
    }

    private void loadTags() {
        if (tagRepository.count() == 0) {
            Tag politics = Tag.builder().label("Politics").build();
            Tag info = Tag.builder().label("Info").build();
            Tag coolMusic = Tag.builder().label("Cool Music").build();

            tagRepository.saveAll(Arrays.asList(politics, info, coolMusic));
        }
    }

    private void loadRadioStationsAndFeedback() {
        if (radioStationRepository.count() == 0) {

            Genre rock = genreRepository.findAll().get(0);
            Tag politics = tagRepository.findAll().get(0);

            Set<Genre> genres = new HashSet<>();
            genres.add(rock);

            Set<Tag> tags = new HashSet<>();
            tags.add(politics);

            RadioStation radio24 = RadioStation.builder()
                    .name("radio24")
                    .streamUrl("http://shoutcast.radio24.it:8000/listen.pls")
                    .website("https://www.radio24.ilsole24ore.com/")
                    .country("IT")
                    .language("IT")
                    .isActive(true)
                    .description("Radio24 Il Sole 24 ore")
                    .genres(genres)
                    .tags(tags)
                    .build();

            radioStationRepository.save(radio24);

            UserFeedback feedback = UserFeedback.builder()
                    .rating(5)
                    .comment("Great station!")
                    .timestamp(LocalDateTime.now())
                    .radio_station_id(radio24.getId())
                    .build();

            userFeedbackRepository.save(feedback);
        }
    }
}