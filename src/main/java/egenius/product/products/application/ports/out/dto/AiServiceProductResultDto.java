package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AiServiceProductResultDto {

    private Long productId;
    private String productName;
    private Integer productPrice;
    private String MainImgUrl;
    private String MainImgName;
    private List<ColorDto> colorList;
    private List<String> sizeList;
    private List<AiServiceProductDetailsDto> productDetails;


    public static AiServiceProductResultDto formAiServiceProductDetailDto(Long productId, String productName, Integer productPrice,
                                                                          List<AiServiceProductDetailsDto> productDetails, String MainImgUrl, String MainImgName,
                                                                          List<ColorDto> colorList, List<String> sizeList){
        return AiServiceProductResultDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productDetails(productDetails)
                .MainImgUrl(MainImgUrl)
                .MainImgName(MainImgName)
                .colorList(colorList)
                .sizeList(sizeList)
                .build();
    }





}
