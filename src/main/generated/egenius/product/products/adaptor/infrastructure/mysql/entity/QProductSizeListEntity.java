package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductSizeListEntity is a Querydsl query type for ProductSizeListEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductSizeListEntity extends EntityPathBase<ProductSizeListEntity> {

    private static final long serialVersionUID = 925711131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductSizeListEntity productSizeListEntity = new QProductSizeListEntity("productSizeListEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public final egenius.product.sizes.adaptor.infrastructure.mysql.entity.QSizeEntity sizeId;

    public QProductSizeListEntity(String variable) {
        this(ProductSizeListEntity.class, forVariable(variable), INITS);
    }

    public QProductSizeListEntity(Path<? extends ProductSizeListEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductSizeListEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductSizeListEntity(PathMetadata metadata, PathInits inits) {
        this(ProductSizeListEntity.class, metadata, inits);
    }

    public QProductSizeListEntity(Class<? extends ProductSizeListEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
        this.sizeId = inits.isInitialized("sizeId") ? new egenius.product.sizes.adaptor.infrastructure.mysql.entity.QSizeEntity(forProperty("sizeId")) : null;
    }

}

