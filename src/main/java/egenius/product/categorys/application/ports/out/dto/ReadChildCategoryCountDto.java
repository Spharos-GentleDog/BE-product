package egenius.product.categorys.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadChildCategoryCountDto {


    private Integer childCategoryId;
    private String childCategoryName;
    private Integer productCount;

    public static ReadChildCategoryCountDto fromChildCategory(Integer childCategoryId, String childCategoryName,
                                                              Integer productCount){
        return ReadChildCategoryCountDto.builder()
                .childCategoryId(childCategoryId)
                .childCategoryName(childCategoryName)
                .productCount(productCount)
                .build();
    }
}
