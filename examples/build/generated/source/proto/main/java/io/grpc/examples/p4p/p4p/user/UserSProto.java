// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: users.proto

package io.grpc.examples.p4p.p4p.user;

public final class UserSProto {
  private UserSProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_p4p_p4p_user_p4p_UserSRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_p4p_p4p_user_p4p_UserSRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_p4p_p4p_user_p4p_BytesDataSRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_p4p_p4p_user_p4p_BytesDataSRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_p4p_p4p_user_p4p_UserSReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_p4p_p4p_user_p4p_UserSReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013users.proto\022\020p4p.p4p.user.p4p\"\034\n\014UserS" +
      "Request\022\014\n\004name\030\001 \001(\t\"!\n\021BytesDataSReque" +
      "st\022\014\n\004data\030\001 \001(\014\"\035\n\nUserSReply\022\017\n\007messag" +
      "e\030\001 \001(\t2\364\001\n\005UserS\022J\n\010SayHello\022\036.p4p.p4p." +
      "user.p4p.UserSRequest\032\034.p4p.p4p.user.p4p" +
      ".UserSReply\"\000\022N\n\007SayData\022#.p4p.p4p.user." +
      "p4p.BytesDataSRequest\032\034.p4p.p4p.user.p4p" +
      ".UserSReply\"\000\022O\n\rSayHelloAgain\022\036.p4p.p4p" +
      ".user.p4p.UserSRequest\032\034.p4p.p4p.user.p4" +
      "p.UserSReply\"\000B3\n\035io.grpc.examples.p4p.p" +
      "4p.userB\nUserSProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_p4p_p4p_user_p4p_UserSRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_p4p_p4p_user_p4p_UserSRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_p4p_p4p_user_p4p_UserSRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_p4p_p4p_user_p4p_BytesDataSRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_p4p_p4p_user_p4p_BytesDataSRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_p4p_p4p_user_p4p_BytesDataSRequest_descriptor,
        new java.lang.String[] { "Data", });
    internal_static_p4p_p4p_user_p4p_UserSReply_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_p4p_p4p_user_p4p_UserSReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_p4p_p4p_user_p4p_UserSReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
