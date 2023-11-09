package egenius.product.application.service;

import egenius.product.application.colorports.in.port.CreateColorUseCase;
import egenius.product.application.colorports.in.port.ReadColorUseCase;
import egenius.product.application.colorports.in.query.CreateColorQuery;
import egenius.product.application.colorports.out.dto.ReadColorsDto;
import egenius.product.application.colorports.out.port.CreateColorPort;
import egenius.product.application.colorports.out.port.ReadColorsPort;
import egenius.product.domain.Colors;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponse;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColorService implements CreateColorUseCase, ReadColorUseCase {

    private final CreateColorPort createColorPort;
    private final ReadColorsPort readColorsPort;

    // 헥스코드에서 RGB값 분리 메소드
    public static int[] hexToRgb(String hex) {
        int[] rgb = new int[3];
        try {
            rgb[0] = Integer.parseInt(hex.substring(1, 3), 16);
            rgb[1] = Integer.parseInt(hex.substring(3, 5), 16);
            rgb[2] = Integer.parseInt(hex.substring(5, 7), 16);
            return rgb;
        }catch (Exception e) {
            throw new BaseException(BaseResponseStatus.COLOR_CODE_ERROR);
        }
    }

    //색상 생성
    @Override
    public void createColor(CreateColorQuery createColorQuery) {

        // 헥스코드에서 값 분리 메소드 호출
        int[] rgb = hexToRgb(createColorQuery.getColorCode());
        Colors colors = Colors.createColors(
                createColorQuery.getColorCode(),
                createColorQuery.getColorName(),
                rgb[0],
                rgb[1],
                rgb[2]
        );

        createColorPort.createColor(colors);
    }

    @Override
    public ReadColorsDto readColors() {

        ReadColorsDto readColorsDto = readColorsPort.readColors();

        return readColorsDto;
    }

    //색상 조회

}
