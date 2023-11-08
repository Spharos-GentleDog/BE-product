package egenius.product.adaptor.infrastructure.mysql.persistance;

import egenius.product.adaptor.infrastructure.mysql.entity.SizeEntity;
import egenius.product.adaptor.infrastructure.mysql.repository.SizesRepository;
import egenius.product.application.sizeports.out.dto.CreateSizeDto;
import egenius.product.application.sizeports.out.port.CreateSizePort;
import egenius.product.domain.Sizes;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SizesAdaptor implements CreateSizePort {

    private final SizesRepository sizesRepository;

    @Override
    public CreateSizeDto createSize(Sizes sizes) {

        SizeEntity sizeEntity = sizesRepository.save(SizeEntity.createSize(
                sizes.getSizeName()
        ));

        if(sizeEntity != null) {
            return CreateSizeDto.builder()
                    .sizeName(sizeEntity.getSizeName())
                    .build();
        }
        throw new BaseException(BaseResponseStatus.CREATE_SIZE_FAIL);

    }
}
