package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.in.query.AiServiceProductDetailQuery;
import egenius.product.products.application.ports.out.dto.AiServiceProductResultDto;

import java.util.List;

public interface AiServiceProductDetailPort {

    List<AiServiceProductResultDto> formAiServiceProductDetail(AiServiceProductDetailQuery aiServiceProductDetailQuery);
}
