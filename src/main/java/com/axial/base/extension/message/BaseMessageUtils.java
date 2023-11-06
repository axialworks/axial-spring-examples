package com.axial.base.extension.message;

import com.axial.base.extension.message.constants.BaseMessageConstants;
import com.axial.modules.commons.core.message.CommonMessageUtils;
import com.axial.modules.commons.core.message.enums.Severity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseMessageUtils {

    public static final String generateMessageCode(Severity severity, String messageCode) {

        return CommonMessageUtils.generateMessageCode(severity, BaseMessageConstants.BASE_APP_MESSAGE_CODE, messageCode);
    }

}
