package com.axial.examples.database.converter;

import com.axial.examples.enums.Gender;
import com.axial.modules.commons.outline.enum_code.EnumCodeConverter;


public class GenderConverter extends EnumCodeConverter<Gender> {

    @Override
    public Class<Gender> getClassType() {
        return Gender.class;
    }
}
