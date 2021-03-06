/*
 * Copyright 2015 The gRPC Authors
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

package io.grpc.examples.p4p.p4p.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Map;

import io.grpc.examples.p4p.p4p.peer.P4PPeer;
import io.grpc.examples.p4p.p4p.user.UserVector2;
import io.grpc.examples.p4p.p4p.util.P4PParameters;
import io.grpc.examples.p4p.p4p.util.Util;
import io.grpc.examples.p4p.net.i2p.util.NativeBigInteger;

/**
 * Server that manages startup/shutdown of a {@code P4PServerSS} server.
 */
public class P4PServerSS {
  private static final Logger logger = Logger.getLogger(P4PServerSS.class.getName());
  public static P4PServer serverP = null;

  private Server server;

  private void start() throws IOException { 
    /* The port on which the server should run */
    int port = 9999;
    server = ServerBuilder.forPort(port)
        .addService(new P4PServerSSImpl())
        .build()
        .start();
    logger.info("P4PServerSS listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          P4PServerSS.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void Main_s(String[] args) throws IOException, InterruptedException {
    String[] argStr = args[0].split(",");
    int m = Integer.parseInt(argStr[0]);
    long F = Long.parseLong(argStr[1]);
    int l = Integer.parseInt(argStr[2]);
    int zkpIterations = Integer.parseInt(argStr[3]);
    NativeBigInteger g = new NativeBigInteger(argStr[4]);
    NativeBigInteger h = new NativeBigInteger(argStr[5]);

    serverP = new P4PServer(m,F,l,zkpIterations,g,h);
    System.out.println("serverP N0 instantiated !");

    serverP.init();
    serverP.generateChallengeVectors();
    final P4PServerSS server = new P4PServerSS();
    server.start();
    server.blockUntilShutdown();
  }


  static class P4PServerSSImpl extends P4PServerSSGrpc.P4PServerSSImplBase {

    @Override
    public void sayHello(P4PServerSSRequest req, StreamObserver<P4PServerSSReply> responseObserver) {
      P4PServerSSReply reply = P4PServerSSReply.newBuilder().setMessage("Hello " + req.getName()).build();
      try {
          System.out.println("N0 Java Up");
      } catch (Exception e) {
        e.printStackTrace();
      }
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
   @Override
   public void sayHelloAgain(P4PServerSSRequest req, StreamObserver<P4PServerSSReply> responseObserver) {
      P4PServerSSReply reply = P4PServerSSReply.newBuilder().setMessage("Hello again " + req.getName()).build();
      responseObserver.onNext(reply);
        System.out.println(req);
        System.out.println(reply);
     responseObserver.onCompleted();
   }
  }



  private static void printLines(String name, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(
        new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
        System.out.println(name + " " + line);
    }
  }
  
  private static void runProcess(String command) throws Exception {
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + " stdout:", pro.getInputStream());
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
  }

}


/**
 * Copyright (c) 2007 Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * 3. The name of the University may not be used to endorse or promote products 
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

