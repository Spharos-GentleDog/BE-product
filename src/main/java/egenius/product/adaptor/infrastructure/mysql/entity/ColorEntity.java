package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "color")
public class ColorEntity {

    // 판매자가 상품 등록시 해당하는 색상을 선택
    // 각 색상 분류별로 해당하는 색은 DB에 안 담는게 나을 듯 함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color_code",nullable = false)
    private String colorCode; // 색상 코드 (헥스 코드 값

    @Column(name = "colorName",nullable = false, length = 20)
    private String colorName; // 색상 명칭 (검정,빨강 등등)

    @Column(name = "color_red",nullable = false)
    private Integer colorRed;

    @Column(name = "color_green",nullable = false)
    private Integer colorGreen;

    @Column(name = "color_blue",nullable = false)
    private Integer colorBlue;

    public static ColorEntity createColor(String colorCode, String colorName,
                                          Integer colorRed, Integer colorGreen, Integer colorBlue){
        return ColorEntity.builder()
                .colorCode(colorCode)
                .colorName(colorName)
                .colorRed(colorRed)
                .colorGreen(colorGreen)
                .colorBlue(colorBlue)
                .build();
    }


}
