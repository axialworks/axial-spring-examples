package com.axial.examples.single_database.enums;

import com.axial.modules.commons.outline.enum_code.EnumCode;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Gender implements EnumCode<Gender> {

    MALE("MALE", "Erkek", null),
    FEMALE("FEMALE", "Kadın", null);

    @JsonValue
    String code;

    String name;

    String explanation;

    Gender(String code, String name, String explanation) {
        this.code = code;
        this.name = name;
        this.explanation = explanation;
    }

    /*
    public static List<Gender> getEnumValues() {
        return List.of(Gender.values());
    }

    public static Gender findByCode(String enumCode) {

        if (StringUtils.isBlank(enumCode)) {
            return null;
        }

        return Arrays.stream(Gender.values())
                .filter(enumValue -> enumValue.getCode().equalsIgnoreCase(enumCode))
                .findFirst().orElse(null);
    }
     */

}
