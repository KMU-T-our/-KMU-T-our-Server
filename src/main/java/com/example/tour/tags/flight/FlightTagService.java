package com.example.tour.tags.flight;

import com.example.tour.tags.flight.domain.FlightTag;
import com.example.tour.tags.flight.dto.FlightTagsCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightTagService {

    private final FlightTagRepository flightTagRepository;

    @Transactional
    public void saveFlightTag(FlightTagsCreateRequest request) {
        FlightTag f = flightTagRepository.save(new FlightTag(request));
    }

    @Transactional
    public List<FlightTag> getFlightTag() {
        return flightTagRepository.findAll();
    }

    @Transactional
    public void updateFlightTag(FlightTagsUpdateRequest request) {
        FlightTag flightTag = flightTagRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        flightTag.updateFlightTag(request);
    }

    @Transactional
    public void deleteFlightTag(Long id) {
        FlightTag flightTag = flightTagRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        flightTagRepository.delete(flightTag);
    }
}
