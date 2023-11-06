package com.axial.base.rest_api.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class TemplateRequest {

    private String text;

    private Map<String, String> parameters;

}
