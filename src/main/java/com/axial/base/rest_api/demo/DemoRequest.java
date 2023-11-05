package com.axial.base.rest_api.demo;

import com.axial.modules.commons.message.enums.Severity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DemoRequest {

    private Severity severity;

}
