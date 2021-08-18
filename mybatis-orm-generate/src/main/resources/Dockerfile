ARG POSTGRESQL_VERSION
FROM postgres:${POSTGRESQL_VERSION}-alpine
ARG POSTGRES_INITDB_ARGS
ENV POSTGRES_INITDB_ARGS="${POSTGRES_INITDB_ARGS}"
RUN apk --no-cache add libintl \
 && apk --no-cache add --virtual .gettext gettext \
 && cp /usr/bin/envsubst /usr/local/bin/envsubst \
 && apk del .gettext

COPY ddl/* /docker-entrypoint-initdb.d/

RUN chmod 755 /docker-entrypoint-initdb.d/init_schema.sh
