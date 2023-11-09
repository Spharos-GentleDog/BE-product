package egenius.product.application.colorports.in.query;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Builder
@Slf4j
public class CreateColorQuery {

    private String colorName;
    private String colorCode;

    public static CreateColorQuery toQuery(String colorName, String colorCode){
        return CreateColorQuery.builder()
                .colorName(colorName)
                .colorCode(colorCode)
                .build();
    }
}
