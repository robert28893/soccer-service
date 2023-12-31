package vn.unigap.java.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.dto.in.PageDtoIn;
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
    public ResponseEntity<?> list(@Valid ListMatchDtoIn listMatchDtoIn, @Valid PageDtoIn pageDtoIn) {
        return responseEntity(() -> {
            return matchService.list(listMatchDtoIn, pageDtoIn);
        });
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Integer id) {
        return responseEntity(() -> {
            return matchService.get(id);
        });
    }
}
