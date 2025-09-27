package it.diamondnet.springframework.radiochannel.controller;

import it.diamondnet.springframework.radiochannel.service.RadioStationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/")
public class RadioStationPageController {

    private final RadioStationService radioStationService;

    @GetMapping
    public String listRadioStations(Model model) {
        model.addAttribute("radioStations", radioStationService.getAllRadioStations());
        return "index";
    }

    @GetMapping("/station/{id}")
    public String stationDetails(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("radioStation", radioStationService.getRadioStationById(id));
        return "station";
    }
}
