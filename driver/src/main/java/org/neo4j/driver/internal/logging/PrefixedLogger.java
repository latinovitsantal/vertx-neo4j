/*
 * Copyright (c) 2002-2018 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.driver.internal.logging;

import org.neo4j.driver.v1.Logger;

public class PrefixedLogger extends ReformattedLogger
{
    private final String messagePrefix;

    public PrefixedLogger( Logger delegate )
    {
        this( null, delegate );
    }

    public PrefixedLogger( String messagePrefix, Logger delegate )
    {
        super(delegate);
        this.messagePrefix = messagePrefix;
    }

    @Override
    protected String reformat( String message )
    {
        if ( messagePrefix == null )
        {
            return message;
        }
        return String.format( "%s %s", messagePrefix, message );
    }
}
