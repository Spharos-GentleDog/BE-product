package egenius.product.domain;

import egenius.product.adaptor.infrastructure.mysql.entity.ColorEntity;
import jakarta.persistence.*;
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
    private List<String> childColors;// 하위 색상들

}
