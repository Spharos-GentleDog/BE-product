package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageInfoDto {

    private String imageName;
    private String imageUrl;

    public static ImageInfoDto formImageInfoDto(String imageName, String imageUrl){
        return ImageInfoDto.builder()
                .imageName(imageName)
                .imageUrl(imageUrl)
                .build();
    }
}
