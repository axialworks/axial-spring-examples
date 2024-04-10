package com.axial.examples.playground.extension.message;

import com.axial.examples.playground.extension.message.constants.ExampleMessageConstants;
import com.axial.modules.commons.core.message.enums.Severity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExampleMessageUtils {

    public static final String generateMessageCode(Severity severity, String messageCode) {

        return com.axial.modules.commons.core.message.CommonMessageUtils.generateMessageCode(severity, ExampleMessageConstants.EXAMPLE_APP_MESSAGE_CODE, messageCode);
    }

}
