/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** 图片下发response */
@org.apache.avro.specific.AvroGenerated
public class ResponseMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6143360546320301629L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ResponseMessage\",\"namespace\":\"com.dycn.healthairport.faceplate.avro\",\"doc\":\"图片下发response\",\"fields\":[{\"name\":\"personId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"rtn\",\"type\":[\"null\",\"int\"]},{\"name\":\"message\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public String personId;
  @Deprecated public Integer rtn;
  @Deprecated public String message;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ResponseMessage() {}

  /**
   * All-args constructor.
   * @param personId The new value for personId
   * @param rtn The new value for rtn
   * @param message The new value for message
   */
  public ResponseMessage(String personId, Integer rtn, String message) {
    this.personId = personId;
    this.rtn = rtn;
    this.message = message;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return personId;
    case 1: return rtn;
    case 2: return message;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: personId = (String)value$; break;
    case 1: rtn = (Integer)value$; break;
    case 2: message = (String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'personId' field.
   * @return The value of the 'personId' field.
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * Sets the value of the 'personId' field.
   * @param value the value to set.
   */
  public void setPersonId(String value) {
    this.personId = value;
  }

  /**
   * Gets the value of the 'rtn' field.
   * @return The value of the 'rtn' field.
   */
  public Integer getRtn() {
    return rtn;
  }

  /**
   * Sets the value of the 'rtn' field.
   * @param value the value to set.
   */
  public void setRtn(Integer value) {
    this.rtn = value;
  }

  /**
   * Gets the value of the 'message' field.
   * @return The value of the 'message' field.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(String value) {
    this.message = value;
  }

  /**
   * Creates a new ResponseMessage RecordBuilder.
   * @return A new ResponseMessage RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder newBuilder() {
    return new com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder();
  }

  /**
   * Creates a new ResponseMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ResponseMessage RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder newBuilder(com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder other) {
    return new com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder(other);
  }

  /**
   * Creates a new ResponseMessage RecordBuilder by copying an existing ResponseMessage instance.
   * @param other The existing instance to copy.
   * @return A new ResponseMessage RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder newBuilder(com.dycn.healthairport.faceplate.avro.ResponseMessage other) {
    return new com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder(other);
  }

  /**
   * RecordBuilder for ResponseMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ResponseMessage>
    implements org.apache.avro.data.RecordBuilder<ResponseMessage> {

    private String personId;
    private Integer rtn;
    private String message;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.personId)) {
        this.personId = data().deepCopy(fields()[0].schema(), other.personId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rtn)) {
        this.rtn = data().deepCopy(fields()[1].schema(), other.rtn);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ResponseMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.ResponseMessage other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.personId)) {
        this.personId = data().deepCopy(fields()[0].schema(), other.personId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rtn)) {
        this.rtn = data().deepCopy(fields()[1].schema(), other.rtn);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'personId' field.
      * @return The value.
      */
    public String getPersonId() {
      return personId;
    }

    /**
      * Sets the value of the 'personId' field.
      * @param value The value of 'personId'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder setPersonId(String value) {
      validate(fields()[0], value);
      this.personId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'personId' field has been set.
      * @return True if the 'personId' field has been set, false otherwise.
      */
    public boolean hasPersonId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'personId' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder clearPersonId() {
      personId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'rtn' field.
      * @return The value.
      */
    public Integer getRtn() {
      return rtn;
    }

    /**
      * Sets the value of the 'rtn' field.
      * @param value The value of 'rtn'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder setRtn(Integer value) {
      validate(fields()[1], value);
      this.rtn = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'rtn' field has been set.
      * @return True if the 'rtn' field has been set, false otherwise.
      */
    public boolean hasRtn() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'rtn' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder clearRtn() {
      rtn = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'message' field.
      * @return The value.
      */
    public String getMessage() {
      return message;
    }

    /**
      * Sets the value of the 'message' field.
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder setMessage(String value) {
      validate(fields()[2], value);
      this.message = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ResponseMessage.Builder clearMessage() {
      message = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public ResponseMessage build() {
      try {
        ResponseMessage record = new ResponseMessage();
        record.personId = fieldSetFlags()[0] ? this.personId : (String) defaultValue(fields()[0]);
        record.rtn = fieldSetFlags()[1] ? this.rtn : (Integer) defaultValue(fields()[1]);
        record.message = fieldSetFlags()[2] ? this.message : (String) defaultValue(fields()[2]);
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
