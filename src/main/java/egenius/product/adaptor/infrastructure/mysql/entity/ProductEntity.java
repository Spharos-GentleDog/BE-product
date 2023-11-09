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
@Table(name = "product")
public class ProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "brand_logo_url", nullable = false)
    private String brandLogoUrl;

    // 연관관계있는 entity 연결
    // 중간 테이블 관리를 위한 연관 관계 설정
    // CascadeType 뭘로 할지 고민 중
    // 아래 부분은 상품 조회시 다 필요한 부분이라서 EAGER로 설정
    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductDetailEntity> productDetailEntity; // 상품 상세 정보

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductCategoryListEntity> productCategoryListEntity; // 상품 카테고리 정보

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductSizeListEntity> productSizeListEntity; // 상품 사이즈 정보

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductColorListEntity> productColorListEntity; // 상품 색상 정보

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductThumbnailsEntity> productThumbnailsEntity; // 상품 썸네일 정보

    @OneToMany(mappedBy = "productId" , cascade = CascadeType.ALL)
    private List<ProductExplainImageEntity> productExplainImageEntity; // 상품 설명 이미지 정보


}
