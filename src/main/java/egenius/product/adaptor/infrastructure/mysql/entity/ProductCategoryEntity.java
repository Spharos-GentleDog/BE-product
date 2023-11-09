package egenius.product.adaptor.infrastructure.mysql.entity;

import egenius.product.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_category")
public class ProductCategoryEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    //자기 참조
    @ManyToOne
    @JoinColumn(name = "parent_category", referencedColumnName = "id")
    private ProductCategoryEntity parentCategory; // 카테고리 대분류

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    @Column(name = "child_category")
    private List<ProductCategoryEntity> childCategory;// 하위 카테고리들 (중분류)

    // 카테고리 등록 (대분류 등록)
    public static ProductCategoryEntity createParentCategory(String categoryName){
        return ProductCategoryEntity.builder()
                .categoryName(categoryName)
                .build();
    }


    public static ProductCategoryEntity createChildCategory(String categoryName, ProductCategoryEntity parentCategory) {
        return ProductCategoryEntity.builder()
                .categoryName(categoryName)
                .parentCategory(parentCategory)
                .build();

    }
}
