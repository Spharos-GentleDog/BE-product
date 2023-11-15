package egenius.product.colors.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QColorDetailEntity is a Querydsl query type for ColorDetailEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QColorDetailEntity extends EntityPathBase<ColorDetailEntity> {

    private static final long serialVersionUID = 515327533L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QColorDetailEntity colorDetailEntity = new QColorDetailEntity("colorDetailEntity");

    public final NumberPath<Integer> colorBlue = createNumber("colorBlue", Integer.class);

    public final StringPath colorCode = createString("colorCode");

    public final NumberPath<Integer> colorGreen = createNumber("colorGreen", Integer.class);

    public final QColorEntity colorId;

    public final NumberPath<Integer> colorRed = createNumber("colorRed", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QColorDetailEntity(String variable) {
        this(ColorDetailEntity.class, forVariable(variable), INITS);
    }

    public QColorDetailEntity(Path<? extends ColorDetailEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QColorDetailEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QColorDetailEntity(PathMetadata metadata, PathInits inits) {
        this(ColorDetailEntity.class, metadata, inits);
    }

    public QColorDetailEntity(Class<? extends ColorDetailEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.colorId = inits.isInitialized("colorId") ? new QColorEntity(forProperty("colorId")) : null;
    }

}

