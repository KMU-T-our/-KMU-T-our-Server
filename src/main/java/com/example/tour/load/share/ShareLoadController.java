package com.example.tour.load.share;

import com.example.tour.load.share.domain.ShareLoad;
import com.example.tour.load.share.dto.ShareLoadResponse;
import com.example.tour.load.share.dto.ShareLoadSaveRequest;
import com.example.tour.load.share.dto.ShareLoadRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ShareLoadController {

    private final ShareLoadServiceImpl shareLoadService;

    @PostMapping("/api/load/share")
    public void saveShareLoad(@RequestBody ShareLoadSaveRequest request) {
        shareLoadService.saveShareLoad(request);
    }

    @GetMapping("/api/load/shares")
    public ResponseEntity<List<ShareLoad>> getAllShareLoad(@RequestBody ShareLoadRequest request){
        return ResponseEntity.ok()
                .body(shareLoadService.getAllShareLoad(request));
    }

    @GetMapping("/api/load/share")
    public ShareLoadResponse getShareLoad(@RequestBody ShareLoadRequest request){
        return shareLoadService.getShareLoad(request);
    }

    @PutMapping("/api/load/share")
    public void updateShareLoad(@RequestBody ShareLoadRequest request) {
        shareLoadService.updaterShareLoad(request);
    }

    @DeleteMapping("/api/load/share")
    public void deleteShareLoad(@RequestParam Long id){
        shareLoadService.deleteShareLoad(id);
    }

}
