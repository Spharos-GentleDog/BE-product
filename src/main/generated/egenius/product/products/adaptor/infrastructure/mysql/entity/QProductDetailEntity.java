package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductDetailEntity is a Querydsl query type for ProductDetailEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductDetailEntity extends EntityPathBase<ProductDetailEntity> {

    private static final long serialVersionUID = 860623853L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductDetailEntity productDetailEntity = new QProductDetailEntity("productDetailEntity");

    public final egenius.product.global.common.QBaseTimeEntity _super = new egenius.product.global.common.QBaseTimeEntity(this);

    public final StringPath color = createString("color");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> discountRate = createNumber("discountRate", Integer.class);

    public final NumberPath<Integer> discountTypes = createNumber("discountTypes", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath productDetailCode = createString("productDetailCode");

    public final QProductEntity productId;

    public final StringPath size = createString("size");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QProductDetailEntity(String variable) {
        this(ProductDetailEntity.class, forVariable(variable), INITS);
    }

    public QProductDetailEntity(Path<? extends ProductDetailEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductDetailEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductDetailEntity(PathMetadata metadata, PathInits inits) {
        this(ProductDetailEntity.class, metadata, inits);
    }

    public QProductDetailEntity(Class<? extends ProductDetailEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

