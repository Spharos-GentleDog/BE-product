package egenius.product.products.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategoryListEntity is a Querydsl query type for ProductCategoryListEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductCategoryListEntity extends EntityPathBase<ProductCategoryListEntity> {

    private static final long serialVersionUID = -1576072360L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCategoryListEntity productCategoryListEntity = new QProductCategoryListEntity("productCategoryListEntity");

    public final egenius.product.categorys.adaptor.infrastructure.mysql.entity.QProductCategoryEntity categoryId;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProductEntity productId;

    public QProductCategoryListEntity(String variable) {
        this(ProductCategoryListEntity.class, forVariable(variable), INITS);
    }

    public QProductCategoryListEntity(Path<? extends ProductCategoryListEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCategoryListEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCategoryListEntity(PathMetadata metadata, PathInits inits) {
        this(ProductCategoryListEntity.class, metadata, inits);
    }

    public QProductCategoryListEntity(Class<? extends ProductCategoryListEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryId = inits.isInitialized("categoryId") ? new egenius.product.categorys.adaptor.infrastructure.mysql.entity.QProductCategoryEntity(forProperty("categoryId"), inits.get("categoryId")) : null;
        this.productId = inits.isInitialized("productId") ? new QProductEntity(forProperty("productId")) : null;
    }

}

