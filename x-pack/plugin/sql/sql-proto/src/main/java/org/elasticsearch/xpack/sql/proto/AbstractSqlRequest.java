/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.sql.proto;

import org.elasticsearch.common.xcontent.ToXContentFragment;

import java.util.Objects;

/**
 * Base request for all SQL-related requests for JDBC/CLI client
 * <p>
 * Contains information about the client mode that can be used to generate different responses based on the caller type.
 */
public abstract class AbstractSqlRequest implements ToXContentFragment {

    private final Mode mode;

    protected AbstractSqlRequest(Mode mode) {
        this.mode = mode;
    }

    public Mode mode() {
        return mode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSqlRequest that = (AbstractSqlRequest) o;
        return mode == that.mode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode);
    }

}
