package com.example.tour.tags.flight;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.flight.dto.FlightTagCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagResponse;
import com.example.tour.tags.flight.dto.FlightTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class FlightTagController {

    private final FlightTagService flightTagService;

    @PostMapping("/api/tags/flight")
    public Tag saveFlightTag(@RequestBody FlightTagCreateRequest request) {
        return flightTagService.saveFlightTag(request);
    }

    @GetMapping("/api/tags/flight")
    public FlightTagResponse getFlightTags(@RequestParam Long tagId) {
        return flightTagService.findByTagId(tagId);
    }

    @PatchMapping("/api/tags/flight")
    public void updateFlightTag(@RequestBody FlightTagUpdateRequest request) {
        flightTagService.updateFlightTag(request);
    }

    @DeleteMapping("/api/tags/flight")
    public void deleteFlightTag(@RequestParam Long tagId) {
        flightTagService.deleteFlightTag(tagId);
    }
}
