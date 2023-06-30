package vn.unigap.java.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.api.CompetitionService;
import vn.unigap.java.common.controller.AbstractResponseController;

@RestController
@RequestMapping(value = "/competitions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitionController extends AbstractResponseController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> list() {
        return responseEntity(() -> {
            return competitionService.list();
        });
    }
}
