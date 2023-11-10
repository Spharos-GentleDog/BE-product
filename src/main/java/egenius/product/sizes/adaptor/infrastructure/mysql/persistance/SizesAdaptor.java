package egenius.product.sizes.adaptor.infrastructure.mysql.persistance;

import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import egenius.product.sizes.adaptor.infrastructure.mysql.repository.SizesRepository;
import egenius.product.sizes.application.ports.out.dto.AllSizeDto;
import egenius.product.sizes.application.ports.out.dto.ReadAllSizesDto;
import egenius.product.sizes.application.ports.out.port.CreateSizePort;
import egenius.product.sizes.application.ports.out.port.ReadAllSizesPort;
import egenius.product.sizes.domain.Sizes;
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
    public void createSize(Sizes sizes) {

        SizeEntity sizeEntity = sizesRepository.save(SizeEntity.createSize(
                sizes.getSizeName()
        ));

        if(sizeEntity != null) {
            return;
        }
        throw new BaseException(BaseResponseStatus.CREATE_SIZE_FAIL);

    }


    @Override
    public ReadAllSizesDto readAllSizes() {

        List<SizeEntity> sizeEntityList = sizesRepository.findAll();

        List<AllSizeDto> allSizeDtoList = sizeEntityList.stream()
                .map(sizeEntity -> AllSizeDto.fromAllSizeDto(sizeEntity.getId(), sizeEntity.getSizeName()))
                .collect(Collectors.toList());

        return ReadAllSizesDto.formReadSizes(allSizeDtoList);
    }
}
