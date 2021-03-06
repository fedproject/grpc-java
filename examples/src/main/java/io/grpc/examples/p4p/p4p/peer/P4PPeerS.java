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

package io.grpc.examples.p4p.p4p.peer;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import io.grpc.examples.p4p.net.i2p.util.NativeBigInteger;

/**
 * Server that manages startup/shutdown of a {@code P4PPeerS} server.
 */
public class P4PPeerS {
  private static final Logger logger = Logger.getLogger(P4PPeerS.class.getName());

  private Server server;
  public static P4PPeer peer;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 1000;
    server = ServerBuilder.forPort(port)
        .addService(new P4PPeerImpl())
        .build()
        .start();
    
    logger.info("P4PPeerS listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          P4PPeerS.this.stop();
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

    peer = new P4PPeer(m, F, l, zkpIterations, g, h);             
    System.out.println("peer "+args[1]+" instantiated!");
    // peer.setPeerSum(v);

    
    final P4PPeerS server = new P4PPeerS();
    server.start();
    server.blockUntilShutdown();
  }


  static class P4PPeerImpl extends P4PPeerGrpc.P4PPeerImplBase {

    @Override
    public void sayHello(P4PPeerRequest req, StreamObserver<P4PPeerReply> responseObserver) {
      P4PPeerReply reply = P4PPeerReply.newBuilder().setMessage("Hello " + req.getName()).build();
      try {
        // runProcess("javac Main.java");
        // runProcess("/root/grpc-java/examples/build/install/examples/bin/n0-server");
      } catch (Exception e) {
        e.printStackTrace();
      }
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }

   @Override
   public void sayHelloAgain(P4PPeerRequest req, StreamObserver<P4PPeerReply> responseObserver) {
      P4PPeerReply reply = P4PPeerReply.newBuilder().setMessage("Hello again " + req.getName()).build();
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

