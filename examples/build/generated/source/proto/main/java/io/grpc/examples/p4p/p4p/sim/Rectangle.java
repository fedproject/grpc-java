// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: p4p.proto

package io.grpc.examples.p4p.p4p.sim;

/**
 * <pre>
 * A latitude-longitude rectangle, represented as two diagonally opposite
 * points "lo" and "hi".
 * </pre>
 *
 * Protobuf type {@code p4p.p4p.sim.Rectangle}
 */
public final class Rectangle extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:p4p.p4p.sim.Rectangle)
    RectangleOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Rectangle.newBuilder() to construct.
  private Rectangle(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Rectangle() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Rectangle();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Rectangle(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            io.grpc.examples.p4p.p4p.sim.Point.Builder subBuilder = null;
            if (lo_ != null) {
              subBuilder = lo_.toBuilder();
            }
            lo_ = input.readMessage(io.grpc.examples.p4p.p4p.sim.Point.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(lo_);
              lo_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            io.grpc.examples.p4p.p4p.sim.Point.Builder subBuilder = null;
            if (hi_ != null) {
              subBuilder = hi_.toBuilder();
            }
            hi_ = input.readMessage(io.grpc.examples.p4p.p4p.sim.Point.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(hi_);
              hi_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.examples.p4p.p4p.sim.P4PProto.internal_static_p4p_p4p_sim_Rectangle_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.examples.p4p.p4p.sim.P4PProto.internal_static_p4p_p4p_sim_Rectangle_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.examples.p4p.p4p.sim.Rectangle.class, io.grpc.examples.p4p.p4p.sim.Rectangle.Builder.class);
  }

  public static final int LO_FIELD_NUMBER = 1;
  private io.grpc.examples.p4p.p4p.sim.Point lo_;
  /**
   * <pre>
   * One corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point lo = 1;</code>
   * @return Whether the lo field is set.
   */
  @java.lang.Override
  public boolean hasLo() {
    return lo_ != null;
  }
  /**
   * <pre>
   * One corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point lo = 1;</code>
   * @return The lo.
   */
  @java.lang.Override
  public io.grpc.examples.p4p.p4p.sim.Point getLo() {
    return lo_ == null ? io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : lo_;
  }
  /**
   * <pre>
   * One corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point lo = 1;</code>
   */
  @java.lang.Override
  public io.grpc.examples.p4p.p4p.sim.PointOrBuilder getLoOrBuilder() {
    return getLo();
  }

  public static final int HI_FIELD_NUMBER = 2;
  private io.grpc.examples.p4p.p4p.sim.Point hi_;
  /**
   * <pre>
   * The other corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point hi = 2;</code>
   * @return Whether the hi field is set.
   */
  @java.lang.Override
  public boolean hasHi() {
    return hi_ != null;
  }
  /**
   * <pre>
   * The other corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point hi = 2;</code>
   * @return The hi.
   */
  @java.lang.Override
  public io.grpc.examples.p4p.p4p.sim.Point getHi() {
    return hi_ == null ? io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : hi_;
  }
  /**
   * <pre>
   * The other corner of the rectangle.
   * </pre>
   *
   * <code>.p4p.p4p.sim.Point hi = 2;</code>
   */
  @java.lang.Override
  public io.grpc.examples.p4p.p4p.sim.PointOrBuilder getHiOrBuilder() {
    return getHi();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (lo_ != null) {
      output.writeMessage(1, getLo());
    }
    if (hi_ != null) {
      output.writeMessage(2, getHi());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (lo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLo());
    }
    if (hi_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHi());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.examples.p4p.p4p.sim.Rectangle)) {
      return super.equals(obj);
    }
    io.grpc.examples.p4p.p4p.sim.Rectangle other = (io.grpc.examples.p4p.p4p.sim.Rectangle) obj;

    if (hasLo() != other.hasLo()) return false;
    if (hasLo()) {
      if (!getLo()
          .equals(other.getLo())) return false;
    }
    if (hasHi() != other.hasHi()) return false;
    if (hasHi()) {
      if (!getHi()
          .equals(other.getHi())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasLo()) {
      hash = (37 * hash) + LO_FIELD_NUMBER;
      hash = (53 * hash) + getLo().hashCode();
    }
    if (hasHi()) {
      hash = (37 * hash) + HI_FIELD_NUMBER;
      hash = (53 * hash) + getHi().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.p4p.p4p.sim.Rectangle parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.p4p.p4p.sim.Rectangle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * A latitude-longitude rectangle, represented as two diagonally opposite
   * points "lo" and "hi".
   * </pre>
   *
   * Protobuf type {@code p4p.p4p.sim.Rectangle}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:p4p.p4p.sim.Rectangle)
      io.grpc.examples.p4p.p4p.sim.RectangleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.examples.p4p.p4p.sim.P4PProto.internal_static_p4p_p4p_sim_Rectangle_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.examples.p4p.p4p.sim.P4PProto.internal_static_p4p_p4p_sim_Rectangle_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.examples.p4p.p4p.sim.Rectangle.class, io.grpc.examples.p4p.p4p.sim.Rectangle.Builder.class);
    }

    // Construct using io.grpc.examples.p4p.p4p.sim.Rectangle.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (loBuilder_ == null) {
        lo_ = null;
      } else {
        lo_ = null;
        loBuilder_ = null;
      }
      if (hiBuilder_ == null) {
        hi_ = null;
      } else {
        hi_ = null;
        hiBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.examples.p4p.p4p.sim.P4PProto.internal_static_p4p_p4p_sim_Rectangle_descriptor;
    }

    @java.lang.Override
    public io.grpc.examples.p4p.p4p.sim.Rectangle getDefaultInstanceForType() {
      return io.grpc.examples.p4p.p4p.sim.Rectangle.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.examples.p4p.p4p.sim.Rectangle build() {
      io.grpc.examples.p4p.p4p.sim.Rectangle result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.examples.p4p.p4p.sim.Rectangle buildPartial() {
      io.grpc.examples.p4p.p4p.sim.Rectangle result = new io.grpc.examples.p4p.p4p.sim.Rectangle(this);
      if (loBuilder_ == null) {
        result.lo_ = lo_;
      } else {
        result.lo_ = loBuilder_.build();
      }
      if (hiBuilder_ == null) {
        result.hi_ = hi_;
      } else {
        result.hi_ = hiBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.examples.p4p.p4p.sim.Rectangle) {
        return mergeFrom((io.grpc.examples.p4p.p4p.sim.Rectangle)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.examples.p4p.p4p.sim.Rectangle other) {
      if (other == io.grpc.examples.p4p.p4p.sim.Rectangle.getDefaultInstance()) return this;
      if (other.hasLo()) {
        mergeLo(other.getLo());
      }
      if (other.hasHi()) {
        mergeHi(other.getHi());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.examples.p4p.p4p.sim.Rectangle parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.examples.p4p.p4p.sim.Rectangle) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.grpc.examples.p4p.p4p.sim.Point lo_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder> loBuilder_;
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     * @return Whether the lo field is set.
     */
    public boolean hasLo() {
      return loBuilder_ != null || lo_ != null;
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     * @return The lo.
     */
    public io.grpc.examples.p4p.p4p.sim.Point getLo() {
      if (loBuilder_ == null) {
        return lo_ == null ? io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : lo_;
      } else {
        return loBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public Builder setLo(io.grpc.examples.p4p.p4p.sim.Point value) {
      if (loBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        lo_ = value;
        onChanged();
      } else {
        loBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public Builder setLo(
        io.grpc.examples.p4p.p4p.sim.Point.Builder builderForValue) {
      if (loBuilder_ == null) {
        lo_ = builderForValue.build();
        onChanged();
      } else {
        loBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public Builder mergeLo(io.grpc.examples.p4p.p4p.sim.Point value) {
      if (loBuilder_ == null) {
        if (lo_ != null) {
          lo_ =
            io.grpc.examples.p4p.p4p.sim.Point.newBuilder(lo_).mergeFrom(value).buildPartial();
        } else {
          lo_ = value;
        }
        onChanged();
      } else {
        loBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public Builder clearLo() {
      if (loBuilder_ == null) {
        lo_ = null;
        onChanged();
      } else {
        lo_ = null;
        loBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public io.grpc.examples.p4p.p4p.sim.Point.Builder getLoBuilder() {
      
      onChanged();
      return getLoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    public io.grpc.examples.p4p.p4p.sim.PointOrBuilder getLoOrBuilder() {
      if (loBuilder_ != null) {
        return loBuilder_.getMessageOrBuilder();
      } else {
        return lo_ == null ?
            io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : lo_;
      }
    }
    /**
     * <pre>
     * One corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point lo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder> 
        getLoFieldBuilder() {
      if (loBuilder_ == null) {
        loBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder>(
                getLo(),
                getParentForChildren(),
                isClean());
        lo_ = null;
      }
      return loBuilder_;
    }

    private io.grpc.examples.p4p.p4p.sim.Point hi_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder> hiBuilder_;
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     * @return Whether the hi field is set.
     */
    public boolean hasHi() {
      return hiBuilder_ != null || hi_ != null;
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     * @return The hi.
     */
    public io.grpc.examples.p4p.p4p.sim.Point getHi() {
      if (hiBuilder_ == null) {
        return hi_ == null ? io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : hi_;
      } else {
        return hiBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public Builder setHi(io.grpc.examples.p4p.p4p.sim.Point value) {
      if (hiBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hi_ = value;
        onChanged();
      } else {
        hiBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public Builder setHi(
        io.grpc.examples.p4p.p4p.sim.Point.Builder builderForValue) {
      if (hiBuilder_ == null) {
        hi_ = builderForValue.build();
        onChanged();
      } else {
        hiBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public Builder mergeHi(io.grpc.examples.p4p.p4p.sim.Point value) {
      if (hiBuilder_ == null) {
        if (hi_ != null) {
          hi_ =
            io.grpc.examples.p4p.p4p.sim.Point.newBuilder(hi_).mergeFrom(value).buildPartial();
        } else {
          hi_ = value;
        }
        onChanged();
      } else {
        hiBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public Builder clearHi() {
      if (hiBuilder_ == null) {
        hi_ = null;
        onChanged();
      } else {
        hi_ = null;
        hiBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public io.grpc.examples.p4p.p4p.sim.Point.Builder getHiBuilder() {
      
      onChanged();
      return getHiFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    public io.grpc.examples.p4p.p4p.sim.PointOrBuilder getHiOrBuilder() {
      if (hiBuilder_ != null) {
        return hiBuilder_.getMessageOrBuilder();
      } else {
        return hi_ == null ?
            io.grpc.examples.p4p.p4p.sim.Point.getDefaultInstance() : hi_;
      }
    }
    /**
     * <pre>
     * The other corner of the rectangle.
     * </pre>
     *
     * <code>.p4p.p4p.sim.Point hi = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder> 
        getHiFieldBuilder() {
      if (hiBuilder_ == null) {
        hiBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.grpc.examples.p4p.p4p.sim.Point, io.grpc.examples.p4p.p4p.sim.Point.Builder, io.grpc.examples.p4p.p4p.sim.PointOrBuilder>(
                getHi(),
                getParentForChildren(),
                isClean());
        hi_ = null;
      }
      return hiBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:p4p.p4p.sim.Rectangle)
  }

  // @@protoc_insertion_point(class_scope:p4p.p4p.sim.Rectangle)
  private static final io.grpc.examples.p4p.p4p.sim.Rectangle DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.examples.p4p.p4p.sim.Rectangle();
  }

  public static io.grpc.examples.p4p.p4p.sim.Rectangle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Rectangle>
      PARSER = new com.google.protobuf.AbstractParser<Rectangle>() {
    @java.lang.Override
    public Rectangle parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Rectangle(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Rectangle> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Rectangle> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.examples.p4p.p4p.sim.Rectangle getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

