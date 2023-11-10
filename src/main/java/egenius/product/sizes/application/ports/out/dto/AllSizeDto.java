package egenius.product.sizes.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AllSizeDto {

    private Long sizeId;
    private String sizeName;

    public static AllSizeDto fromAllSizeDto(Long sizeId, String sizeName) {
        return AllSizeDto.builder()
                .sizeId(sizeId)
                .sizeName(sizeName)
                .build();
    }
}
