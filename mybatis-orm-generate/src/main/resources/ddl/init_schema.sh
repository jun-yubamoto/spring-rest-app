#!/bin/bash -x
set -e
BASE_DIR=$(cd $(dirname $0);pwd -P)
DDLS=$(find ${BASE_DIR} -type f -name \*.ddl)

for DDL in ${DDLS}
do
    envsubst < ${DDL} | psql -v ON_ERROR_STOP=1 -U ${POSTGRES_USER} -d ${POSTGRES_DB}
done