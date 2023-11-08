package egenius.product.domain;

import egenius.product.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Categorys {


    private String categoryName;

    private String parentCategory; // 카테고리 대분류

    private List<String> childCategory;// 하위 카테고리들 (중분류)
}
