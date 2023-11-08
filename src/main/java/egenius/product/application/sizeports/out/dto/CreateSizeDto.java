package egenius.product.application.sizeports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateSizeDto {

    // out model
    // persisitence Adaptor의 일부분으로 출력 결과 값을 반환 받는다
    // 반환 값을 전달하는 DTO

    private String sizeName;

    public static CreateSizeDto formCreateSize(String sizeName){
        return CreateSizeDto.builder()
                .sizeName(sizeName)
                .build();
    }

}
