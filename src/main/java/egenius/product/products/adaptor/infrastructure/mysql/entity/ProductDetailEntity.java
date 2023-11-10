package egenius.product.products.adaptor.infrastructure.mysql.entity;

import egenius.product.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_details")
public class ProductDetailEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_detail_code", nullable = false)
    private String productDetailCode;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "discount_rate", nullable = false)
    private Integer discountRate;

    @Column(name = "discount_type", nullable = true)
    private Integer discountTypes; // enum 타입의 code 저장 (0: 퍼센트, 1: 금액)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName="id")
    private ProductEntity productId; // 상품 인덱스


}
