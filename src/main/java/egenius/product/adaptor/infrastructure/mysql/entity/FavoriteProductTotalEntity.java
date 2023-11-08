package egenius.product.adaptor.infrastructure.mysql.entity;

import egenius.product.adaptor.infrastructure.mysql.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "favorite_product_total")
public class FavoriteProductTotalEntity {
    // 총 찜 수 계산 후 결과 값 저장

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_favorite", nullable = true)
    private Integer totalFavorite;

    @OneToOne // fetch = FetchType.LAZY를 걸어줘도 기본적으로 EAGER로 동작함
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity productId; // 상품 인덱스
}
