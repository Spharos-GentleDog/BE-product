package egenius.product.products.adaptor.infrastructure.mysql.entity;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "favorite_product_total")
public class ProductCategoryListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //상품이 삭제되면 상품 카테고리 리스트도 삭제되도록 설정
    // cascade = CascadeType은 아직 뭘로 할지 고민중
    // category에 해당하는 상품 리스트를 보기 위함으로 상품 세부를 같이 가져올 필요 없음
    // FetchType.LAZY로 하지 않으면 상품을 같이 가져오기 때문에 성능 저하가 발생할 수 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private ProductEntity productId; // 상품 인덱스

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private ProductCategoryEntity categoryId; // 카테고리 인덱스



}
