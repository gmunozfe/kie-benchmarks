/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
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
 */

package org.drools.benchmarks.session;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Date;

@Warmup(iterations = 100)
@Measurement(iterations = 100)
public class EmptyStatefulSessionWithInsertionsAndFireBenchmark extends AbstractSessionBenchmark {

    @Setup(Level.Iteration)
    @Override
    public void setup() {
        createEmptyKieBase();
    }

    @Benchmark
    public void testCreateEmptySession() {
        createStatefulSession();
        statefulSession.insert( "1" );
        statefulSession.insert( new Integer(1) );
        statefulSession.insert( new Long(1L) );
        statefulSession.insert( new Short((short)1) );
        statefulSession.insert( new Double(1.0) );
        statefulSession.insert( new Float(1.0) );
        statefulSession.insert( new Character('1') );
        statefulSession.insert( Boolean.TRUE );
        statefulSession.insert( String.class );
        statefulSession.insert( new Date() );
        statefulSession.fireAllRules();
    }
}
