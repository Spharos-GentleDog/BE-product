package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductDto {

    private Integer productId; // 상품 ID
    private String productName; // 상품명
    private Integer productPrice; // 상품 가격
    private String MainImageUrl; // 메인 이미지 Url
    private String brandName; // 브랜드명
    private Integer discountRate; // 할인율
    private Integer discountType; // 할인 가격
    private Integer totalFavorite; // 총 좋아요 수
    private List<String> Sizes; // 사이즈
    private List<String> Colors; //
    private String salesStatus; // 판매 상태 (0: 판매중, 1: 품절, 2: 판매중지)


    public static FindProductDto formfindProducrDto(Integer productId, String productName, Integer productPrice,
                                                      String MainImageUrl, String brandName, Integer discountRate,
                                                      Integer discountType, Integer totalFavorite, List<String> Sizes,
                                                      List<String> Colors, String salesStatus) {
        return FindProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .MainImageUrl(MainImageUrl)
                .brandName(brandName)
                .discountRate(discountRate)
                .discountType(discountType)
                .totalFavorite(totalFavorite)
                .Sizes(Sizes)
                .Colors(Colors)
                .salesStatus(salesStatus)
                .build();
    }


}
