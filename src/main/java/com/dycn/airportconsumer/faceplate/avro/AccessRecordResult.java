/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AccessRecordResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2085430181920182101L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccessRecordResult\",\"namespace\":\"com.dycn.airportconsumer.faceplate.avro\",\"fields\":[{\"name\":\"accessRecord\",\"type\":{\"type\":\"record\",\"name\":\"AccessRecord\",\"fields\":[{\"name\":\"devId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"timestamp\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"personId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureIndex\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureMd5\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"similarity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"imagesList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ImageStruct\",\"fields\":[{\"name\":\"imageType\",\"type\":{\"type\":\"enum\",\"name\":\"ImageType\",\"symbols\":[\"SCENE_IMAGE\",\"CAPTURED_IMAGE\",\"INFRARED_SCENE_IMAGE\",\"INFRARED_CAPTURED_IMAGE\"]}},{\"name\":\"image\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"featuresList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FaceFeatureStruct\",\"fields\":[{\"name\":\"featureType\",\"type\":{\"type\":\"enum\",\"name\":\"FeatureType\",\"symbols\":[\"RGB_FEATURE\",\"INFRARED_FEATURE\"]}},{\"name\":\"faceFeature\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"cardNumber\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"passed\",\"type\":[{\"type\":\"record\",\"name\":\"AccessGranted\",\"fields\":[]},{\"type\":\"record\",\"name\":\"AccessDenied\",\"fields\":[]}]}]}},{\"name\":\"checkpoint\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.dycn.airportconsumer.faceplate.avro.AccessRecord accessRecord;
  @Deprecated public String checkpoint;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccessRecordResult() {}

  /**
   * All-args constructor.
   * @param accessRecord The new value for accessRecord
   * @param checkpoint The new value for checkpoint
   */
  public AccessRecordResult(com.dycn.airportconsumer.faceplate.avro.AccessRecord accessRecord, String checkpoint) {
    this.accessRecord = accessRecord;
    this.checkpoint = checkpoint;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return accessRecord;
    case 1: return checkpoint;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: accessRecord = (com.dycn.airportconsumer.faceplate.avro.AccessRecord)value$; break;
    case 1: checkpoint = (String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'accessRecord' field.
   * @return The value of the 'accessRecord' field.
   */
  public com.dycn.airportconsumer.faceplate.avro.AccessRecord getAccessRecord() {
    return accessRecord;
  }

  /**
   * Sets the value of the 'accessRecord' field.
   * @param value the value to set.
   */
  public void setAccessRecord(com.dycn.airportconsumer.faceplate.avro.AccessRecord value) {
    this.accessRecord = value;
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
   * Creates a new AccessRecordResult RecordBuilder.
   * @return A new AccessRecordResult RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder newBuilder() {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder();
  }

  /**
   * Creates a new AccessRecordResult RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccessRecordResult RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder other) {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder(other);
  }

  /**
   * Creates a new AccessRecordResult RecordBuilder by copying an existing AccessRecordResult instance.
   * @param other The existing instance to copy.
   * @return A new AccessRecordResult RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecordResult other) {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder(other);
  }

  /**
   * RecordBuilder for AccessRecordResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccessRecordResult>
    implements org.apache.avro.data.RecordBuilder<AccessRecordResult> {

    private com.dycn.airportconsumer.faceplate.avro.AccessRecord accessRecord;
    private com.dycn.airportconsumer.faceplate.avro.AccessRecord.Builder accessRecordBuilder;
    private String checkpoint;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.accessRecord)) {
        this.accessRecord = data().deepCopy(fields()[0].schema(), other.accessRecord);
        fieldSetFlags()[0] = true;
      }
      if (other.hasAccessRecordBuilder()) {
        this.accessRecordBuilder = com.dycn.airportconsumer.faceplate.avro.AccessRecord.newBuilder(other.getAccessRecordBuilder());
      }
      if (isValidValue(fields()[1], other.checkpoint)) {
        this.checkpoint = data().deepCopy(fields()[1].schema(), other.checkpoint);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AccessRecordResult instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.AccessRecordResult other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.accessRecord)) {
        this.accessRecord = data().deepCopy(fields()[0].schema(), other.accessRecord);
        fieldSetFlags()[0] = true;
      }
      this.accessRecordBuilder = null;
      if (isValidValue(fields()[1], other.checkpoint)) {
        this.checkpoint = data().deepCopy(fields()[1].schema(), other.checkpoint);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'accessRecord' field.
      * @return The value.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecord getAccessRecord() {
      return accessRecord;
    }

    /**
      * Sets the value of the 'accessRecord' field.
      * @param value The value of 'accessRecord'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder setAccessRecord(com.dycn.airportconsumer.faceplate.avro.AccessRecord value) {
      validate(fields()[0], value);
      this.accessRecordBuilder = null;
      this.accessRecord = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'accessRecord' field has been set.
      * @return True if the 'accessRecord' field has been set, false otherwise.
      */
    public boolean hasAccessRecord() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'accessRecord' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecord.Builder getAccessRecordBuilder() {
      if (accessRecordBuilder == null) {
        if (hasAccessRecord()) {
          setAccessRecordBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecord.newBuilder(accessRecord));
        } else {
          setAccessRecordBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecord.newBuilder());
        }
      }
      return accessRecordBuilder;
    }

    /**
     * Sets the Builder instance for the 'accessRecord' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder setAccessRecordBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecord.Builder value) {
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
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder clearAccessRecord() {
      accessRecord = null;
      accessRecordBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
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
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder setCheckpoint(String value) {
      validate(fields()[1], value);
      this.checkpoint = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'checkpoint' field has been set.
      * @return True if the 'checkpoint' field has been set, false otherwise.
      */
    public boolean hasCheckpoint() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'checkpoint' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordResult.Builder clearCheckpoint() {
      checkpoint = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public AccessRecordResult build() {
      try {
        AccessRecordResult record = new AccessRecordResult();
        if (accessRecordBuilder != null) {
          record.accessRecord = this.accessRecordBuilder.build();
        } else {
          record.accessRecord = fieldSetFlags()[0] ? this.accessRecord : (com.dycn.airportconsumer.faceplate.avro.AccessRecord) defaultValue(fields()[0]);
        }
        record.checkpoint = fieldSetFlags()[1] ? this.checkpoint : (String) defaultValue(fields()[1]);
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
