package com.kd.learningSpring.SpringLearn1;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class ApiController {
private final VideoService videoService;
public ApiController(VideoService videoService) {
this.videoService = videoService;
}
@GetMapping("/api/videos")
public List<Video> all() {
return videoService.getVideos();
}
@PostMapping("/api/videos")
public Video newVideo(@RequestBody Video newVideo) {
return videoService.create(newVideo);
}
}
