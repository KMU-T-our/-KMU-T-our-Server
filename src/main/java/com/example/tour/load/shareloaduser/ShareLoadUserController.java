package com.example.tour.load.shareloaduser;

import com.example.tour.load.shareloaduser.dto.ShareLoadUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 공유 짐에 유저 추가
@RestController
@RequiredArgsConstructor
public class ShareLoadUserController {

    private final ShareLoadUserService shareLoadUserService;

    // Load에 포함될 유저들의 아이디를 받는다.
    @PostMapping("/api/loaduser")
    public void saveLoadUser(@RequestBody ShareLoadUserSaveRequest request) {
        shareLoadUserService.save(request);
    }

    // Load에 포함된 사람들의 아이디를 반환한다.
    @GetMapping("/api/loaduser")
    public List<Long> get(@RequestParam Long loadId) {
        return shareLoadUserService.get(loadId);

    }

    // loadId 로 삭제하기
    @DeleteMapping("/api/loaduser")
    public void delete(@RequestParam Long loadId){
        shareLoadUserService.delete(loadId);
    }
}
