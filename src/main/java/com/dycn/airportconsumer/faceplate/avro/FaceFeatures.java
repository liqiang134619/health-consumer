/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class FaceFeatures extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 884178711415281869L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FaceFeatures\",\"namespace\":\"com.dycn.airportconsumer.faceplate.avro\",\"fields\":[{\"name\":\"faceFeature\",\"type\":[\"null\",\"bytes\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.nio.ByteBuffer faceFeature;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FaceFeatures() {}

  /**
   * All-args constructor.
   * @param faceFeature The new value for faceFeature
   */
  public FaceFeatures(java.nio.ByteBuffer faceFeature) {
    this.faceFeature = faceFeature;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return faceFeature;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: faceFeature = (java.nio.ByteBuffer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'faceFeature' field.
   * @return The value of the 'faceFeature' field.
   */
  public java.nio.ByteBuffer getFaceFeature() {
    return faceFeature;
  }

  /**
   * Sets the value of the 'faceFeature' field.
   * @param value the value to set.
   */
  public void setFaceFeature(java.nio.ByteBuffer value) {
    this.faceFeature = value;
  }

  /**
   * Creates a new FaceFeatures RecordBuilder.
   * @return A new FaceFeatures RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder newBuilder() {
    return new com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder();
  }

  /**
   * Creates a new FaceFeatures RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FaceFeatures RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder other) {
    return new com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder(other);
  }

  /**
   * Creates a new FaceFeatures RecordBuilder by copying an existing FaceFeatures instance.
   * @param other The existing instance to copy.
   * @return A new FaceFeatures RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.FaceFeatures other) {
    return new com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder(other);
  }

  /**
   * RecordBuilder for FaceFeatures instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FaceFeatures>
    implements org.apache.avro.data.RecordBuilder<FaceFeatures> {

    private java.nio.ByteBuffer faceFeature;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.faceFeature)) {
        this.faceFeature = data().deepCopy(fields()[0].schema(), other.faceFeature);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing FaceFeatures instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.FaceFeatures other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.faceFeature)) {
        this.faceFeature = data().deepCopy(fields()[0].schema(), other.faceFeature);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'faceFeature' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getFaceFeature() {
      return faceFeature;
    }

    /**
      * Sets the value of the 'faceFeature' field.
      * @param value The value of 'faceFeature'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder setFaceFeature(java.nio.ByteBuffer value) {
      validate(fields()[0], value);
      this.faceFeature = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'faceFeature' field has been set.
      * @return True if the 'faceFeature' field has been set, false otherwise.
      */
    public boolean hasFaceFeature() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'faceFeature' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.FaceFeatures.Builder clearFaceFeature() {
      faceFeature = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public FaceFeatures build() {
      try {
        FaceFeatures record = new FaceFeatures();
        record.faceFeature = fieldSetFlags()[0] ? this.faceFeature : (java.nio.ByteBuffer) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
