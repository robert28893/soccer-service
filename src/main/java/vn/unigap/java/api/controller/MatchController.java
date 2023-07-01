package vn.unigap.java.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.service.MatchService;
import vn.unigap.java.common.controller.AbstractResponseController;

@RestController
@RequestMapping(value = "/match", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MatchController extends AbstractResponseController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> list(@Valid ListMatchDtoIn listMatchDtoIn) {
        return responseEntity(() -> {
            return matchService.list(listMatchDtoIn);
        });
    }
}
