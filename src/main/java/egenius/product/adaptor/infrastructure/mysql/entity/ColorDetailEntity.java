package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "color_detail")
public class ColorDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color_code",nullable = false)
    private String colorCode; // 색상 코드 (헥스 코드 값

    @Column(name = "color_red",nullable = false)
    private Integer colorRed;

    @Column(name = "color_green",nullable = false)
    private Integer colorGreen;

    @Column(name = "color_blue",nullable = false)
    private Integer colorBlue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private ColorEntity colorId; // 색상 인덱스

}
