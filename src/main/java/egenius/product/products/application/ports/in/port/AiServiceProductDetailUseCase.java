package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.AiServiceProductDetailQuery;
import egenius.product.products.application.ports.out.dto.AiServiceProductResultDto;

import java.util.List;

public interface AiServiceProductDetailUseCase {

    List<AiServiceProductResultDto> getAiServiceProductDetail(AiServiceProductDetailQuery aiServiceProductDetailQuery);
}
