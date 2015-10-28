package mvm.rya.api.persist.query;

/*
 * #%L
 * mvm.rya.rya.api
 * %%
 * Copyright (C) 2014 Rya
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.common.base.Preconditions;
import mvm.rya.api.domain.RyaStatement;

/**
 * Query domain object contains the query to run as a {@link RyaStatement} and options for running the query
 */
public class RyaQuery extends RyaQueryOptions {

    //query
    private RyaStatement query;

    public RyaQuery(RyaStatement query) {
        Preconditions.checkNotNull(query, "RyaStatement query cannot be null");
        this.query = query;
    }

    public static RyaQueryBuilder builder(RyaStatement query) {
        return new RyaQueryBuilder(query);
    }

    public static class RyaQueryBuilder extends RyaOptionsBuilder<RyaQueryBuilder> {
        private RyaQuery ryaQuery;

        public RyaQueryBuilder(RyaStatement query) {
            this(new RyaQuery(query));
        }

        public RyaQueryBuilder(RyaQuery query) {
            super(query);
            this.ryaQuery = query;
        }

        public RyaQuery build() {
            return ryaQuery;
        }
    }

    public RyaStatement getQuery() {
        return query;
    }

    public void setQuery(RyaStatement query) {
        this.query = query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RyaQuery ryaQuery = (RyaQuery) o;

        if (query != null ? !query.equals(ryaQuery.query) : ryaQuery.query != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RyaQuery{" +
                "query=" + query +
                "options={" + super.toString() +
                '}' +
                '}';
    }
}