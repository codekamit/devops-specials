package com.experiment.devops_specials.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/devops")
@Log4j2
public class DevopsSpecialController {

    private String devOpsGoal;

    @GetMapping("goal")
    public String getDevopsGoal() {
        log.info("A request to fetch goal has come");
        if(this.devOpsGoal == null) {
            log.debug("Goal is not set yet");
            return "Let's kick in my development journey with automated CICD pipeline";
        }
        log.info("Goal : {}", this.devOpsGoal);
        return this.devOpsGoal;
    }

    @PostMapping("goal")
    public String setDevopsGoal(@RequestBody String devOpsGoal) {
        log.info("A request to set goal has come");
        this.devOpsGoal = devOpsGoal;
        return devOpsGoal;
    }
}
