package egenius.product.categorys.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateParentCategoryQuery {

    private String CategoryName;

    public static CreateParentCategoryQuery toQuery(String categoryName){
        return CreateParentCategoryQuery.builder()
                .CategoryName(categoryName)
                .build();
    }


}
