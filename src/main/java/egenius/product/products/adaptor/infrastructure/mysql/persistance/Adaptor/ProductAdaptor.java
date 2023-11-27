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
import egenius.product.products.application.ports.in.query.*;
import egenius.product.products.application.ports.out.dto.*;
import egenius.product.products.application.ports.out.port.*;
import egenius.product.products.domain.Products;
import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import egenius.product.sizes.adaptor.infrastructure.mysql.repository.SizesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductAdaptor implements CreateProductPort, FindProductPort, FindProductDetailPort, OrderProductInfoPort,
        ProductDetailPagePort, AiServiceProductDetailPort, ColorSizeProductDetailPort{

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
        // 카테고리 이름으로 카테고리 엔티티 조회
        Optional<ProductCategoryEntity> parentCategoryEntity =
                categoryRepository.findByCategoryName(products.getCategoryName().get(0));

        if(!parentCategoryEntity.isPresent()) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
        }

        if(products.getCategoryName().size() > 1){
            Optional<ProductCategoryEntity> childCategoryEntity =
                    categoryRepository.findByParentCategoryAndCategoryName(parentCategoryEntity.get(),
                            products.getCategoryName().get(1));
            if (childCategoryEntity.isPresent()) {
                productCategoryListRepository.save(ProductCategoryListEntity.createProductCategoryList(
                        childCategoryEntity.get(),
                        productEntity
                ));
            }

        }


        // 카테고리 - 상품 리스트에 row 갱신
        productCategoryListRepository.save(ProductCategoryListEntity.createProductCategoryList(
                parentCategoryEntity.get(),
                productEntity
        ));



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

    //상품조회
    @Override
    public List<FindProductDto> findProduct(FindProductQuery findProductQuery) {

        // 카테고리에 해당하는 상품 불러오기
        log.info("전체 조회:{}",findProductQuery.getCategoryType());
        List<ProductCategoryListEntity> productIds;
        List<ProductEntity> productEntities;
        if(findProductQuery.getCategoryType().equals("all") & findProductQuery.getCategoryId() == null){
            log.info("전체 조회:{}",findProductQuery.getCategoryType());
            List<Long> productIdList =  productCategoryListRepository.findAllProductIds();
            productEntities =
                    productIdList.stream()
                            .map(productId -> productRepository.findById(productId).get())
                            .collect(Collectors.toList());

        }
        else {
            productIds = productCategoryListRepository.findByCategoryId(
                    categoryRepository.findById(findProductQuery.getCategoryId()).get()
            );

            log.info("상품 조회:{}",productIds);
            // 상품 테이블에서 데이터 가져오기 ( 상품 id, 상품이름, 상품가격, 브랜드 이름)
            productEntities =
                    productIds.stream()
                            .map(ProductCategoryListEntity ->  ProductCategoryListEntity.getProductId())
                            .collect(Collectors.toList());

        }

        List<FindProductDto> findProductDtos =
                productEntities.stream()
                .map(ProductEntity -> {

                    // 상품 세부 조회 (상품 세부 코드, 할인률, 할인액)
                    // 할인 중인 상품
                    List<ProductDetailEntity> productDetailEntity;
                    if (findProductQuery.getIsDiscount()) {
                        // 할인 중인 상품이 없으면 null 반환
                        productDetailEntity = productDetailRepository.discsountProductByProductId(ProductEntity.getId());
                        log.info("할인중인 상품 :{}", productDetailEntity);
                        if (productDetailEntity.isEmpty()) {
                            return null;
                        }

                    } else {
                        // 할인 중인 상품이 있으면 null 반환
                        productDetailEntity = productDetailRepository.noDiscsountProductByProductId(ProductEntity.getId());
                        log.info("할인중 상품 :{}", productDetailEntity);
                        if (productDetailEntity.isEmpty()) {
                            return null;
                        }
                    }



                    List<String> sizeNames = new ArrayList<>();
                    List<ColorDto> colorNames = new ArrayList<>();
                    String salesStatus = null;
                    List<DiscountsDto> discountsDtos = null;
                    List<Integer> salesStatusList =
                            productDetailEntity.stream()
                                    .map(ProductDetailEntity -> {
                                        VendorProductEntity vendorProductEntity =
                                                vendorProductRepository.findByProductDetailId(ProductDetailEntity);

                                        if (vendorProductEntity.getSalesStatus() == 2 || vendorProductEntity.getSalesStatus() == 3
                                                || vendorProductEntity.getSalesStatus() == 4)
                                            return 0;
                                        return vendorProductEntity.getSalesStatus();
                                    })
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toList());

                    if (salesStatusList.contains(1)) {
                        salesStatus = "판매중";
                        discountsDtos =
                                productDetailEntity.stream()
                                        .map(ProductDetailEntity -> {

                                            VendorProductEntity vendorProductEntity =
                                                    vendorProductRepository.findByProductDetailId(ProductDetailEntity);

                                            if (vendorProductEntity.getSalesStatus() == 1) {
                                                sizeNames.add(ProductDetailEntity.getSize());
                                                Optional<ColorEntity> colorEntity =
                                                        colorRepository.findByColorName(ProductDetailEntity.getColor());
                                                ColorDto colorDto = ColorDto.formColorDto(
                                                        colorEntity.get().getColorName(),
                                                        colorEntity.get().getColorCode()
                                                );
                                                // 중복 체크 및 추가
                                                if (!colorNames.stream().anyMatch(c -> c.getColorName().equals(colorDto.getColorName()))) {
                                                    colorNames.add(colorDto);
                                                }
                                                return DiscountsDto.formDiscountsDto(
                                                        ProductDetailEntity.getId(),
                                                        ProductDetailEntity.getDiscountRate(),
                                                        ProductDetailEntity.getDiscountTypes());
                                            }
                                            return null;
                                        })
                                        .filter(Objects::nonNull)
                                        .collect(Collectors.toList());

                    }

                    if (salesStatus == null) {
                        return null;
                    }
                    else{

                        log.info("할인정보 :{}", discountsDtos);
                        // 상품 대표이미지 조회 (이미지 이름, 이미지 url)
                        ProductThumbnailsEntity productThumbnailsEntity =
                                productThumbnailsRepository.findByProductIdAndUsedMainImage(ProductEntity, 1);

                        log.info("대표이미지 :{}", productThumbnailsEntity);
                        //찜수 조회 (찜수)
                        FavoriteProductTotalEntity favoriteProductTotalEntity =
                                favoriteProductTotalRepository.findByProductId(ProductEntity);

                        log.info("찜수 :{}", favoriteProductTotalEntity);
//                        // 사이즈 옵션들 조회 (사이즈 옵션들 조회)
//                        List<SizeEntity> sizeEntities =
//                                productSizeListRepository.findByProductId(ProductEntity)
//                                        .stream()
//                                        .map(ProductSizeListEntity -> ProductSizeListEntity.getSizeId())
//                                        .filter(Objects::nonNull)
//                                        .collect(Collectors.toList());
//                        log.info("사이즈 :{}", sizeEntities);
//                        List<String> sizeNames =
//                                sizeEntities.stream()
//                                        .map(SizeEntity -> SizeEntity.getSizeName())
//                                        .filter(Objects::nonNull)
//                                        .collect(Collectors.toList());
//
//                        log.info("사이즈 :{}", sizeNames);
//                        // 색상 옵션들 조회 (색상 옵션들 조회)
//                        List<ColorEntity> colorEntities =
//                                productColorListRepository.findByProductId(ProductEntity)
//                                        .stream()
//                                        .map(ProductColorListEntity -> ProductColorListEntity.getColorId())
//                                        .filter(Objects::nonNull)
//                                        .collect(Collectors.toList());
//
//                        log.info("색상 :{}", colorEntities);
//                        List<String> colorNames =
//                                colorEntities.stream()
//                                        .map(ColorEntity -> ColorEntity.getColorName())
//                                        .filter(Objects::nonNull)
//                                        .collect(Collectors.toList());


                        // 판매여부 조회

                        return FindProductDto.formFindProductDto(
                                ProductEntity.getId(),
                                ProductEntity.getProductName(),
                                ProductEntity.getProductPrice(),
                                productThumbnailsEntity.getThumbnailsImageName(),
                                productThumbnailsEntity.getThumbnailsImageUrl(),
                                ProductEntity.getBrandName(),
                                discountsDtos,
                                favoriteProductTotalEntity.getTotalFavorite(),
                                sizeNames.stream().distinct().collect(Collectors.toList()),
                                colorNames,
                                salesStatus
                        );
                    }

                })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());

//        log.info("상품 조회:{}",productEntities.getBrandName());
        return findProductDtos;
    }

    @Override
    public FindProductDetailDto findProductDetail(FindProductListQuery findProductListQuery) {

        //ProductDetailBrandDto 생성
        AtomicInteger originalTotalPrice = new AtomicInteger(0);
        AtomicInteger discountTotal = new AtomicInteger(0);
        AtomicInteger deliveryFee = new AtomicInteger(0);
        Integer totalPrice;

        List<ProductDetailBrandDto> productDetailBrandDtoList =
                findProductListQuery.getFindProductDetailQueryList().stream()
                        .map(FindProductDetailQuery -> {

                            String brandName = FindProductDetailQuery.getBrandName();
                            AtomicInteger brandTotalPrice = new AtomicInteger(0);
                            AtomicInteger brandTotalDiscount = new AtomicInteger(0);
                            List<ProductDetailDto> productDetailDtoList =
                                    FindProductDetailQuery.getProductDetailIds().stream()
                                    .map(productDetailId -> {

                                        // 상품 세부 데이터 가져오기
                                        Optional<ProductDetailEntity> productDetailEntityOptional =
                                                productDetailRepository.findById(productDetailId);
                                        ProductDetailEntity productDetailEntity = productDetailEntityOptional.get();


                                        // 상품 데이터 가져오기
                                        ProductEntity productEntity = productDetailEntity.getProductId();

                                        // 상품 대표이미지 가져오기
                                        ProductThumbnailsEntity productThumbnailsEntity =
                                                productThumbnailsRepository.findByProductIdAndUsedMainImage(
                                                        productEntity, 1);

                                        // 할인 후 금액 계산하기
                                        Integer discountPrice = 0;
                                        if (productDetailEntity.getDiscountRate() != null) {
                                            if (productDetailEntity.getDiscountTypes() == 1) {
                                                discountPrice = productEntity.getProductPrice() -
                                                        productDetailEntity.getDiscountRate();
                                            } else if (productDetailEntity.getDiscountTypes() == 2) {
                                                discountPrice = productEntity.getProductPrice() -
                                                        (productEntity.getProductPrice() * productDetailEntity.getDiscountRate() / 100);
                                            }
                                        }

                                        brandTotalPrice.addAndGet(productEntity.getProductPrice());
                                        brandTotalDiscount.addAndGet(discountPrice);

                                        // 데이터 전달하기
                                        return ProductDetailDto.formProductDetailDto(
                                                productEntity.getBrandName(),
                                                productEntity.getId(),
                                                productDetailEntity.getId(),
                                                productEntity.getProductName(),
                                                productDetailEntity.getColor(),
                                                productDetailEntity.getSize(),
                                                productDetailEntity.getDiscountRate(),
                                                productEntity.getProductPrice(),
                                                discountPrice,
                                                productThumbnailsEntity.getThumbnailsImageUrl(),
                                                productThumbnailsEntity.getThumbnailsImageName()
                                        );
                                    })
                                    .collect(Collectors.toList());

                            originalTotalPrice.addAndGet(brandTotalPrice.get());
                            discountTotal.addAndGet(brandTotalDiscount.get());
                            if (brandTotalPrice.get() < 50000) {
                                deliveryFee.addAndGet(3000);
                            }
                            return ProductDetailBrandDto.formProductDetailBrandDto(
                                    brandName,
                                    productDetailDtoList
                            );
                        })
                        .collect(Collectors.toList());

        totalPrice = originalTotalPrice.get() - discountTotal.get() + deliveryFee.get();
        Integer originalTotalPriceInt = originalTotalPrice.get();
        Integer discountTotalInt = discountTotal.get();
        Integer deliveryFeeInt = deliveryFee.get();

        return FindProductDetailDto.formFindProductDetailDto(
//                originalTotalPriceInt,
//                deliveryFeeInt,
//                discountTotalInt,
//                totalPrice,
                productDetailBrandDtoList
        );
    }

    @Override
    public OrderProductInfoBrandDto orderProductInfo(OrderProductInfoBrandQuery orderProductInfoBrandQuery) {

        //ProductDetailBrandDto 생성
        AtomicInteger originalTotalPrice = new AtomicInteger(0);
        AtomicInteger discountTotal = new AtomicInteger(0);
        AtomicInteger deliveryFee = new AtomicInteger(0);
        Integer totalPrice;

        List<OrderProductInfoListDto> orderProductInfoListDtos =
                orderProductInfoBrandQuery.getOrderProductInfoListQueries().stream()
                        .map(OrderProductInfoList -> {

                            String brandName = OrderProductInfoList.getBrandName();
                            AtomicInteger brandTotalPrice = new AtomicInteger(0);
                            AtomicInteger brandTotalDiscount = new AtomicInteger(0);

                            List<OrderProductInfoDto> OrderProductInfoDtoList =
                                    OrderProductInfoList.getOrderProductInfoQueries().stream()
                                            .map(OrderProductInfo -> {
                                                // 상품 세부 데이터 가져오기
                                                Optional<ProductDetailEntity> productDetailEntityOptional =
                                                        productDetailRepository.findById(OrderProductInfo.getProductDetailId());
                                                ProductDetailEntity productDetailEntity = productDetailEntityOptional.get();

                                                // 상품 데이터 가져오기
                                                ProductEntity productEntity = productDetailEntity.getProductId();
                                                log.info("상품 데이터 :{}", productEntity.getVendorEmail());

                                                // 상품 대표이미지 가져오기
                                                ProductThumbnailsEntity productThumbnailsEntity =
                                                        productThumbnailsRepository.findByProductIdAndUsedMainImage(
                                                                productEntity, 1);

                                                // 할인 후 금액 계산하기
                                                Integer discountPrice = 0;
                                                if (productDetailEntity.getDiscountRate() != null) {
                                                    if (productDetailEntity.getDiscountTypes() == 1) {
                                                        discountPrice = productEntity.getProductPrice() -
                                                                productDetailEntity.getDiscountRate();
                                                    } else if (productDetailEntity.getDiscountTypes() == 2) {
                                                        discountPrice = productEntity.getProductPrice() -
                                                                (productEntity.getProductPrice() * productDetailEntity.getDiscountRate() / 100);
                                                    }
                                                }

                                                brandTotalPrice.addAndGet(productEntity.getProductPrice()*OrderProductInfo.getCount());
                                                brandTotalDiscount.addAndGet(discountPrice * OrderProductInfo.getCount());

                                                return OrderProductInfoDto.formOrderProductInfoDto(
                                                        productEntity.getBrandName(),
                                                        productEntity.getVendorEmail(),
                                                        productEntity.getId(),
                                                        productDetailEntity.getId(),
                                                        productDetailEntity.getProductDetailCode(),
                                                        productEntity.getProductName(),
                                                        productDetailEntity.getColor(),
                                                        productDetailEntity.getSize(),
                                                        productDetailEntity.getDiscountRate(),
                                                        productEntity.getProductPrice(),
                                                        discountPrice,
                                                        OrderProductInfo.getCount(),
                                                        productThumbnailsEntity.getThumbnailsImageUrl(),
                                                        productThumbnailsEntity.getThumbnailsImageName()
                                                );

                                            })
                                            .collect(Collectors.toList());

                            originalTotalPrice.addAndGet(brandTotalPrice.get());
                            discountTotal.addAndGet(brandTotalDiscount.get());

                            Integer brandDeliveryFee = 0;
                            if (brandTotalPrice.get() < 50000) {
                                brandDeliveryFee = 3000;
                                deliveryFee.addAndGet(3000);
                            }

                            return OrderProductInfoListDto.formOrderProductInfoListDto(
                                    brandName,
                                    OrderProductInfoDtoList.get(0).getVendorEmail(),
                                    brandTotalPrice.get(),
                                    brandDeliveryFee,
                                    OrderProductInfoDtoList
                            );
                        })
                        .collect(Collectors.toList());


        totalPrice = originalTotalPrice.get() - discountTotal.get() + deliveryFee.get();
        Integer originalTotalPriceInt = originalTotalPrice.get();
        Integer discountTotalInt = discountTotal.get();
        Integer deliveryFeeInt = deliveryFee.get();

        return OrderProductInfoBrandDto.formOrderProductInfoBrandDto(
                originalTotalPriceInt,
                deliveryFeeInt,
                discountTotalInt,
                totalPrice,
                orderProductInfoListDtos
        );
    }

    @Override
    public ProductDetailPageDto getProductDetailPage(Long productId) {

        // 상품 데이터 가져오기
        Optional<ProductEntity> productEntityOptional = productRepository.findById(productId);
        ProductEntity productEntity = productEntityOptional.get();

        //상품 썸네일 이미지  가져오기
        List<ProductThumbnailsEntity> productThumbnailsEntities =
                productThumbnailsRepository.findByProductId(productEntity);

        List<ImageInfoDto> tumbnailImageInfos =
                productThumbnailsEntities.stream()
                        .map(ProductThumbnailsEntity -> {
                            return ImageInfoDto.formImageInfoDto(
                                    ProductThumbnailsEntity.getThumbnailsImageName(),
                                    ProductThumbnailsEntity.getThumbnailsImageUrl()
                            );
                        })
                        .collect(Collectors.toList());

        //상품 상세 이미지 가져오기
        List<ProductExplainImageEntity> productExplainImageEntities =
                productExplainImageRepository.findByProductId(productEntity);

        List<ImageInfoDto> explainImageInfos =
                productExplainImageEntities.stream()
                        .map(ProductExplainImageEntity -> {
                            return ImageInfoDto.formImageInfoDto(
                                    ProductExplainImageEntity.getExplainImageName(),
                                    ProductExplainImageEntity.getExplainImageUrl()
                            );
                        })
                        .collect(Collectors.toList());

        //상품 상세 가져오기
        // 판매자 - 상품 에서 판매중인 세부 상품만 가져오기
        List<ProductDetailEntity> productDetailEntities =
                productDetailRepository.findByProductId(productEntity);

        List<ProductDetailEntity> productDetailIds =
                productDetailEntities.stream()
                                .map(ProductDetailEntity -> {
                                    VendorProductEntity vendorProductEntity =
                                            vendorProductRepository.findByProductDetailId(ProductDetailEntity);
                                    if(vendorProductEntity.getSalesStatus() == 1){
                                        log.info("상품 세부 :{}", ProductDetailEntity.getColor());
                                        return ProductDetailEntity;
                                    }
                                    return null;
                                })
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());

        log.info("상품 세부 :{}", productDetailIds);
        List<ProductDetailPageOptionsDto> productDetailPageOptionsDtos =
                productDetailIds.stream()
                        .map(productDetailEntity -> {
                            return ProductDetailPageOptionsDto.formProductDetailPageOptionsDto(
                                    productDetailEntity.getId(),
                                    productDetailEntity.getDiscountRate(),
                                    productDetailEntity.getDiscountTypes(),
                                    productDetailEntity.getSize(),
                                    productDetailEntity.getColor()

                            );
                        })
                        .collect(Collectors.toList());



        // 상품 색상 가져오기
        List<ColorEntity> colorEntities =
                productDetailIds.stream()
                                .map(ProductDetailEntity -> {
                                    ColorEntity colorEntity =
                                            colorRepository.findByColorName(ProductDetailEntity.getColor()).get();
                                    return colorEntity;
                                })
                        .distinct()
                        .collect(Collectors.toList());

        List<ColorDto> colorDtos =
                colorEntities.stream()
                        .map(ColorEntity -> ColorDto.formColorDto(
                                ColorEntity.getColorName(),
                                ColorEntity.getColorCode()
                        ))
                        .collect(Collectors.toList());

        // 상품 사이즈 가져오기
        List<String> sizeNames =
                productDetailIds.stream()
                        .map(ProductDetailEntity -> ProductDetailEntity.getSize())
                        .distinct()
                        .collect(Collectors.toList());

        // 상품 좋아요 수 가져오기
        FavoriteProductTotalEntity favoriteProductTotalEntity =
                favoriteProductTotalRepository.findByProductId(productEntity);




        return ProductDetailPageDto.formProductDetailPageDto(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                tumbnailImageInfos,
                explainImageInfos,
                productEntity.getBrandName(),
                productEntity.getBrandLogoUrl(),
                productDetailPageOptionsDtos,
                colorDtos,
                sizeNames,
                favoriteProductTotalEntity.getTotalFavorite()
        );
    }

    @Override
    public List<AiServiceProductResultDto> formAiServiceProductDetail(AiServiceProductDetailQuery aiServiceProductDetailQuery) {


        List<AiServiceProductResultDto> aiServiceProductResultDtos =
                aiServiceProductDetailQuery.getProductIdList().stream()
                .map(productId -> {

                    // 상품 가져오기
                    Optional<ProductEntity> productEntityOptional = productRepository.findById(productId);

                    ProductEntity productEntity = productEntityOptional.get();


                    // 상품 대표이미지 가져오기
                    ProductThumbnailsEntity productThumbnailsEntity =
                            productThumbnailsRepository.findByProductIdAndUsedMainImage(
                                    productEntity, 1);

                    // 판매중인 상품 색상 사이즈 가져오기
                    List<ProductDetailEntity> productDetailEntityList =
                            productDetailRepository.findByProductId(productEntity);

                    List<String> sizeNames = new ArrayList<>();
                    List<ColorDto> colorNames = new ArrayList<>();

                    List<AiServiceProductDetailsDto> aiServiceProductDetailsDtos =
                    productDetailEntityList.stream().map(
                            ProductDetailEntity -> {
                                VendorProductEntity vendorProductEntity =
                                        vendorProductRepository.findByProductDetailId(ProductDetailEntity);

                                if (vendorProductEntity.getSalesStatus() == 1) {

                                    if(!sizeNames.stream().anyMatch(s -> s.equals(ProductDetailEntity.getSize()))){
                                        sizeNames.add(ProductDetailEntity.getSize());
                                    }
                                    
                                    Optional<ColorEntity> colorEntity =
                                            colorRepository.findByColorName(ProductDetailEntity.getColor());
                                    ColorDto colorDto = ColorDto.formColorDto(
                                            colorEntity.get().getColorName(),
                                            colorEntity.get().getColorCode()
                                    );
                                    // 중복 체크 및 추가
                                    if (!colorNames.stream().anyMatch(c -> c.getColorName().equals(colorDto.getColorName()))) {
                                        colorNames.add(colorDto);
                                    }
                                    return AiServiceProductDetailsDto.formAiServiceProductDetailsDto(
                                            ProductDetailEntity.getId(),
                                            ProductDetailEntity.getColor(),
                                            ProductDetailEntity.getSize(),
                                            ProductDetailEntity.getDiscountRate(),
                                            ProductDetailEntity.getDiscountTypes()
                                    );
                                }
                                return null;
                            })
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                    if(aiServiceProductDetailsDtos.isEmpty()){
                        return null;
                    }

                    return AiServiceProductResultDto.formAiServiceProductDetailDto(
                            productEntity.getId(),
                            productEntity.getProductName(),
                            productEntity.getProductPrice(),
                            aiServiceProductDetailsDtos,
                            productThumbnailsEntity.getThumbnailsImageUrl(),
                            productThumbnailsEntity.getThumbnailsImageName(),
                            colorNames,
                            sizeNames
                    );

                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return aiServiceProductResultDtos;
    }

    @Override
    public ColorSizeProductDetailDto getColorSizeProductDetail(ColorSizeProductDetailQuery colorSizeProductDetailQuery) {

        ProductEntity productEntity = productRepository.findById(colorSizeProductDetailQuery.getProductId()).get();

        ProductDetailEntity productDetailEntity =
                productDetailRepository.findByColorAndSizeAndProductId(
                        colorSizeProductDetailQuery.getColor(),
                        colorSizeProductDetailQuery.getSize(),
                        productEntity
                );

        return ColorSizeProductDetailDto.formColorSizeProductDetailDto(productDetailEntity.getId());
    }
}
