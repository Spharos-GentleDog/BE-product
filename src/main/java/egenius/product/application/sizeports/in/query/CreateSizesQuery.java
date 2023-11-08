package egenius.product.application.sizeports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateSizesQuery {

    private String sizeName;

    public static CreateSizesQuery toQuery(String sizeName){
        return CreateSizesQuery.builder()
                .sizeName(sizeName)
                .build();
    }
}
