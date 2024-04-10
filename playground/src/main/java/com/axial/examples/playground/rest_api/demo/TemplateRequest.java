package com.axial.examples.playground.rest_api.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TemplateRequest {

    private String text;

    private Map<String, String> parameters;

}
