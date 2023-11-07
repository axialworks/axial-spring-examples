package com.axial.base.extension.database.converter;

import com.axial.base.enums.Gender;
import com.axial.modules.commons.outline.enum_code.EnumCodeConverter;


public class GenderConverter extends EnumCodeConverter<Gender> {

    @Override
    public Class<Gender> getClassType() {
        return Gender.class;
    }
}
