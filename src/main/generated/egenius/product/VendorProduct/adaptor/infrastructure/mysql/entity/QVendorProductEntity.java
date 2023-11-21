package egenius.product.VendorProduct.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendorProductEntity is a Querydsl query type for VendorProductEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVendorProductEntity extends EntityPathBase<VendorProductEntity> {

    private static final long serialVersionUID = -1560584107L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendorProductEntity vendorProductEntity = new QVendorProductEntity("vendorProductEntity");

    public final NumberPath<Integer> displayStatus = createNumber("displayStatus", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final egenius.product.products.adaptor.infrastructure.mysql.entity.QProductDetailEntity productDetailId;

    public final NumberPath<Integer> salesCount = createNumber("salesCount", Integer.class);

    public final NumberPath<Integer> salesStatus = createNumber("salesStatus", Integer.class);

    public final NumberPath<Integer> saveCount = createNumber("saveCount", Integer.class);

    public final StringPath vendorEmail = createString("vendorEmail");

    public QVendorProductEntity(String variable) {
        this(VendorProductEntity.class, forVariable(variable), INITS);
    }

    public QVendorProductEntity(Path<? extends VendorProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVendorProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVendorProductEntity(PathMetadata metadata, PathInits inits) {
        this(VendorProductEntity.class, metadata, inits);
    }

    public QVendorProductEntity(Class<? extends VendorProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productDetailId = inits.isInitialized("productDetailId") ? new egenius.product.products.adaptor.infrastructure.mysql.entity.QProductDetailEntity(forProperty("productDetailId"), inits.get("productDetailId")) : null;
    }

}

