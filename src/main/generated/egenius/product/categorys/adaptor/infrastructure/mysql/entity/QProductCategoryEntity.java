package egenius.product.categorys.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategoryEntity is a Querydsl query type for ProductCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductCategoryEntity extends EntityPathBase<ProductCategoryEntity> {

    private static final long serialVersionUID = 1465500777L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCategoryEntity productCategoryEntity = new QProductCategoryEntity("productCategoryEntity");

    public final egenius.product.global.common.QBaseTimeEntity _super = new egenius.product.global.common.QBaseTimeEntity(this);

    public final StringPath categoryName = createString("categoryName");

    public final ListPath<ProductCategoryEntity, QProductCategoryEntity> childCategory = this.<ProductCategoryEntity, QProductCategoryEntity>createList("childCategory", ProductCategoryEntity.class, QProductCategoryEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QProductCategoryEntity parentCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QProductCategoryEntity(String variable) {
        this(ProductCategoryEntity.class, forVariable(variable), INITS);
    }

    public QProductCategoryEntity(Path<? extends ProductCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(ProductCategoryEntity.class, metadata, inits);
    }

    public QProductCategoryEntity(Class<? extends ProductCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentCategory = inits.isInitialized("parentCategory") ? new QProductCategoryEntity(forProperty("parentCategory"), inits.get("parentCategory")) : null;
    }

}

