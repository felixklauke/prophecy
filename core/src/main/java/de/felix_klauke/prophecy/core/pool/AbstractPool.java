/*
 * Copyright (c) 2017 Felix Klauke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.felix_klauke.prophecy.core.pool;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Basic adapter for the pool.
 *
 * @author Felix 'SasukeKawaii' Klauke
 */
public abstract class AbstractPool<PooledType> implements Pool<PooledType> {

    /**
     * Underlying map that contains all connections.
     */
    private final Map<PooledType, Boolean> currentPool;

    /**
     * Create a new pool adapter.
     */
    public AbstractPool() {
        this.currentPool = new ConcurrentHashMap<>();
    }

    /**
     * Create an instance of the pooled subject.
     *
     * @return The instance.
     */
    public abstract PooledType create();

    @Override
    public PooledType checkOut() {
        PooledType instance;

        if (currentPool.size() == 0) {
            instance = this.create();
        } else {
            instance = this.currentPool.entrySet().stream()
                    .filter(entry -> !entry.getValue())
                    .map(Entry::getKey)
                    .findFirst()
                    .orElse(null);
        }

        if (instance == null) instance = this.create();

        this.currentPool.put(instance, true);

        return instance;
    }

    @Override
    public void checkIn(PooledType instance) {
        if (!this.currentPool.containsKey(instance)) {
            throw new IllegalArgumentException("The given instance does not belong to the pool.");
        }

        this.currentPool.put(instance, false);
    }

    @Override
    public int getPoolSize() {
        return this.currentPool.size();
    }
}
