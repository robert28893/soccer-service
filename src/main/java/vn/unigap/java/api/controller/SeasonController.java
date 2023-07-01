package vn.unigap.java.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.api.dto.in.ListSeasonDtoIn;
import vn.unigap.java.api.service.SeasonService;
import vn.unigap.java.common.controller.AbstractResponseController;

@RestController
@RequestMapping(value = "/season", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class SeasonController extends AbstractResponseController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> list(@Valid ListSeasonDtoIn listSeasonDtoIn) {
        return responseEntity(() -> {
            return seasonService.list(listSeasonDtoIn);
        });
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> get(@PathVariable(value = "id") Integer id) {
//        return responseEntity(() -> {
//            return competitionService.get(id);
//        });
//    }
}
