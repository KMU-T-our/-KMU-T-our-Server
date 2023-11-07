package com.example.tour.load.loaduser;

import com.example.tour.load.loaduser.dto.LoadUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 공유 짐에 유저 추가
@RestController
@RequiredArgsConstructor
public class LoadUserController {

    private final LoadUserService loadUserService;

    // Load에 포함될 유저들의 아이디를 받는다.
    @PostMapping("/api/loaduser")
    public void saveLoadUser(@RequestBody LoadUserSaveRequest request) {
        loadUserService.save(request);
    }

    // Load에 포함된 사람들의 아이디를 반환한다.
    @GetMapping("/api/loaduser")
    public List<Long> get(@RequestParam Long loadId) {
        return loadUserService.get(loadId);

    }
}
