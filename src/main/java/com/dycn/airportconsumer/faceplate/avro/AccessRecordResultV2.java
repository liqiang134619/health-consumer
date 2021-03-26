/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AccessRecordResultV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 907375095204525592L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccessRecordResultV2\",\"namespace\":\"com.dycn.healthairport.faceplate.avro\",\"fields\":[{\"name\":\"checkpoint\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"accessRecord\",\"type\":{\"type\":\"record\",\"name\":\"AccessRecordV2\",\"fields\":[{\"name\":\"devId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"timestamp\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"personId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureIndex\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureMd5\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"similarity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"imagesList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ImageStructV2\",\"fields\":[{\"name\":\"imageType\",\"type\":{\"type\":\"enum\",\"name\":\"ImageTypeV2\",\"symbols\":[\"SCENE_IMAGE\",\"CAPTURED_IMAGE\",\"INFRARED_SCENE_IMAGE\",\"INFRARED_CAPTURED_IMAGE\"]}},{\"name\":\"image\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"featuresList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FaceFeatureStructV2\",\"fields\":[{\"name\":\"featureType\",\"type\":{\"type\":\"enum\",\"name\":\"FeatureTypeV2\",\"symbols\":[\"RGB_FEATURE\",\"INFRARED_FEATURE\"]}},{\"name\":\"faceFeature\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"cardNumber\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"passed\",\"type\":[\"null\",\"boolean\"]},{\"name\":\"password\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"verificationType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"QRCode\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"meta\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"{}\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public String checkpoint;
  @Deprecated public com.dycn.healthairport.faceplate.avro.AccessRecordV2 accessRecord;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccessRecordResultV2() {}

  /**
   * All-args constructor.
   * @param checkpoint The new value for checkpoint
   * @param accessRecord The new value for accessRecord
   */
  public AccessRecordResultV2(String checkpoint, com.dycn.healthairport.faceplate.avro.AccessRecordV2 accessRecord) {
    this.checkpoint = checkpoint;
    this.accessRecord = accessRecord;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return checkpoint;
    case 1: return accessRecord;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: checkpoint = (String)value$; break;
    case 1: accessRecord = (com.dycn.healthairport.faceplate.avro.AccessRecordV2)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'checkpoint' field.
   * @return The value of the 'checkpoint' field.
   */
  public String getCheckpoint() {
    return checkpoint;
  }

  /**
   * Sets the value of the 'checkpoint' field.
   * @param value the value to set.
   */
  public void setCheckpoint(String value) {
    this.checkpoint = value;
  }

  /**
   * Gets the value of the 'accessRecord' field.
   * @return The value of the 'accessRecord' field.
   */
  public com.dycn.healthairport.faceplate.avro.AccessRecordV2 getAccessRecord() {
    return accessRecord;
  }

  /**
   * Sets the value of the 'accessRecord' field.
   * @param value the value to set.
   */
  public void setAccessRecord(com.dycn.healthairport.faceplate.avro.AccessRecordV2 value) {
    this.accessRecord = value;
  }

  /**
   * Creates a new AccessRecordResultV2 RecordBuilder.
   * @return A new AccessRecordResultV2 RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder newBuilder() {
    return new com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder();
  }

  /**
   * Creates a new AccessRecordResultV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccessRecordResultV2 RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder newBuilder(com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder other) {
    return new com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder(other);
  }

  /**
   * Creates a new AccessRecordResultV2 RecordBuilder by copying an existing AccessRecordResultV2 instance.
   * @param other The existing instance to copy.
   * @return A new AccessRecordResultV2 RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder newBuilder(com.dycn.healthairport.faceplate.avro.AccessRecordResultV2 other) {
    return new com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder(other);
  }

  /**
   * RecordBuilder for AccessRecordResultV2 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccessRecordResultV2>
    implements org.apache.avro.data.RecordBuilder<AccessRecordResultV2> {

    private String checkpoint;
    private com.dycn.healthairport.faceplate.avro.AccessRecordV2 accessRecord;
    private com.dycn.healthairport.faceplate.avro.AccessRecordV2.Builder accessRecordBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.checkpoint)) {
        this.checkpoint = data().deepCopy(fields()[0].schema(), other.checkpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accessRecord)) {
        this.accessRecord = data().deepCopy(fields()[1].schema(), other.accessRecord);
        fieldSetFlags()[1] = true;
      }
      if (other.hasAccessRecordBuilder()) {
        this.accessRecordBuilder = com.dycn.healthairport.faceplate.avro.AccessRecordV2.newBuilder(other.getAccessRecordBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing AccessRecordResultV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.AccessRecordResultV2 other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.checkpoint)) {
        this.checkpoint = data().deepCopy(fields()[0].schema(), other.checkpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accessRecord)) {
        this.accessRecord = data().deepCopy(fields()[1].schema(), other.accessRecord);
        fieldSetFlags()[1] = true;
      }
      this.accessRecordBuilder = null;
    }

    /**
      * Gets the value of the 'checkpoint' field.
      * @return The value.
      */
    public String getCheckpoint() {
      return checkpoint;
    }

    /**
      * Sets the value of the 'checkpoint' field.
      * @param value The value of 'checkpoint'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder setCheckpoint(String value) {
      validate(fields()[0], value);
      this.checkpoint = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'checkpoint' field has been set.
      * @return True if the 'checkpoint' field has been set, false otherwise.
      */
    public boolean hasCheckpoint() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'checkpoint' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder clearCheckpoint() {
      checkpoint = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'accessRecord' field.
      * @return The value.
      */
    public com.dycn.healthairport.faceplate.avro.AccessRecordV2 getAccessRecord() {
      return accessRecord;
    }

    /**
      * Sets the value of the 'accessRecord' field.
      * @param value The value of 'accessRecord'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder setAccessRecord(com.dycn.healthairport.faceplate.avro.AccessRecordV2 value) {
      validate(fields()[1], value);
      this.accessRecordBuilder = null;
      this.accessRecord = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accessRecord' field has been set.
      * @return True if the 'accessRecord' field has been set, false otherwise.
      */
    public boolean hasAccessRecord() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'accessRecord' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.dycn.healthairport.faceplate.avro.AccessRecordV2.Builder getAccessRecordBuilder() {
      if (accessRecordBuilder == null) {
        if (hasAccessRecord()) {
          setAccessRecordBuilder(com.dycn.healthairport.faceplate.avro.AccessRecordV2.newBuilder(accessRecord));
        } else {
          setAccessRecordBuilder(com.dycn.healthairport.faceplate.avro.AccessRecordV2.newBuilder());
        }
      }
      return accessRecordBuilder;
    }

    /**
     * Sets the Builder instance for the 'accessRecord' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder setAccessRecordBuilder(com.dycn.healthairport.faceplate.avro.AccessRecordV2.Builder value) {
      clearAccessRecord();
      accessRecordBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'accessRecord' field has an active Builder instance
     * @return True if the 'accessRecord' field has an active Builder instance
     */
    public boolean hasAccessRecordBuilder() {
      return accessRecordBuilder != null;
    }

    /**
      * Clears the value of the 'accessRecord' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.AccessRecordResultV2.Builder clearAccessRecord() {
      accessRecord = null;
      accessRecordBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public AccessRecordResultV2 build() {
      try {
        AccessRecordResultV2 record = new AccessRecordResultV2();
        record.checkpoint = fieldSetFlags()[0] ? this.checkpoint : (String) defaultValue(fields()[0]);
        if (accessRecordBuilder != null) {
          record.accessRecord = this.accessRecordBuilder.build();
        } else {
          record.accessRecord = fieldSetFlags()[1] ? this.accessRecord : (com.dycn.healthairport.faceplate.avro.AccessRecordV2) defaultValue(fields()[1]);
        }
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
