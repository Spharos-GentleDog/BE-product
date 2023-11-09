package egenius.product.application.categoryports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReadParentCategoryDto {

    private List<ParentCategoryDto>  parentCategoryDtoList;

    public static ReadParentCategoryDto formReadParentCategoryDto(
            List<ParentCategoryDto> parentCategoryDtoList){

        return ReadParentCategoryDto.builder()
                .parentCategoryDtoList(parentCategoryDtoList)
                .build();
    }

}
