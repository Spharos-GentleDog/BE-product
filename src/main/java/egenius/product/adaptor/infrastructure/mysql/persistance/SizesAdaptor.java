package egenius.product.adaptor.infrastructure.mysql.persistance;

import egenius.product.adaptor.infrastructure.mysql.entity.SizeEntity;
import egenius.product.adaptor.infrastructure.mysql.repository.SizesRepository;
import egenius.product.application.sizesports.out.dto.CreateSizeDto;
import egenius.product.application.sizesports.out.dto.ReadAllSizesDto;
import egenius.product.application.sizesports.out.port.CreateSizePort;
import egenius.product.application.sizesports.out.port.ReadAllSizesPort;
import egenius.product.domain.Sizes;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class SizesAdaptor implements CreateSizePort, ReadAllSizesPort {

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


    @Override
    public ReadAllSizesDto readAllSizes() {

        List<SizeEntity> sizeEntityList = sizesRepository.findAll();
        ReadAllSizesDto readAllSizesDto = ReadAllSizesDto.formReadSizes(
                sizeEntityList.stream()
                .map(SizeEntity::getSizeName)
                .collect(Collectors.toList()));

        return readAllSizesDto;
    }
}
