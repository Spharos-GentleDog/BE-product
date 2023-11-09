package egenius.product.application.sizesports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReadAllSizesDto {

    private List<AllSizeDto> AllSizeDtoList;

    public static ReadAllSizesDto formReadSizes(List<AllSizeDto> allSizeDtoList){
        return ReadAllSizesDto.builder()
                .AllSizeDtoList(allSizeDtoList)
                .build();
    }

}
