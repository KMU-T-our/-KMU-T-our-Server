package com.example.tour.load.personal;


import com.example.tour.load.personal.domain.PersonalLoad;
import com.example.tour.load.personal.dto.PersonalLoadRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonalLoadController {

    private final PersonalLoadServiceImpl personalLoadService;

    @PostMapping("/api/load/personal")
    public void savePersonalLoad(@RequestBody PersonalLoadRequest request){
        personalLoadService.savePersonalLoad(request);
    }

    @GetMapping("/api/load/personal")
    public ResponseEntity<List<PersonalLoad>> getPersonalLoad(){
        return ResponseEntity.ok()
                .body(personalLoadService.getPersonalLoad());
    }

    @PutMapping("/api/load/personal")
    public void updatePersonalLoad(@RequestBody PersonalLoadRequest request){
        personalLoadService.updaterPersonalLoad(request);
    }

    @DeleteMapping("api/load/personal")
    public void deletePersonalLoad(@RequestParam Long id){
        personalLoadService.deletePersonalLoad(id);
    }
}
