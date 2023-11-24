package egenius.product.categorys.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParentCategoryDto {

    private Integer CategoryId;
    private String parentCategoryName;

    public static ParentCategoryDto fromParentCategoryDto(
            Integer CategoryId, String parentCategoryName){

        return ParentCategoryDto.builder()
                .CategoryId(CategoryId)
                .parentCategoryName(parentCategoryName)
                .build();
    }
}
