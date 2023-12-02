package com.example.tour.load.personal;


import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.load.personal.domain.PersonalLoad;
import com.example.tour.load.personal.dto.PersonalLoadRequest;
import com.example.tour.load.personal.dto.PersonalLoadResponse;
import com.example.tour.load.share.dto.ShareLoadResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonalLoadController {

    private final PersonalLoadServiceImpl personalLoadService;

    @PostMapping("/api/load/personal")
    public PersonalLoadResponse savePersonalLoad(@RequestBody PersonalLoadRequest request){
        return personalLoadService.savePersonalLoad(request);
    }

    @GetMapping("/api/load/personals")
    public ResponseEntity<List<PersonalLoadResponse>> getAllPersonalLoad(@RequestParam Long projectUserId){
        return ResponseEntity.ok()
                .body(personalLoadService.getAllPersonalLoad(projectUserId));
    }

    @GetMapping("/api/load/personal")
    public PersonalLoadResponse getPersonalLoad(@RequestBody PersonalLoadRequest request){
        return personalLoadService.getPersonalLoad(request);
    }

    @PatchMapping("/api/load/personal")
    public void updatePersonalLoad(@RequestBody PersonalLoadRequest request){
        personalLoadService.updaterPersonalLoad(request);
    }

    @DeleteMapping("api/load/personal")
    public void deletePersonalLoad(@RequestParam Long id){
        personalLoadService.deletePersonalLoad(id);
    }
}
