package egenius.product.categorys.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadChildCategoryQuery {

    private Integer parentCategoryId;

    public static ReadChildCategoryQuery toQuery(Integer parentCategoryId){
        return ReadChildCategoryQuery.builder()
                .parentCategoryId(parentCategoryId)
                .build();
    }
}
