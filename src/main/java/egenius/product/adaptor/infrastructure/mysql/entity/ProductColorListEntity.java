package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_color_list")
public class ProductColorListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //상품이 삭제되면 상품 색상 리스트도 삭제되도록 설정
    // cascade = CascadeType은 아직 뭘로 할지 고민중
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private ProductEntity productId; // 상품 인덱스

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="color_id", referencedColumnName = "id")
    private ColorEntity colorId; // 색상 인덱스


}
