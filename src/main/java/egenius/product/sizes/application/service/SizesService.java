package egenius.product.sizes.application.service;

import egenius.product.sizes.application.ports.in.port.CreateSizesUseCase;
import egenius.product.sizes.application.ports.in.port.ReadAllSizesUseCase;
import egenius.product.sizes.application.ports.in.query.CreateSizesQuery;
import egenius.product.sizes.application.ports.out.dto.ReadAllSizesDto;
import egenius.product.sizes.application.ports.out.port.CreateSizePort;
import egenius.product.sizes.application.ports.out.port.ReadAllSizesPort;
import egenius.product.sizes.domain.Sizes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SizesService implements CreateSizesUseCase, ReadAllSizesUseCase {

    private final CreateSizePort createSizePort;
    private final ReadAllSizesPort readAllSizesPort;

    //사이즈 생성
    @Override
    public void createSize(CreateSizesQuery createSizesQuery) {

        Sizes sizes = Sizes.createSizes(createSizesQuery.getSizeName());

        createSizePort.createSize(sizes);

    }

    //사이즈 전체 조회
    @Override
    public ReadAllSizesDto readAllSizes() {

        ReadAllSizesDto readAllSizesDto = readAllSizesPort.readAllSizes();

        return readAllSizesDto ;
    }

    //사이즈 삭제



}
