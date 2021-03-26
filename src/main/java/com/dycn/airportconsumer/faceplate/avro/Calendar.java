/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Calendar extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4258533320134544861L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Calendar\",\"namespace\":\"com.dycn.healthairport.faceplate.avro\",\"fields\":[{\"name\":\"startDate\",\"type\":\"long\"},{\"name\":\"restingDays\",\"type\":{\"type\":\"array\",\"items\":\"int\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long startDate;
  @Deprecated public java.util.List<Integer> restingDays;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Calendar() {}

  /**
   * All-args constructor.
   * @param startDate The new value for startDate
   * @param restingDays The new value for restingDays
   */
  public Calendar(Long startDate, java.util.List<Integer> restingDays) {
    this.startDate = startDate;
    this.restingDays = restingDays;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return startDate;
    case 1: return restingDays;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: startDate = (Long)value$; break;
    case 1: restingDays = (java.util.List<Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'startDate' field.
   * @return The value of the 'startDate' field.
   */
  public Long getStartDate() {
    return startDate;
  }

  /**
   * Sets the value of the 'startDate' field.
   * @param value the value to set.
   */
  public void setStartDate(Long value) {
    this.startDate = value;
  }

  /**
   * Gets the value of the 'restingDays' field.
   * @return The value of the 'restingDays' field.
   */
  public java.util.List<Integer> getRestingDays() {
    return restingDays;
  }

  /**
   * Sets the value of the 'restingDays' field.
   * @param value the value to set.
   */
  public void setRestingDays(java.util.List<Integer> value) {
    this.restingDays = value;
  }

  /**
   * Creates a new Calendar RecordBuilder.
   * @return A new Calendar RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Calendar.Builder newBuilder() {
    return new com.dycn.healthairport.faceplate.avro.Calendar.Builder();
  }

  /**
   * Creates a new Calendar RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Calendar RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Calendar.Builder newBuilder(com.dycn.healthairport.faceplate.avro.Calendar.Builder other) {
    return new com.dycn.healthairport.faceplate.avro.Calendar.Builder(other);
  }

  /**
   * Creates a new Calendar RecordBuilder by copying an existing Calendar instance.
   * @param other The existing instance to copy.
   * @return A new Calendar RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Calendar.Builder newBuilder(com.dycn.healthairport.faceplate.avro.Calendar other) {
    return new com.dycn.healthairport.faceplate.avro.Calendar.Builder(other);
  }

  /**
   * RecordBuilder for Calendar instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Calendar>
    implements org.apache.avro.data.RecordBuilder<Calendar> {

    private long startDate;
    private java.util.List<Integer> restingDays;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.Calendar.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.startDate)) {
        this.startDate = data().deepCopy(fields()[0].schema(), other.startDate);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.restingDays)) {
        this.restingDays = data().deepCopy(fields()[1].schema(), other.restingDays);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Calendar instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.Calendar other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.startDate)) {
        this.startDate = data().deepCopy(fields()[0].schema(), other.startDate);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.restingDays)) {
        this.restingDays = data().deepCopy(fields()[1].schema(), other.restingDays);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'startDate' field.
      * @return The value.
      */
    public Long getStartDate() {
      return startDate;
    }

    /**
      * Sets the value of the 'startDate' field.
      * @param value The value of 'startDate'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Calendar.Builder setStartDate(long value) {
      validate(fields()[0], value);
      this.startDate = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'startDate' field has been set.
      * @return True if the 'startDate' field has been set, false otherwise.
      */
    public boolean hasStartDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'startDate' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Calendar.Builder clearStartDate() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'restingDays' field.
      * @return The value.
      */
    public java.util.List<Integer> getRestingDays() {
      return restingDays;
    }

    /**
      * Sets the value of the 'restingDays' field.
      * @param value The value of 'restingDays'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Calendar.Builder setRestingDays(java.util.List<Integer> value) {
      validate(fields()[1], value);
      this.restingDays = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'restingDays' field has been set.
      * @return True if the 'restingDays' field has been set, false otherwise.
      */
    public boolean hasRestingDays() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'restingDays' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Calendar.Builder clearRestingDays() {
      restingDays = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Calendar build() {
      try {
        Calendar record = new Calendar();
        record.startDate = fieldSetFlags()[0] ? this.startDate : (Long) defaultValue(fields()[0]);
        record.restingDays = fieldSetFlags()[1] ? this.restingDays : (java.util.List<Integer>) defaultValue(fields()[1]);
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
