package com.example.tour.controller.tags;

import com.example.tour.domain.tags.FlightTags;
import com.example.tour.dto.tags.FlightTagsCreateRequest;
import com.example.tour.dto.tags.FlightTagsUpdateRequest;
import com.example.tour.service.tags.FlightTagsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class FlightTagsController {

    private final FlightTagsServiceImpl flightTagsService;

    @PostMapping("/api/tags/flight")
    public void saveFlightTags(@RequestBody FlightTagsCreateRequest request){
        flightTagsService.saveFlightTags(request);
    }

    @GetMapping("/api/tags/flight")
    public ResponseEntity<List<FlightTags>> getFlightTags(){
        return ResponseEntity.ok()
                .body(flightTagsService.getFlightTags());
    }

    @PutMapping("api/tags/flight")
    public void updateFlightTags(@RequestBody FlightTagsUpdateRequest request){
        flightTagsService.updaterFlightTags(request);
    }

    @DeleteMapping("api/tags/flight")
    public void deleteFlightTags(@RequestParam Long id){
        flightTagsService.deleteFlightTags(id);
    }
}
