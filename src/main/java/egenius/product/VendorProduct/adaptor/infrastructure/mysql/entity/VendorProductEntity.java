package egenius.product.VendorProduct.adaptor.infrastructure.mysql.entity;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductDetailEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Builder(toBuilder = true)
@Table(name = "Vendor_product")
public class VendorProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_email", nullable = false)
    private String vendorEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id", referencedColumnName="id")
    private ProductDetailEntity productDetailId;

    @Column(name = "display_status", nullable = false)
    private Integer displayStatus;

    @Column(name = "sales_status", nullable = false)
    private Integer salesStatus;

    @Column(name = "sales_count", nullable = false)
    private  Integer salesCount;

    @Column(name = "save_count", nullable = true)
    private  Integer saveCount;

    // 상품 생성
    public static VendorProductEntity createVendorProductEntity(String vendorEmail, ProductDetailEntity productDetailId,
                                                                Integer displayStatus, Integer salesStatus,
                                                                Integer salesCount, Integer saveCount){
        return VendorProductEntity.builder()
                .vendorEmail(vendorEmail)
                .productDetailId(productDetailId)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }

    //재고 수정
    public void updateVendorProductEntity(Integer displayStatus, Integer salesStatus,
                                          Integer salesCount, Integer saveCount){

        this.displayStatus = displayStatus;
        this.salesStatus = salesStatus;
        this.salesCount = salesCount;
        this.saveCount = saveCount;

    }

    public void deleteVendorProduct() {

        this.displayStatus = 1;
        this.salesStatus = 4;
        this.salesCount = 0;
        this.saveCount = 0;
    }

    //상품 삭제

}

