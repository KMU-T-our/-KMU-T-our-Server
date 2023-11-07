package com.example.tour.tags.flight;

import com.example.tour.tags.flight.domain.FlightTag;
import com.example.tour.tags.flight.dto.FlightTagsCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagsUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class FlightTagController {

    private final FlightTagService flightTagsService;

    @PostMapping("/api/tags/flight")
    public void saveFlightTag(@RequestBody FlightTagsCreateRequest request) {
        flightTagsService.saveFlightTag(request);
    }

    @GetMapping("/api/tags/flight")
    public ResponseEntity<List<FlightTag>> getFlightTags() {
        return ResponseEntity.ok()
                .body(flightTagsService.getFlightTag());
    }

    @PutMapping("/api/tags/flight")
    public void updateFlightTag(@RequestBody FlightTagsUpdateRequest request) {
        flightTagsService.updateFlightTag(request);
    }

    @DeleteMapping("/api/tags/flight")
    public void deleteFlightTag(@RequestParam Long id) {
        flightTagsService.deleteFlightTag(id);
    }
}
