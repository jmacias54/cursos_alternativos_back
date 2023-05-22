package com.mx.alternativecourses.api.application.controller.api.scores;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.SCORES, produces = MediaType.APPLICATION_JSON_VALUE)
public class ScoresApiController {
}
