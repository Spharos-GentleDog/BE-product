package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_image")
public class ProductImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "image_type", nullable = false)
    private Integer imageType; // enum (0: 일반 이미지 , 1: 썸네일 이미지)

    @Column(name = "main_image", nullable = false)
    private Integer mainImage; //enum (0: 사용, 1: 사용안함)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private ProductEntity productId; // 상품 인덱스

}
