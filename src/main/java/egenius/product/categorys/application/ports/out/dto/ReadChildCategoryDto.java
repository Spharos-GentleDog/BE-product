package egenius.product.categorys.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadChildCategoryDto {

    private Integer childCategoryId;
    private String childCategoryName;

    public static ReadChildCategoryDto fromChildCategory(Integer childCategoryId, String childCategoryName){
        return ReadChildCategoryDto.builder()
                .childCategoryId(childCategoryId)
                .childCategoryName(childCategoryName)
                .build();
    }



}
