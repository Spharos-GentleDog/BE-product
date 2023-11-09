package egenius.product.application.sizesports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReadAllSizesDto {

    private List<String> sizeNames;

    public static ReadAllSizesDto formReadSizes(List<String> sizeNames){
        return ReadAllSizesDto.builder()
                .sizeNames(sizeNames)
                .build();
    }

}
