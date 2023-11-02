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
    @ManyToOne // 자기 참조라서 fetch = FetchType.LAZY가 의미가 없음
    @JoinColumn(name = "parent_category", referencedColumnName = "id")
    private ProductCategoryEntity parentCategory; // 카테고리 대분류

    @OneToMany(mappedBy = "parentCategory")
    @Column(name = "child_category")
    private List<ProductCategoryEntity> childCategory;// 하위 카테고리들 (중분류)



}
