package egenius.product.adaptor.web.controller;

import egenius.product.adaptor.web.request.CreateSizesRequest;
import egenius.product.application.sizeports.in.port.CreateSizesUseCase;
import egenius.product.application.sizeports.in.query.CreateSizesQuery;
import egenius.product.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class SizesController {

    private final CreateSizesUseCase createSizesUseCase;

    @PostMapping("/create-size")
    public BaseResponse<?> createSize(@RequestBody CreateSizesRequest createSizesRequest){
        log.info("사이즈 생성");

        return new BaseResponse<>(createSizesUseCase.createSize(CreateSizesQuery.toQuery(
                createSizesRequest.getSizeName())));
    }


}
