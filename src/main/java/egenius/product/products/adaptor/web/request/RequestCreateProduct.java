package egenius.product.products.adaptor.web.request;

import egenius.product.products.domain.ImageInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestCreateProduct {

    private String productName; // 상품명
    private Integer productPrice; // 상품 가격 (상품별 가격 다 따로 받는 경우 금액도 리스트로 받아야 함)
    private String brandName; // 브랜드명
    private String brandLogoUrl; // 브랜드 로고 URL
    private List<String> categoryName; // 카테고리명
    private List<String> sizeName; // 사이즈명들
    private List<String> colorName; // 컬러명들
    private ImageInfo mainImageUrl; // 메인 이미지 Url
    private List<ImageInfo> thumbnailsImageUrl; // 썸네일Url들
    private List<ImageInfo> explainImageUrl; // 설명 이미지 Url들
}
