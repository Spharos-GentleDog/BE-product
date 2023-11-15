package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductExplainImageEntity is a Querydsl query type for ProductExplainImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductExplainImageEntity extends EntityPathBase<ProductExplainImageEntity> {

    private static final long serialVersionUID = 1351205184L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductExplainImageEntity productExplainImageEntity = new QProductExplainImageEntity("productExplainImageEntity");

    public final StringPath explainImageUrl = createString("explainImageUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public QProductExplainImageEntity(String variable) {
        this(ProductExplainImageEntity.class, forVariable(variable), INITS);
    }

    public QProductExplainImageEntity(Path<? extends ProductExplainImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductExplainImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductExplainImageEntity(PathMetadata metadata, PathInits inits) {
        this(ProductExplainImageEntity.class, metadata, inits);
    }

    public QProductExplainImageEntity(Class<? extends ProductExplainImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

