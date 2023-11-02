package com.axial.rest_api;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"app/api/v1/demo"})
public class DemoController {

    private final String controllerTag = "Demo App API Services";


    @GetMapping(value = "/demo1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo1() {

        return ResponseEntity.ok(Boolean.TRUE);
    }


}
