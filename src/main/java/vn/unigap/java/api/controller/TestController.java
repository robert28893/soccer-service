package vn.unigap.java.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.java.common.controller.AbstractResponseController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController extends AbstractResponseController {

    @GetMapping(value = "/test")
//	@PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> test() {
        return responseEntity(() -> {
//			throw new RuntimeException();
//			throw new ApiException(2, HttpStatus.BAD_REQUEST, "error");
            Map<String, String> map = new HashMap<>();
            map.put("x", "y");
            return map;
        });
    }
}
