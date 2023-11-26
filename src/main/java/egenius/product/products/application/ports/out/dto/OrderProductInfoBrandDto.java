package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderProductInfoBrandDto {

    private Integer originalTotalPrice;
    private Integer deliveryFee;
    private Integer discountTotal;
    private Integer totalPrice;
    private List<OrderProductInfoListDto> orderProductInfoListDto;


    public static OrderProductInfoBrandDto formOrderProductInfoBrandDto(Integer originalTotalPrice, Integer deliveryFee, Integer discountTotal,
                                                                        Integer totalPrice, List<OrderProductInfoListDto> orderProductInfoListDto){
        return OrderProductInfoBrandDto.builder()
                .originalTotalPrice(originalTotalPrice)
                .deliveryFee(deliveryFee)
                .discountTotal(discountTotal)
                .totalPrice(totalPrice)
                .orderProductInfoListDto(orderProductInfoListDto)
                .build();
    }




}
