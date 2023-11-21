package egenius.product.categorys.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadChildCategoryCountQuery {

    private Integer parentCategoryId;

    public static ReadChildCategoryCountQuery toQuery(Integer parentCategoryId){
        return ReadChildCategoryCountQuery.builder()
                .parentCategoryId(parentCategoryId)
                .build();
    }

}
