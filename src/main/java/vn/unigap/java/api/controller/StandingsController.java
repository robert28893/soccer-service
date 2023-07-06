package vn.unigap.java.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.api.dto.in.GetStandingsDtoIn;
import vn.unigap.java.api.service.StandingsService;
import vn.unigap.java.common.controller.AbstractResponseController;

@RestController
@RequestMapping(value = "/standings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StandingsController extends AbstractResponseController {

	private final StandingsService standingsService;

	@Autowired
	public StandingsController(StandingsService standingsService) {
		this.standingsService = standingsService;
	}

	@GetMapping(value = "")
	public ResponseEntity<?> get(@Valid GetStandingsDtoIn getStandingsDtoIn) {
		return responseEntity(() -> {
			return standingsService.get(getStandingsDtoIn);
		});
	}
}
