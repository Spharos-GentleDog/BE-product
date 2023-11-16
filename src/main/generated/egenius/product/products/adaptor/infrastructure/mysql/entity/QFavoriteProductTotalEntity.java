package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavoriteProductTotalEntity is a Querydsl query type for FavoriteProductTotalEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoriteProductTotalEntity extends EntityPathBase<FavoriteProductTotalEntity> {

    private static final long serialVersionUID = 693423498L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavoriteProductTotalEntity favoriteProductTotalEntity = new QFavoriteProductTotalEntity("favoriteProductTotalEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public final NumberPath<Integer> totalFavorite = createNumber("totalFavorite", Integer.class);

    public QFavoriteProductTotalEntity(String variable) {
        this(FavoriteProductTotalEntity.class, forVariable(variable), INITS);
    }

    public QFavoriteProductTotalEntity(Path<? extends FavoriteProductTotalEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavoriteProductTotalEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavoriteProductTotalEntity(PathMetadata metadata, PathInits inits) {
        this(FavoriteProductTotalEntity.class, metadata, inits);
    }

    public QFavoriteProductTotalEntity(Class<? extends FavoriteProductTotalEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

