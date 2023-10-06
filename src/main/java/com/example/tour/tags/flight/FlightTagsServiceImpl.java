package com.example.tour.tags.flight;

import com.example.tour.tags.flight.domain.FlightTags;
import com.example.tour.tags.flight.dto.FlightTagsCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightTagsServiceImpl {

    private final FlightTagsRepository flightTagsRepository;

    @Transactional
    public void saveFlightTags(FlightTagsCreateRequest request){
        FlightTags f = flightTagsRepository.save(new FlightTags(request));
    }

    @Transactional
    public List<FlightTags> getFlightTags(){
        return flightTagsRepository.findAll();
    }

    @Transactional
    public void updaterFlightTags(FlightTagsUpdateRequest request){
        FlightTags flightTags = flightTagsRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        flightTags.updateDB(request);
    }

    @Transactional
    public void deleteFlightTags(Long id){
        FlightTags flightTags = flightTagsRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        flightTagsRepository.delete(flightTags);
    }
}
