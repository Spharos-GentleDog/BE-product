package egenius.product.sizes.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSizeEntity is a Querydsl query type for SizeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSizeEntity extends EntityPathBase<SizeEntity> {

    private static final long serialVersionUID = 1578676046L;

    public static final QSizeEntity sizeEntity = new QSizeEntity("sizeEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath sizeName = createString("sizeName");

    public QSizeEntity(String variable) {
        super(SizeEntity.class, forVariable(variable));
    }

    public QSizeEntity(Path<? extends SizeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSizeEntity(PathMetadata metadata) {
        super(SizeEntity.class, metadata);
    }

}

