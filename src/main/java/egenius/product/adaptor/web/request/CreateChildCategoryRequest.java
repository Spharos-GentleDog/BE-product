package egenius.product.adaptor.web.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateChildCategoryRequest {

    private String childCategoryName;
    private Integer parentCategoryId;

}
