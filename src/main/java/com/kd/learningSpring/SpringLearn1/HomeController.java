package com.kd.learningSpring.SpringLearn1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final VideoService videoService;
    public HomeController(VideoService videoService) {
      this.videoService = videoService;
    }
@GetMapping("/")
public String index(Model model) {
model.addAttribute("videos", videoService.getVideos());
return "index";
}
@GetMapping("/react")
public String react() {
  return "react";
}
@PostMapping("/new-video")
public String newVideo(@ModelAttribute Video newVideo) {              /*@PostMapping("/new-video"): Spring MVC’s annotation to capture POST /new-video calls and route them to this method.
                                                                      @ModelAttribute: Spring MVC’s annotation to parse an incoming HTML form and unpack it into a Video object.
                                                                        videoService.create(): Not-yet-written method for storing the new video object.
                                                                         "redirect:/": Spring MVC directive that sends the browser an HTTP 302 Found to URL /. A 302 redirect is the standard for a soft redirect. (301 is a permanent redirect, instructing the browser to not try the original path again.) */
videoService.create(newVideo);
return "redirect:/";
}
}