package egenius.product.colors.application.ports.in.port;

import egenius.product.colors.application.ports.in.query.CreateColorQuery;

public interface CreateColorUseCase {

    void createColor(CreateColorQuery createColorQuery);
}
