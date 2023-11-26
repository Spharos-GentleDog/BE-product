package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductDetailDto {


//    private Integer originalTotalPrice;
//    private Integer deliveryFee;
//    private Integer discountTotal;
//    private Integer totalPrice;
    private List<ProductDetailBrandDto> productDetailBrandDtoList;

//    public static FindProductDetailDto formFindProductDetailDto(Integer originalTotalPrice, Integer deliveryFee, Integer discountTotal,
//                                                                Integer totalPrice, List<ProductDetailBrandDto> productDetailBrandDtoList){
//        return FindProductDetailDto.builder()
//                .originalTotalPrice(originalTotalPrice)
//                .deliveryFee(deliveryFee)
//                .discountTotal(discountTotal)
//                .totalPrice(totalPrice)
//                .productDetailBrandDtoList(productDetailBrandDtoList)
//                .build();
//    }
    public static FindProductDetailDto formFindProductDetailDto(List<ProductDetailBrandDto> productDetailBrandDtoList){
        return FindProductDetailDto.builder()
                .productDetailBrandDtoList(productDetailBrandDtoList)
                .build();
    }

}
