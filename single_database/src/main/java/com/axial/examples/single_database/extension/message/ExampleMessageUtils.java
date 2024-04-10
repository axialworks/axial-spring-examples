package com.axial.examples.single_database.extension.message;

import com.axial.examples.single_database.extension.message.constants.ExampleMessageConstants;
import com.axial.modules.commons.core.message.CommonMessageUtils;
import com.axial.modules.commons.core.message.enums.Severity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExampleMessageUtils {

    public static final String generateMessageCode(Severity severity, String messageCode) {

        return CommonMessageUtils.generateMessageCode(severity, ExampleMessageConstants.BASE_APP_MESSAGE_CODE, messageCode);
    }

}
