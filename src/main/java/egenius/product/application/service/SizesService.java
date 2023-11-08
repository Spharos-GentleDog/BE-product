package egenius.product.application.service;

import egenius.product.application.sizeports.in.port.CreateSizesUseCase;
import egenius.product.application.sizeports.in.query.CreateSizesQuery;
import egenius.product.application.sizeports.out.dto.CreateSizeDto;
import egenius.product.application.sizeports.out.port.CreateSizePort;
import egenius.product.domain.Sizes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SizesService implements CreateSizesUseCase {

    private final CreateSizePort createSizePort;

    @Override
    public CreateSizeDto createSize(CreateSizesQuery createSizesQuery) {

        Sizes sizes = Sizes.createSizes(createSizesQuery.getSizeName());

        createSizePort.createSize(sizes);

        return null;
    }
}
