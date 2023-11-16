package egenius.product.products.adaptor.infrastructure.mysql.entity;

import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_size_list")
public class ProductSizeListEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="product_id", referencedColumnName = "id")
        private ProductEntity productId; // 상품 인덱스

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="size_id", referencedColumnName = "id")
        private SizeEntity sizeId; // 사이즈 인덱스

        public static ProductSizeListEntity createProductSizeList(SizeEntity sizeId, ProductEntity productId){
                return ProductSizeListEntity.builder()
                        .productId(productId)
                        .sizeId(sizeId)
                        .build();
        }
}
