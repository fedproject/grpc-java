// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: p4p.proto

package io.grpc.examples.p4p.p4p.sim;

public interface FeatureOrBuilder extends
    // @@protoc_insertion_point(interface_extends:p4p.p4p.sim.Feature)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point location = 2;</code>
   * @return Whether the location field is set.
   */
  boolean hasLocation();
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point location = 2;</code>
   * @return The location.
   */
  io.grpc.examples.p4p.p4p.sim.Point getLocation();
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point location = 2;</code>
   */
  io.grpc.examples.p4p.p4p.sim.PointOrBuilder getLocationOrBuilder();
}
