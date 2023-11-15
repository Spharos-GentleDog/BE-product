package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = 722519804L;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final egenius.product.global.common.QBaseTimeEntity _super = new egenius.product.global.common.QBaseTimeEntity(this);

    public final StringPath brandLogoUrl = createString("brandLogoUrl");

    public final StringPath brandName = createString("brandName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<ProductCategoryListEntity, QProductCategoryListEntity> productCategoryListEntity = this.<ProductCategoryListEntity, QProductCategoryListEntity>createList("productCategoryListEntity", ProductCategoryListEntity.class, QProductCategoryListEntity.class, PathInits.DIRECT2);

    public final StringPath productCode = createString("productCode");

    public final ListPath<ProductColorListEntity, QProductColorListEntity> productColorListEntity = this.<ProductColorListEntity, QProductColorListEntity>createList("productColorListEntity", ProductColorListEntity.class, QProductColorListEntity.class, PathInits.DIRECT2);

    public final ListPath<ProductDetailEntity, QProductDetailEntity> productDetailEntity = this.<ProductDetailEntity, QProductDetailEntity>createList("productDetailEntity", ProductDetailEntity.class, QProductDetailEntity.class, PathInits.DIRECT2);

    public final ListPath<ProductExplainImageEntity, QProductExplainImageEntity> productExplainImageEntity = this.<ProductExplainImageEntity, QProductExplainImageEntity>createList("productExplainImageEntity", ProductExplainImageEntity.class, QProductExplainImageEntity.class, PathInits.DIRECT2);

    public final StringPath productName = createString("productName");

    public final NumberPath<Integer> productPrice = createNumber("productPrice", Integer.class);

    public final ListPath<ProductSizeListEntity, QProductSizeListEntity> productSizeListEntity = this.<ProductSizeListEntity, QProductSizeListEntity>createList("productSizeListEntity", ProductSizeListEntity.class, QProductSizeListEntity.class, PathInits.DIRECT2);

    public final ListPath<ProductThumbnailsEntity, QProductThumbnailsEntity> productThumbnailsEntity = this.<ProductThumbnailsEntity, QProductThumbnailsEntity>createList("productThumbnailsEntity", ProductThumbnailsEntity.class, QProductThumbnailsEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QProductEntity(String variable) {
        super(ProductEntity.class, forVariable(variable));
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductEntity(PathMetadata metadata) {
        super(ProductEntity.class, metadata);
    }

}

