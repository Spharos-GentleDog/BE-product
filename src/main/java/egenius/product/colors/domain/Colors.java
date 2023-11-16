package egenius.product.colors.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Colors {

    private String colorCode; // 색상 코드 (헥스 코드 값
    private String colorName; // 색상 명칭 (검정,빨강 등등)
    private Integer colorRed;
    private Integer colorGreen;
    private Integer colorBlue;
    private List<ColorDetails> childColors;// 하위 색상들

    //색상 등록 (기본 제공 색상 등록)
    public static Colors createColors(String colorCode, String colorName,
                                      int colorRed, int colorGreen, int colorBlue) {
        return Colors.builder()
                .colorCode(colorCode)
                .colorName(colorName)
                .colorRed(colorRed)
                .colorGreen(colorGreen)
                .colorBlue(colorBlue)
                .build();
    }

    //색상 조회 (전체 색상 조회)
    public static Colors readColors(String colorCode, String colorName,
                                    int colorRed, int colorGreen, int colorBlue) {
        return Colors.builder()
                .colorCode(colorCode)
                .colorName(colorName)
                .colorRed(colorRed)
                .colorGreen(colorGreen)
                .colorBlue(colorBlue)
                .build();
    }

    //색상 삭제

    //색상 수정

}
