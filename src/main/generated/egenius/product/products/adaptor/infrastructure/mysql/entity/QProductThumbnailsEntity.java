package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductThumbnailsEntity is a Querydsl query type for ProductThumbnailsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductThumbnailsEntity extends EntityPathBase<ProductThumbnailsEntity> {

    private static final long serialVersionUID = 1153766307L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductThumbnailsEntity productThumbnailsEntity = new QProductThumbnailsEntity("productThumbnailsEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public final StringPath ThumbnailsImageName = createString("ThumbnailsImageName");

    public final StringPath ThumbnailsImageUrl = createString("ThumbnailsImageUrl");

    public final NumberPath<Integer> usedMainImage = createNumber("usedMainImage", Integer.class);

    public QProductThumbnailsEntity(String variable) {
        this(ProductThumbnailsEntity.class, forVariable(variable), INITS);
    }

    public QProductThumbnailsEntity(Path<? extends ProductThumbnailsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductThumbnailsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductThumbnailsEntity(PathMetadata metadata, PathInits inits) {
        this(ProductThumbnailsEntity.class, metadata, inits);
    }

    public QProductThumbnailsEntity(Class<? extends ProductThumbnailsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

