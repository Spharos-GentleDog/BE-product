package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderProductInfoListDto {

    private String brandName; // 상품
    private String vendorEmail;
    private Integer brandTotalPrice; // 브랜드별 총 가격
    private Integer brandDeliveryFee; // 브랜드별 배송비
    private List<OrderProductInfoDto> orderProductInfoDto; // 상품 리스트

    public static OrderProductInfoListDto formOrderProductInfoListDto(String brandName, String vendorEmail,
                                                                      Integer brandTotalPrice,
                                                                      Integer brandDeliveryFee, List<OrderProductInfoDto> orderProductInfoDto){

        return OrderProductInfoListDto.builder()
                .brandName(brandName)
                .vendorEmail(vendorEmail)
                .brandTotalPrice(brandTotalPrice)
                .brandDeliveryFee(brandDeliveryFee)
                .orderProductInfoDto(orderProductInfoDto)
                .build();
    }
}
