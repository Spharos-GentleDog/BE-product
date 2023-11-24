package egenius.product.products.adaptor.infrastructure.mysql.persistance.Adaptor;

import egenius.product.VendorProduct.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.product.VendorProduct.adaptor.infrastructure.mysql.repository.VendorProductRepository;
import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import egenius.product.categorys.adaptor.infrastructure.mysql.repository.CategoryRepository;
import egenius.product.colors.adaptor.infrastructure.mysql.entity.ColorEntity;
import egenius.product.colors.adaptor.infrastructure.mysql.repository.ColorRepository;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import egenius.product.products.adaptor.infrastructure.mysql.entity.*;
import egenius.product.products.adaptor.infrastructure.mysql.repository.*;
import egenius.product.products.application.ports.out.dto.CreateProductDto;
import egenius.product.products.application.ports.out.port.CreateProductPort;
import egenius.product.products.domain.Products;
import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import egenius.product.sizes.adaptor.infrastructure.mysql.repository.SizesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductAdaptor implements CreateProductPort {

    private final ProductRepository productRepository;
    private final FavoriteProductTotalRepository favoriteProductTotalRepository;
    private final ProductThumbnailsRepository productThumbnailsRepository;
    private final ProductExplainImageRepository productExplainImageRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final CategoryRepository categoryRepository;
    private final SizesRepository sizesRepository;
    private final ProductSizeListRepository productSizeListRepository;
    private final ColorRepository colorRepository;
    private final ProductColorListRepository productColorListRepository;
    private final ProductDetailRepository productDetailRepository;
    private final VendorProductRepository vendorProductRepository;


    @Override
    @Transactional
    public void createProduct(Products products) {

        log.info("상품 row 생성");
        // 상품 row 생성
        ProductEntity productEntity = productRepository.save(ProductEntity.createProduct(
                products.getVendorEmail(),
                products.getProductName(),
                products.getProductCode(),
                products.getProductPrice(),
                products.getBrandName(),
                products.getBrandLogoUrl()
        ));

        log.info("총찜 수 row 생성");
        // 총찜 수 row 생성
        favoriteProductTotalRepository.save(
                FavoriteProductTotalEntity.createFavoriteProductTotal(
                products.getTotalFavorite(),
                        productEntity
                ));

        log.info("대표이미지 row 생성");
        //대표이미지 row 생성
        productThumbnailsRepository.save(ProductThumbnailsEntity.createProductThumbnails(
                products.getMainImageUrl().getImageName(),
                products.getMainImageUrl().getImageUrl(),
                1,
                productEntity
        ));

        log.info("썸네일이미지 row 생성");
        //썸네일이미지 row 생성
        for (int i = 0; i < products.getThumbnailsImageUrl().size(); i++) {
            productThumbnailsRepository.save(ProductThumbnailsEntity.createProductThumbnails(
                    products.getThumbnailsImageUrl().get(i).getImageName(),
                    products.getThumbnailsImageUrl().get(i).getImageUrl(),
                    0,
                    productEntity
            ));
        }

        log.info("상세이미지 row 생성");
        //상세이미지 row 생성
        for (int i = 0; i < products.getExplainImageUrl().size(); i++) {
            productExplainImageRepository.save(ProductExplainImageEntity.createProductExplainImage(
                    products.getExplainImageUrl().get(i).getImageName(),
                    products.getExplainImageUrl().get(i).getImageUrl(),
                    productEntity
            ));
        }

        log.info("상품 - 카테고리 row 생성");
        //상품 - 카테고리 row 생성
        for(int i = 0; i < products.getCategoryName().size(); i++) {

            // 카테고리 이름으로 카테고리 엔티티 조회
            Optional<ProductCategoryEntity> productCategoryEntity =
                    categoryRepository.findByCategoryName(products.getCategoryName().get(i));

            if(!productCategoryEntity.isPresent()) {
                throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
            }

            // 카테고리 - 상품 리스트에 row 갱신
            productCategoryListRepository.save(ProductCategoryListEntity.createProductCategoryList(
                    productCategoryEntity.get(),
                    productEntity
            ));

        }

        log.info("상품 -사이즈 row 생성");
        //상품 -사이즈 row 생성
        for(int i = 0; i < products.getSizeName().size() ; i++){
            Optional<SizeEntity> sizeEntity = sizesRepository.findBySizeName(products.getSizeName().get(i));

            if(!sizeEntity.isPresent()){
                throw new BaseException(BaseResponseStatus.SIZE_IS_NOT_FOUND);
            }

            productSizeListRepository.save(ProductSizeListEntity.createProductSizeList(
                    sizeEntity.get(),
                    productEntity
            ));

        }

        log.info("상품 -색상 row 생성");
        //상품 -색상 row 생성
        for (int i = 0; i < products.getColorName().size(); i++) {

            Optional<ColorEntity> colorEntity = colorRepository.findByColorName(products.getColorName().get(i));

            if(!colorEntity.isPresent()){
                throw new BaseException(BaseResponseStatus.COLOR_CODE_ERROR);
            }

            productColorListRepository.save(ProductColorListEntity.createProductColorList(
                    colorEntity.get(),
                    productEntity
            ));

        }

        log.info("상품세부 row 생성");
        //상품세부 row 생성
        List<Long> productDetailIds = new ArrayList<>();
        for(int i = 0 ;  i < products.getColorName().size(); i++){

            for (int j = 0 ; j < products.getSizeName().size(); j++){
                //상품 세부 코드 생성
                String productDetailsCode =
                        products.getProductCode()
                        + (products.getColorName().get(i).length() >= 2 ?
                                products.getColorName().get(i).substring(0,2) :
                                products.getColorName().get(i))

                        + (products.getSizeName().get(j).length() >= 2 ?
                                products.getSizeName().get(j).substring(0,2) :
                                products.getSizeName().get(j));

                ProductDetailEntity productDetailEntity = productDetailRepository.save(ProductDetailEntity.createProductDetail(
                        productDetailsCode,
                        products.getColorName().get(i),
                        products.getSizeName().get(j),
                        productEntity
                ));

                productDetailIds.add(productDetailEntity.getId());

            }
        }

        log.info("판매자 상품리스트 생성");
        //판매자 상품 리스트 생성
        for(int i = 0 ; i < productDetailIds.size(); i++){
            VendorProductEntity vendorProductEntity = VendorProductEntity.createVendorProductEntity(
                    products.getVendorEmail(),
                    productDetailRepository.findById(productDetailIds.get(i)).get(),
                    1,
                    2,
                    0,
                    0
            );

            vendorProductRepository.save(vendorProductEntity);
        }

    }
}
