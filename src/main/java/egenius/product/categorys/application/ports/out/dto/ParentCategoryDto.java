package egenius.product.categorys.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParentCategoryDto {

    private Integer parentCategoryId;
    private String parentCategoryName;

    public static ParentCategoryDto fromParentCategoryDto(
            Integer parentCategoryId, String parentCategoryName){

        return ParentCategoryDto.builder()
                .parentCategoryId(parentCategoryId)
                .parentCategoryName(parentCategoryName)
                .build();
    }
}
