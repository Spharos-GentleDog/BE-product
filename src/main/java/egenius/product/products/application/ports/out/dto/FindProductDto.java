package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductDto {

    private Long productId; // 상품 ID
    private String productName; // 상품명
    private Integer productPrice; // 상품 가격
    private String MainImageName; // 메인 이미지 이름
    private String MainImageUrl; // 메인 이미지 Url
    private String brandName; // 브랜드명
    private List<DiscountsDto> discounts; // 할인 정보
//    private Integer discountMinPrice; // 최소 할인 가격
//    private Integer discountMaxPrice; // 최대 할인 가격
    private Integer totalFavorite; // 총 좋아요 수
    private List<String> Sizes; // 사이즈
    private List<ColorDto> Colors; //
    private String salesStatus; // 판매 상태 (0: 판매중, 1: 품절, 2: 판매중지)


    public static FindProductDto formFindProductDto(Long productId, String productName, Integer productPrice,
                                                    String MainImageName, String MainImageUrl, String brandName,
                                                    List<DiscountsDto> discounts, Integer totalFavorite,
                                                    List<String> Sizes, List<ColorDto> Colors, String salesStatus) {
        return FindProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .MainImageName(MainImageName)
                .MainImageUrl(MainImageUrl)
                .brandName(brandName)
                .discounts(discounts)
//                .discountMinPrice(discountMinPrice)
//                .discountMaxPrice(discountMaxPrice)
                .totalFavorite(totalFavorite)
                .Sizes(Sizes)
                .Colors(Colors)
                .salesStatus(salesStatus)
                .build();
    }


}
