package egenius.product.adaptor.web.controller;

import egenius.product.adaptor.web.request.CreateSizesRequest;
import egenius.product.application.sizesports.in.port.CreateSizesUseCase;
import egenius.product.application.sizesports.in.port.ReadAllSizesUseCase;
import egenius.product.application.sizesports.in.query.CreateSizesQuery;
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
    private final ReadAllSizesUseCase readAllSizesUseCase;


    // 사이즈 등록
    @PostMapping("/create-size")
    public BaseResponse<?> createSize(@RequestBody CreateSizesRequest createSizesRequest){
        log.info("사이즈 생성");
        createSizesUseCase.createSize(CreateSizesQuery.toQuery(
                createSizesRequest.getSizeName()));
        return new BaseResponse<>();
    }

    //사이즈 전체 조회
    @GetMapping("/read-all-size")
    public BaseResponse<?> readAllSize(){
        log.info("사이즈 전체 조회");
        return new BaseResponse<>(readAllSizesUseCase.readAllSizes());
    }

    //

}
