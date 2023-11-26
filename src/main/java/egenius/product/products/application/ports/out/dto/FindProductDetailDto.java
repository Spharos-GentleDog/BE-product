package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductDetailDto {


    private Long productId;
    private String productName;
    private Integer productPrice;
    private List<String> productThumnailImageUrl;

}
