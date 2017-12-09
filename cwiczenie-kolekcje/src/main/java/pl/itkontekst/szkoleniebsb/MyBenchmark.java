/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package pl.itkontekst.szkoleniebsb;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


@Fork(1)
@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {

    private ArrayList<String> list;
    private LinkedList<String> linkedList;

    private String testElement = "testElement";

    @Param({"100000","1000000"})
    private int size;

    @Setup(Level.Iteration)
    public void setup(){
        list = new ArrayList<>(size);
        linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(testElement);
            linkedList.add(testElement);
        }
    }

    @Benchmark
    public void baseline() {
        Blackhole.consumeCPU(100000);
    }

    @Benchmark
    public void addToEndArrayList() {
        list.add(testElement);
        Blackhole.consumeCPU(100000);
    }
    @Benchmark
    public void addToEndLinkedList() {
        linkedList.add(testElement);
        Blackhole.consumeCPU(100000);
    }

    @Benchmark
    public void addToStartArrayList() {
        list.add(0,testElement);
        Blackhole.consumeCPU(100000);
    }
    @Benchmark
    public void addToStartLinkedList() {
        linkedList.add(0,testElement);
        Blackhole.consumeCPU(100000);
    }

    @Benchmark
    public void addToMiddleArrayList() {
        list.add(size/2,testElement);
        Blackhole.consumeCPU(100000);
    }
    @Benchmark
    public void addToMiddleLinkedList() {
        linkedList.add(size/2,testElement);
        Blackhole.consumeCPU(100000);
    }


}
