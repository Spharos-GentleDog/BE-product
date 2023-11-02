package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color_code",nullable = false)
    private Integer colorCode; // 색상 코드 (숫자 값)

    @Column(name = "colorName",nullable = false, length = 20)
    private String colorName; // 색상 명칭 (헥스 코드 값)

    @Column(name = "color_red",nullable = false)
    private Integer colorRed;

    @Column(name = "color_green",nullable = false)
    private Integer colorGreen;

    @Column(name = "color_blue",nullable = false)
    private Integer colorBlue;

    //자기 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_color", referencedColumnName = "id")
    private ColorEntity parentColor; // 색상 분류

    @OneToMany(mappedBy = "parent_color")
    @Column(name = "child_colors")
    private List<ColorEntity> childColors;// 하위 색상들


}
