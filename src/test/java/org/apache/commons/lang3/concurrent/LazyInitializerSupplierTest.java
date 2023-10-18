/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.concurrent;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.function.FailableSupplier;
import org.junit.jupiter.api.Test;

/**
 * Tests {@code LazyInitializer}.
 */
public class LazyInitializerSupplierTest extends AbstractConcurrentInitializerExceptionsTest {

    /**
     * Creates the initializer to be tested. This implementation returns the {@code LazyInitializer} created in the {@code setUp()} method.
     *
     * @return the initializer to be tested
     */
    @Override
    protected ConcurrentInitializer<Object> createInitializer() {
        return LazyInitializer.<Object>builder().setInitializer(() -> new Object()).get();
    }

    @Override
    protected ConcurrentInitializer<Object> createInitializerThatThrowsException(
            final FailableSupplier<Object, ? extends Exception> supplier) {
        return LazyInitializer.<Object>builder().setInitializer(supplier).get();
    }

    @Override
    protected ConcurrentInitializer<Object> createInitializerThatThrowsPreCreatedException(
            final FailableSupplier<Object, ? extends Exception> supplier) {
        return LazyInitializer.<Object>builder().setInitializer(supplier).get();
    }
}