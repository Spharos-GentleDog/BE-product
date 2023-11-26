package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderProductInfoDto {

    private String brandName; // 상품
    private Long productId; // 상품 세부
    private Long productDetailId; // 상품 세부
    private String productName; // 상품
    private String color; //상품세부
    private String size; // 상품세부
    private Integer discountRate; // 상품세부
    private Integer productPrice; // 상품
    private Integer discountedPrice; // 계산
    private Integer count; // 상품 개수
    private String imgUrl; // 상품아이디 -> 섬네일이미지
    private String ImgName; // 상품아이디 -> 섬네일이미지

    public static OrderProductInfoDto formOrderProductInfoDto(String brandName, Long productId, Long productDetailId,
                                                              String productName, String color, String size,
                                                              Integer discountRate, Integer productPrice,
                                                            Integer discountedPrice, Integer count,
                                                              String imgUrl, String ImgName){
        return OrderProductInfoDto.builder()
                .brandName(brandName)
                .productId(productId)
                .productDetailId(productDetailId)
                .productName(productName)
                .color(color)
                .size(size)
                .discountRate(discountRate)
                .productPrice(productPrice)
                .discountedPrice(discountedPrice)
                .count(count)
                .imgUrl(imgUrl)
                .ImgName(ImgName)
                .build();
    }


}
