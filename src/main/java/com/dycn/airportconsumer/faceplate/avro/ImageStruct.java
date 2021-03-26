/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ImageStruct extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2454825165031314131L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ImageStruct\",\"namespace\":\"com.dycn.healthairport.faceplate.avro\",\"fields\":[{\"name\":\"imageType\",\"type\":{\"type\":\"enum\",\"name\":\"ImageType\",\"symbols\":[\"SCENE_IMAGE\",\"CAPTURED_IMAGE\",\"INFRARED_SCENE_IMAGE\",\"INFRARED_CAPTURED_IMAGE\"]}},{\"name\":\"image\",\"type\":[\"null\",\"bytes\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.dycn.healthairport.faceplate.avro.ImageType imageType;
  @Deprecated public java.nio.ByteBuffer image;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ImageStruct() {}

  /**
   * All-args constructor.
   * @param imageType The new value for imageType
   * @param image The new value for image
   */
  public ImageStruct(com.dycn.healthairport.faceplate.avro.ImageType imageType, java.nio.ByteBuffer image) {
    this.imageType = imageType;
    this.image = image;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return imageType;
    case 1: return image;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: imageType = (com.dycn.healthairport.faceplate.avro.ImageType)value$; break;
    case 1: image = (java.nio.ByteBuffer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'imageType' field.
   * @return The value of the 'imageType' field.
   */
  public com.dycn.healthairport.faceplate.avro.ImageType getImageType() {
    return imageType;
  }

  /**
   * Sets the value of the 'imageType' field.
   * @param value the value to set.
   */
  public void setImageType(com.dycn.healthairport.faceplate.avro.ImageType value) {
    this.imageType = value;
  }

  /**
   * Gets the value of the 'image' field.
   * @return The value of the 'image' field.
   */
  public java.nio.ByteBuffer getImage() {
    return image;
  }

  /**
   * Sets the value of the 'image' field.
   * @param value the value to set.
   */
  public void setImage(java.nio.ByteBuffer value) {
    this.image = value;
  }

  /**
   * Creates a new ImageStruct RecordBuilder.
   * @return A new ImageStruct RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ImageStruct.Builder newBuilder() {
    return new com.dycn.healthairport.faceplate.avro.ImageStruct.Builder();
  }

  /**
   * Creates a new ImageStruct RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ImageStruct RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ImageStruct.Builder newBuilder(com.dycn.healthairport.faceplate.avro.ImageStruct.Builder other) {
    return new com.dycn.healthairport.faceplate.avro.ImageStruct.Builder(other);
  }

  /**
   * Creates a new ImageStruct RecordBuilder by copying an existing ImageStruct instance.
   * @param other The existing instance to copy.
   * @return A new ImageStruct RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.ImageStruct.Builder newBuilder(com.dycn.healthairport.faceplate.avro.ImageStruct other) {
    return new com.dycn.healthairport.faceplate.avro.ImageStruct.Builder(other);
  }

  /**
   * RecordBuilder for ImageStruct instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ImageStruct>
    implements org.apache.avro.data.RecordBuilder<ImageStruct> {

    private com.dycn.healthairport.faceplate.avro.ImageType imageType;
    private java.nio.ByteBuffer image;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.ImageStruct.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.imageType)) {
        this.imageType = data().deepCopy(fields()[0].schema(), other.imageType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.image)) {
        this.image = data().deepCopy(fields()[1].schema(), other.image);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ImageStruct instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.ImageStruct other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.imageType)) {
        this.imageType = data().deepCopy(fields()[0].schema(), other.imageType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.image)) {
        this.image = data().deepCopy(fields()[1].schema(), other.image);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'imageType' field.
      * @return The value.
      */
    public com.dycn.healthairport.faceplate.avro.ImageType getImageType() {
      return imageType;
    }

    /**
      * Sets the value of the 'imageType' field.
      * @param value The value of 'imageType'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ImageStruct.Builder setImageType(com.dycn.healthairport.faceplate.avro.ImageType value) {
      validate(fields()[0], value);
      this.imageType = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'imageType' field has been set.
      * @return True if the 'imageType' field has been set, false otherwise.
      */
    public boolean hasImageType() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'imageType' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ImageStruct.Builder clearImageType() {
      imageType = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'image' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getImage() {
      return image;
    }

    /**
      * Sets the value of the 'image' field.
      * @param value The value of 'image'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ImageStruct.Builder setImage(java.nio.ByteBuffer value) {
      validate(fields()[1], value);
      this.image = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'image' field has been set.
      * @return True if the 'image' field has been set, false otherwise.
      */
    public boolean hasImage() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'image' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.ImageStruct.Builder clearImage() {
      image = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ImageStruct build() {
      try {
        ImageStruct record = new ImageStruct();
        record.imageType = fieldSetFlags()[0] ? this.imageType : (com.dycn.healthairport.faceplate.avro.ImageType) defaultValue(fields()[0]);
        record.image = fieldSetFlags()[1] ? this.image : (java.nio.ByteBuffer) defaultValue(fields()[1]);
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