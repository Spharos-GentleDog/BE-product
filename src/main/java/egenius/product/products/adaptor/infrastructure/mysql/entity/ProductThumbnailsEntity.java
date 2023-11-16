package egenius.product.products.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_thumbnails")
public class ProductThumbnailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thumbnails_image_name", nullable = false)
    private String ThumbnailsImageName;

    @Column(name = "thumbnails_image_url", nullable = false)
    private String ThumbnailsImageUrl;

    @Column(name = "used_main_image", nullable = false)
    private Integer usedMainImage; //enum (0: 사용, 1: 사용안함)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private ProductEntity productId; // 상품 인덱스

    public static ProductThumbnailsEntity createProductThumbnails(String ThumbnailsImageName, String ThumbnailsImageUrl,
                                                                  Integer usedMainImage, ProductEntity productId) {
        return ProductThumbnailsEntity.builder()
                .ThumbnailsImageName(ThumbnailsImageName)
                .ThumbnailsImageUrl(ThumbnailsImageUrl)
                .usedMainImage(usedMainImage)
                .productId(productId)
                .build();
    }

}
