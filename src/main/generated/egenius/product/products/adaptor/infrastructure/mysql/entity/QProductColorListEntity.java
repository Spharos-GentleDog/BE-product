package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductColorListEntity is a Querydsl query type for ProductColorListEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductColorListEntity extends EntityPathBase<ProductColorListEntity> {

    private static final long serialVersionUID = 1221461739L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductColorListEntity productColorListEntity = new QProductColorListEntity("productColorListEntity");

    public final egenius.product.colors.adaptor.infrastructure.mysql.entity.QColorEntity colorId;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public QProductColorListEntity(String variable) {
        this(ProductColorListEntity.class, forVariable(variable), INITS);
    }

    public QProductColorListEntity(Path<? extends ProductColorListEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductColorListEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductColorListEntity(PathMetadata metadata, PathInits inits) {
        this(ProductColorListEntity.class, metadata, inits);
    }

    public QProductColorListEntity(Class<? extends ProductColorListEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.colorId = inits.isInitialized("colorId") ? new egenius.product.colors.adaptor.infrastructure.mysql.entity.QColorEntity(forProperty("colorId")) : null;
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

