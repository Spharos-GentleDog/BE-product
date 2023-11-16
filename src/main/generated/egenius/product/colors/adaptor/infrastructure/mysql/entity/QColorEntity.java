package egenius.product.colors.adaptor.infrastructure.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QColorEntity is a Querydsl query type for ColorEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QColorEntity extends EntityPathBase<ColorEntity> {

    private static final long serialVersionUID = 173975868L;

    public static final QColorEntity colorEntity = new QColorEntity("colorEntity");

    public final NumberPath<Integer> colorBlue = createNumber("colorBlue", Integer.class);

    public final StringPath colorCode = createString("colorCode");

    public final NumberPath<Integer> colorGreen = createNumber("colorGreen", Integer.class);

    public final StringPath colorName = createString("colorName");

    public final NumberPath<Integer> colorRed = createNumber("colorRed", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QColorEntity(String variable) {
        super(ColorEntity.class, forVariable(variable));
    }

    public QColorEntity(Path<? extends ColorEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QColorEntity(PathMetadata metadata) {
        super(ColorEntity.class, metadata);
    }

}

