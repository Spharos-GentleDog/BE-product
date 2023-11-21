package egenius.product.VendorProduct.adaptor.infrastructure.mysql.persistance.adaptors;

import egenius.product.VendorProduct.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.product.VendorProduct.adaptor.infrastructure.mysql.persistance.converter.DisplayStatusConverter;
import egenius.product.VendorProduct.adaptor.infrastructure.mysql.persistance.converter.SalesStatusConverter;
import egenius.product.VendorProduct.adaptor.infrastructure.mysql.repository.VendorProductRepository;
import egenius.product.VendorProduct.application.ports.out.dto.GetSalesCountDto;
import egenius.product.VendorProduct.application.ports.out.dto.GetVendorProductDto;
import egenius.product.VendorProduct.application.ports.out.port.*;
import egenius.product.VendorProduct.domain.VendorProduct;
import egenius.product.VendorProduct.domain.enums.DisplayStatus;
import egenius.product.VendorProduct.domain.enums.SalesStatus;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import egenius.product.products.adaptor.infrastructure.mysql.entity.FavoriteProductTotalEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductDetailEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductThumbnailsEntity;
import egenius.product.products.adaptor.infrastructure.mysql.repository.FavoriteProductTotalRepository;
import egenius.product.products.adaptor.infrastructure.mysql.repository.ProductDetailRepository;
import egenius.product.products.adaptor.infrastructure.mysql.repository.ProductRepository;
import egenius.product.products.adaptor.infrastructure.mysql.repository.ProductThumbnailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class VendorProductAdaptor implements UpdateVendorProductPort, GetVendorProductPort,
        DeleteVendorProductPort, GetSalesCountPort {

    private final VendorProductRepository vendorProductRepository;
    private final DisplayStatusConverter displayStatusConverter;
    private final SalesStatusConverter salesStatusConverter;
    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;
    private final ProductThumbnailsRepository productThumbnailsRepository;
    private final FavoriteProductTotalRepository favoriteProductTotalRepository;


    @Override
    public void updateVendorProduct(VendorProduct vendorProduct) {
        log.info("판매자 상품 재고 정보 변경:{}", vendorProduct.getProductDetailId());

        Optional<ProductDetailEntity> productDetailEntity =
                productDetailRepository.findById(vendorProduct.getProductDetailId());

        if(!productDetailEntity.isPresent()){
            //상품 세부가 없다고 에러처리
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);

        }
        log.info("상품 세부 코드: {}", productDetailEntity.get().getId());
        VendorProductEntity vendorProductEntity =
                vendorProductRepository.findByVendorEmailAndProductDetailId(
                        vendorProduct.getVendorEmail(),
                        productDetailEntity.get()
                );

        if(vendorProductEntity == null){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        vendorProductEntity.updateVendorProductEntity(
                displayStatusConverter.convertToDatabaseColumn(DisplayStatus.ofNameValue(vendorProduct.getDisplayStatus())),
                salesStatusConverter.convertToDatabaseColumn(SalesStatus.ofNameValue(vendorProduct.getSalesStatus())),
                vendorProduct.getSalesCount(),
                vendorProduct.getSaveCount()
        );

        vendorProductRepository.save(vendorProductEntity);
    }

    @Override
    public List<GetVendorProductDto> getVendorProduct(String vendorEmail) {

        log.info("판매자 상품 조회");

        List<VendorProductEntity> vendorProductEntityList = vendorProductRepository.findAllByVendorEmail(
                vendorEmail);

        if(vendorProductEntityList.isEmpty()){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        List<GetVendorProductDto> getVendorProductDtoList =
                vendorProductEntityList.stream()
                        .map(vendorProductEntity -> {
                            // 재고, 판매상태, 진열상태 가져오기
                            log.info("상품 상태 가져오기");
                            DisplayStatus displayStatus = displayStatusConverter.convertToEntityAttribute(
                                    vendorProductEntity.getDisplayStatus());
                            SalesStatus salesStatus = salesStatusConverter.convertToEntityAttribute(
                                    vendorProductEntity.getSalesStatus());

                            String displayStatusName = displayStatus.getNameValue();
                            String salesStatusName = salesStatus.getNameValue();


                            // 세부상품코드 가져오기
                            log.info("세부 상품 코드 가져오기");
                            ProductDetailEntity productDetailEntity =
                                    productDetailRepository.findById(vendorProductEntity.getProductDetailId().getId())
                                    .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));


                            //상위 상품 코드, 상품이름, 가격 가져오기
                            log.info("상품 코드, 상품 이름, 가격 가져오기");
                            ProductEntity productEntity =
                                    productRepository.findById(productDetailEntity.getProductId().getId())
                                    .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));


                            //대표 이미지 가져오기
                            log.info("대표 이미지 가져오기");
                            ProductThumbnailsEntity productThumbnailsEntity =
                                    productThumbnailsRepository.findByProductIdAndUsedMainImage(
                                            productEntity, 1);


                            //총 찜 개수 가져오기
                            log.info("총 찜 개수 가져오기");
                            FavoriteProductTotalEntity favoriteProductTotalEntity =
                                    favoriteProductTotalRepository.findByProductId(productEntity);


                            return GetVendorProductDto.fromGetVendorProduct(
                                    productThumbnailsEntity.getThumbnailsImageUrl(),
                                    productEntity.getProductName(),
                                    productEntity.getId(),
                                    productEntity.getProductCode(),
                                    productDetailEntity.getId(),
                                    productDetailEntity.getProductDetailCode(),
                                    vendorProductEntity.getSalesCount(),
                                    productEntity.getProductPrice(),
                                    favoriteProductTotalEntity.getTotalFavorite(),
                                    displayStatusName,
                                    salesStatusName
                            );

                        })
                        .collect(Collectors.toList());
        return getVendorProductDtoList;

    }

    @Override
    public void deleteVendorProduct(VendorProduct vendorProduct) {
        log.info("판매자 상품 삭제");

        ProductDetailEntity productDetailEntity =
                productDetailRepository.findById(vendorProduct.getProductDetailId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));

        VendorProductEntity vendorProductEntity =
                vendorProductRepository.findByVendorEmailAndProductDetailId(
                        vendorProduct.getVendorEmail(),
                        productDetailEntity
                );

        if(vendorProductEntity == null){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        vendorProductEntity.deleteVendorProduct();

        vendorProductRepository.save(vendorProductEntity);
    }

    // 장바구니 재고 조회
    @Override
    public GetSalesCountDto getSalesCount(VendorProduct vendorProduct) {

        ProductDetailEntity productDetailEntity =
                productDetailRepository.findById(vendorProduct.getProductDetailId())
                        .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));

        VendorProductEntity vendorProductEntity =
                vendorProductRepository.findByProductDetailId(productDetailEntity);

        return GetSalesCountDto.fromSalesCount(
                vendorProductEntity.getProductDetailId().getId(),
                vendorProductEntity.getSalesCount(),
                vendorProductEntity.getDisplayStatus()
        );
    }
}
