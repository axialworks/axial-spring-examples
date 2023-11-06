package com.axial.base.rest_api.demo;

import com.axial.base.extension.message.enums.BaseMessageKey;
import com.axial.modules.commons.component.exception.ExceptionHelper;
import com.axial.modules.commons.core.message.enums.CommonMessageKey;
import com.axial.modules.commons.core.message.enums.Severity;
import com.axial.modules.commons.core.template_engine.TextTemplateService;
import com.axial.modules.commons.model.SuccessResponse;
import com.axial.modules.commons.component.mapping.ObjectMappingService;
import com.axial.modules.commons.core.request.model.GenericSuccessResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"app/api/v1/demo"})
public class DemoController {

    private final String controllerTag = "Demo App API Services";

    private final ObjectMappingService objectMappingService;

    private final TextTemplateService textTemplateService;


    @GetMapping(value = "/demo1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo1() {

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/demo2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo2() {

        throw ExceptionHelper.newGenericException(BaseMessageKey.DEMO_MESSAGE, "Deneme 1-2");
    }


    @GetMapping(value = "/demo3", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo3() {

        throw ExceptionHelper.newGenericException(CommonMessageKey.REFLECTION_ENUM_CODE_TYPE_INCOMPATIBLE);
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

    @PostMapping(value = "/demo6", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> demo6(@RequestBody DemoRequest request) {

        final String result = objectMappingService.objectToString(request);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/demo7", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> demo7() {

        final String result = objectMappingService.objectToString(Arrays.asList("Deneme1", "Deneme2"));

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/demo8-deep-copy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericSuccessResponse> demo8() {

        final List<String> lst = Arrays.asList("Deneme1", "Deneme2");
        final String str = objectMappingService.objectToString(lst);
        final List<String> obj = objectMappingService.stringToObject(str, objectMappingService.getTypeReference(lst));

        return ResponseEntity.ok(GenericSuccessResponse.builder()
                .success(true)
                .timestamp(LocalDateTime.now())
                .build()
                .addHashItem("lst", obj)
                .addHashItem("str", str)
                .addHashItem("deepCopy", objectMappingService.makeDeepCopy(lst)));
    }

    @PostMapping(value = "/demo9-template", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericSuccessResponse> demo9(@RequestBody TemplateRequest request) {


        final Context context = new Context();

        MapUtils.emptyIfNull(request.getParameters())
                .keySet().forEach(key ->
                        context.setVariable(key, request.getParameters().get(key)));

        final String processedStr = textTemplateService.processTemplate(request.getText(), context);

        final GenericSuccessResponse response = GenericSuccessResponse.builder().success(Boolean.TRUE).build();
        response.addHashItem("resultText", processedStr);
        return ResponseEntity.ok(response);
    }

}
