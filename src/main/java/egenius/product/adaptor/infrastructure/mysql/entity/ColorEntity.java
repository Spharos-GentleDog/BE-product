package egenius.product.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "colorClassification", referencedColumnName = "id")
    private ColorEntity colorClassification;

    @Column(name = "color_code",nullable = false, length = 20)
    private String colorCode;

    @Column(name = "colorName",nullable = false, length = 20)
    private String colorName;



}
