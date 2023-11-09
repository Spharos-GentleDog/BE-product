package egenius.product.application.categoryports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateChildCategoryQuery {

    private Integer  parentCategoryId;
    private String childCategoryName;

    public static CreateChildCategoryQuery toQuery(Integer parentCategoryId, String childCategoryName){
        return CreateChildCategoryQuery.builder()
                .parentCategoryId(parentCategoryId)
                .childCategoryName(childCategoryName)
                .build();
    }
}
