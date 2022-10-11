package com.example.spring_blog.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmailTokens is a Querydsl query type for EmailTokens
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmailTokens extends EntityPathBase<EmailTokens> {

    private static final long serialVersionUID = -1439085916L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmailTokens emailTokens = new QEmailTokens("emailTokens");

    public final DateTimePath<java.util.Date> authAt = createDateTime("authAt", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> sendedAt = createDateTime("sendedAt", java.util.Date.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath token = createString("token");

    public final QUser user;

    public QEmailTokens(String variable) {
        this(EmailTokens.class, forVariable(variable), INITS);
    }

    public QEmailTokens(Path<? extends EmailTokens> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmailTokens(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmailTokens(PathMetadata metadata, PathInits inits) {
        this(EmailTokens.class, metadata, inits);
    }

    public QEmailTokens(Class<? extends EmailTokens> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

