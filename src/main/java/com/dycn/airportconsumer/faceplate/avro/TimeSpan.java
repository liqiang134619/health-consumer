/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TimeSpan extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6689333652555137590L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TimeSpan\",\"namespace\":\"com.dycn.airportconsumer.faceplate.avro\",\"fields\":[{\"name\":\"startSeconds\",\"type\":\"int\"},{\"name\":\"span\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int startSeconds;
  @Deprecated public int span;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TimeSpan() {}

  /**
   * All-args constructor.
   * @param startSeconds The new value for startSeconds
   * @param span The new value for span
   */
  public TimeSpan(Integer startSeconds, Integer span) {
    this.startSeconds = startSeconds;
    this.span = span;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return startSeconds;
    case 1: return span;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: startSeconds = (Integer)value$; break;
    case 1: span = (Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'startSeconds' field.
   * @return The value of the 'startSeconds' field.
   */
  public Integer getStartSeconds() {
    return startSeconds;
  }

  /**
   * Sets the value of the 'startSeconds' field.
   * @param value the value to set.
   */
  public void setStartSeconds(Integer value) {
    this.startSeconds = value;
  }

  /**
   * Gets the value of the 'span' field.
   * @return The value of the 'span' field.
   */
  public Integer getSpan() {
    return span;
  }

  /**
   * Sets the value of the 'span' field.
   * @param value the value to set.
   */
  public void setSpan(Integer value) {
    this.span = value;
  }

  /**
   * Creates a new TimeSpan RecordBuilder.
   * @return A new TimeSpan RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder newBuilder() {
    return new com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder();
  }

  /**
   * Creates a new TimeSpan RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TimeSpan RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder other) {
    return new com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder(other);
  }

  /**
   * Creates a new TimeSpan RecordBuilder by copying an existing TimeSpan instance.
   * @param other The existing instance to copy.
   * @return A new TimeSpan RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.TimeSpan other) {
    return new com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder(other);
  }

  /**
   * RecordBuilder for TimeSpan instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TimeSpan>
    implements org.apache.avro.data.RecordBuilder<TimeSpan> {

    private int startSeconds;
    private int span;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.startSeconds)) {
        this.startSeconds = data().deepCopy(fields()[0].schema(), other.startSeconds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.span)) {
        this.span = data().deepCopy(fields()[1].schema(), other.span);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TimeSpan instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.TimeSpan other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.startSeconds)) {
        this.startSeconds = data().deepCopy(fields()[0].schema(), other.startSeconds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.span)) {
        this.span = data().deepCopy(fields()[1].schema(), other.span);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'startSeconds' field.
      * @return The value.
      */
    public Integer getStartSeconds() {
      return startSeconds;
    }

    /**
      * Sets the value of the 'startSeconds' field.
      * @param value The value of 'startSeconds'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder setStartSeconds(int value) {
      validate(fields()[0], value);
      this.startSeconds = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'startSeconds' field has been set.
      * @return True if the 'startSeconds' field has been set, false otherwise.
      */
    public boolean hasStartSeconds() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'startSeconds' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder clearStartSeconds() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'span' field.
      * @return The value.
      */
    public Integer getSpan() {
      return span;
    }

    /**
      * Sets the value of the 'span' field.
      * @param value The value of 'span'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder setSpan(int value) {
      validate(fields()[1], value);
      this.span = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'span' field has been set.
      * @return True if the 'span' field has been set, false otherwise.
      */
    public boolean hasSpan() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'span' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.TimeSpan.Builder clearSpan() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public TimeSpan build() {
      try {
        TimeSpan record = new TimeSpan();
        record.startSeconds = fieldSetFlags()[0] ? this.startSeconds : (Integer) defaultValue(fields()[0]);
        record.span = fieldSetFlags()[1] ? this.span : (Integer) defaultValue(fields()[1]);
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
