package com.axial.base.rest_api.demo;

import com.axial.base.constants.BaseMessageKeys;
import com.axial.modules.commons.exception.ExceptionHelper;
import com.axial.modules.commons.exception.handler.RestExceptionUtils;
import com.axial.modules.commons.message.enums.Severity;
import com.axial.modules.commons.message.model.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"app/api/v1/demo"})
public class DemoController {

    private final String controllerTag = "Demo App API Services";


    @GetMapping(value = "/demo1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo1() {

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/demo2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo2() {

        throw ExceptionHelper.newGenericException(BaseMessageKeys.ExceptionMessages.DEMO_MESSAGE, "Deneme 1-2");
    }


    @GetMapping(value = "/demo3", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo3() {

        throw ExceptionHelper.newGenericException(BaseMessageKeys.ExceptionMessages.REFLECTION_ENUM_CODE_TYPE_INCOMPATIBLE);
    }

    @PostMapping(value = "/demo4", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo4(@RequestBody DemoRequest request) {

        final SuccessResponse<Severity> successResponse = new SuccessResponse();
        successResponse.setResult(request.getSeverity());

        return ResponseEntity.ok(successResponse);
    }

    @GetMapping(value = "/demo5", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo5() {

        throw new NullPointerException();
    }

}
