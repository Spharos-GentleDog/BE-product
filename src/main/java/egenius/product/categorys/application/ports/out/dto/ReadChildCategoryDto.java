package egenius.product.categorys.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadChildCategoryDto {

    private Integer CategoryId;
    private String childCategoryName;

    public static ReadChildCategoryDto fromChildCategory(Integer CategoryId, String childCategoryName){
        return ReadChildCategoryDto.builder()
                .CategoryId(CategoryId)
                .childCategoryName(childCategoryName)
                .build();
    }



}
