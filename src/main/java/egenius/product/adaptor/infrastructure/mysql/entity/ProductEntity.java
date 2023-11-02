package egenius.product.adaptor.infrastructure.mysql.entity;

import egenius.product.domain.enums.DiscountTypes;
import egenius.product.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "brand_logo_url", nullable = false)
    private String brandLogoUrl;

    @Column(name = "discount_rate", nullable = false)
    private Integer discount;

    @Column(name = "discount_type", nullable = false)
    private Integer discountTypes; // enum 타입의 code 저장 (0: 퍼센트, 1: 금액)

    // 연관관계있는 entity 연결
    // 중간 테이블 관리를 위한 연관 관계 설정
    // CascadeType 뭘로 할지 고민 중
    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductCategoryListEntity> productCategoryListEntity;

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductImageEntity> productImageEntity;

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductSizeListEntity> productSizeListEntity;

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductColorListEntity> productColorListEntity;


}
