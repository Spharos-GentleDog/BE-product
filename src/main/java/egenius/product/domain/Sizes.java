package egenius.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Sizes {

    private String sizeName; // 사이즈 명칭 (S,M,L,XL 등등)

    //사이즈 등록
    public static Sizes createSizes(String sizeName) {
        return Sizes.builder()
                .sizeName(sizeName)
                .build();
    }

    //사이즈 삭제
    public static Sizes deleteSizes(String sizeName) {
        return Sizes.builder()
                .sizeName(sizeName)
                .build();
    }

    //사이즈 수정
    public static Sizes updateSizes(String sizeName) {
        return Sizes.builder()
                .sizeName(sizeName)
                .build();
    }

}
