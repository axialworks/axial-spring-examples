package com.axial.examples.single_database.extension.message.enums;

import com.axial.examples.single_database.extension.message.ExampleMessageUtils;
import com.axial.modules.commons.core.message.enums.Severity;
import com.axial.modules.commons.outline.message_key.MessageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExampleMessageKey implements MessageKey {

    DEMO_MESSAGE(
            ExampleMessageUtils.generateMessageCode(Severity.ERROR, "1"),
            "exception.example.demo.demo_exception"),

    REFLECTION_ENUM_CODE_TYPE_INCOMPATIBLE(
            ExampleMessageUtils.generateMessageCode(Severity.ERROR, "2"),
            "exception.module.commons.reflection.enum_code_type_incompatible");


    /*
        CODE: SeverityCode (1 digit) + ModuleCode (2 digit) + MessageCode (4 digit)
        EXAMPLE: 1 + 01 + 0001 => 101001
        Common Messages ModuleCode: 21
     */
    private String code;

    private String key;

}
