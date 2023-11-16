package egenius.product.colors.adaptor.web.controller;


import egenius.product.colors.adaptor.web.request.CreateColorRequest;
import egenius.product.colors.application.ports.in.port.CreateColorUseCase;
import egenius.product.colors.application.ports.in.port.ReadColorUseCase;
import egenius.product.colors.application.ports.in.query.CreateColorQuery;
import egenius.product.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ColorController {

    private final CreateColorUseCase createColorUseCase;
    private final ReadColorUseCase readColorUseCase;

    // 컬러 생성
    @PostMapping("/create-color")
    public BaseResponse<?> createColor(@RequestBody CreateColorRequest createColorRequest){
        log.info("컬러 생성");
        createColorUseCase.createColor(CreateColorQuery.toQuery(
                createColorRequest.getColorName(),
                createColorRequest.getColorCode()
        ));
        return new BaseResponse<>();
    }

    @GetMapping("/read-colors")
    public BaseResponse<?> readColors(){
        log.info("컬러 조회");
        return new BaseResponse<>(readColorUseCase.readColors());
    }
}
