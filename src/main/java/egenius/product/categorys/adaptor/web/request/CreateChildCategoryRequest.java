package egenius.product.categorys.adaptor.web.request;

import lombok.Getter;

@Getter
public class CreateChildCategoryRequest {

    private String childCategoryName;
    private Integer parentCategoryId;

}
