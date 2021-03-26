/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5646356420754590956L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"com.dycn.healthairport.faceplate.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"displayInfo\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"displayPic\",\"type\":[\"null\",\"bytes\"]},{\"name\":\"picChecksum\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"faceFeatures\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FaceFeatures\",\"fields\":[{\"name\":\"faceFeature\",\"type\":[\"null\",\"bytes\"]}]}}]},{\"name\":\"featureChecksum\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"otherInfoChecksum\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"cardNo\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"policy\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Policy\",\"fields\":[{\"name\":\"calendar\",\"type\":{\"type\":\"record\",\"name\":\"Calendar\",\"fields\":[{\"name\":\"startDate\",\"type\":\"long\"},{\"name\":\"restingDays\",\"type\":{\"type\":\"array\",\"items\":\"int\"}}]}},{\"name\":\"passTime\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TimeSpan\",\"fields\":[{\"name\":\"startSeconds\",\"type\":\"int\"},{\"name\":\"span\",\"type\":\"int\"}]}}},{\"name\":\"passQuota\",\"type\":\"int\"},{\"name\":\"validTimestamp\",\"type\":\"long\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public String id;
  @Deprecated public String displayInfo;
  @Deprecated public java.nio.ByteBuffer displayPic;
  @Deprecated public String picChecksum;
  @Deprecated public java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> faceFeatures;
  @Deprecated public String featureChecksum;
  @Deprecated public String otherInfoChecksum;
  @Deprecated public String cardNo;
  @Deprecated public java.util.List<com.dycn.healthairport.faceplate.avro.Policy> policy;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Person() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param displayInfo The new value for displayInfo
   * @param displayPic The new value for displayPic
   * @param picChecksum The new value for picChecksum
   * @param faceFeatures The new value for faceFeatures
   * @param featureChecksum The new value for featureChecksum
   * @param otherInfoChecksum The new value for otherInfoChecksum
   * @param cardNo The new value for cardNo
   * @param policy The new value for policy
   */
  public Person(String id, String displayInfo, java.nio.ByteBuffer displayPic, String picChecksum, java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> faceFeatures, String featureChecksum, String otherInfoChecksum, String cardNo, java.util.List<com.dycn.healthairport.faceplate.avro.Policy> policy) {
    this.id = id;
    this.displayInfo = displayInfo;
    this.displayPic = displayPic;
    this.picChecksum = picChecksum;
    this.faceFeatures = faceFeatures;
    this.featureChecksum = featureChecksum;
    this.otherInfoChecksum = otherInfoChecksum;
    this.cardNo = cardNo;
    this.policy = policy;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return displayInfo;
    case 2: return displayPic;
    case 3: return picChecksum;
    case 4: return faceFeatures;
    case 5: return featureChecksum;
    case 6: return otherInfoChecksum;
    case 7: return cardNo;
    case 8: return policy;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: id = (String)value$; break;
    case 1: displayInfo = (String)value$; break;
    case 2: displayPic = (java.nio.ByteBuffer)value$; break;
    case 3: picChecksum = (String)value$; break;
    case 4: faceFeatures = (java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures>)value$; break;
    case 5: featureChecksum = (String)value$; break;
    case 6: otherInfoChecksum = (String)value$; break;
    case 7: cardNo = (String)value$; break;
    case 8: policy = (java.util.List<com.dycn.healthairport.faceplate.avro.Policy>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'displayInfo' field.
   * @return The value of the 'displayInfo' field.
   */
  public String getDisplayInfo() {
    return displayInfo;
  }

  /**
   * Sets the value of the 'displayInfo' field.
   * @param value the value to set.
   */
  public void setDisplayInfo(String value) {
    this.displayInfo = value;
  }

  /**
   * Gets the value of the 'displayPic' field.
   * @return The value of the 'displayPic' field.
   */
  public java.nio.ByteBuffer getDisplayPic() {
    return displayPic;
  }

  /**
   * Sets the value of the 'displayPic' field.
   * @param value the value to set.
   */
  public void setDisplayPic(java.nio.ByteBuffer value) {
    this.displayPic = value;
  }

  /**
   * Gets the value of the 'picChecksum' field.
   * @return The value of the 'picChecksum' field.
   */
  public String getPicChecksum() {
    return picChecksum;
  }

  /**
   * Sets the value of the 'picChecksum' field.
   * @param value the value to set.
   */
  public void setPicChecksum(String value) {
    this.picChecksum = value;
  }

  /**
   * Gets the value of the 'faceFeatures' field.
   * @return The value of the 'faceFeatures' field.
   */
  public java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> getFaceFeatures() {
    return faceFeatures;
  }

  /**
   * Sets the value of the 'faceFeatures' field.
   * @param value the value to set.
   */
  public void setFaceFeatures(java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> value) {
    this.faceFeatures = value;
  }

  /**
   * Gets the value of the 'featureChecksum' field.
   * @return The value of the 'featureChecksum' field.
   */
  public String getFeatureChecksum() {
    return featureChecksum;
  }

  /**
   * Sets the value of the 'featureChecksum' field.
   * @param value the value to set.
   */
  public void setFeatureChecksum(String value) {
    this.featureChecksum = value;
  }

  /**
   * Gets the value of the 'otherInfoChecksum' field.
   * @return The value of the 'otherInfoChecksum' field.
   */
  public String getOtherInfoChecksum() {
    return otherInfoChecksum;
  }

  /**
   * Sets the value of the 'otherInfoChecksum' field.
   * @param value the value to set.
   */
  public void setOtherInfoChecksum(String value) {
    this.otherInfoChecksum = value;
  }

  /**
   * Gets the value of the 'cardNo' field.
   * @return The value of the 'cardNo' field.
   */
  public String getCardNo() {
    return cardNo;
  }

  /**
   * Sets the value of the 'cardNo' field.
   * @param value the value to set.
   */
  public void setCardNo(String value) {
    this.cardNo = value;
  }

  /**
   * Gets the value of the 'policy' field.
   * @return The value of the 'policy' field.
   */
  public java.util.List<com.dycn.healthairport.faceplate.avro.Policy> getPolicy() {
    return policy;
  }

  /**
   * Sets the value of the 'policy' field.
   * @param value the value to set.
   */
  public void setPolicy(java.util.List<com.dycn.healthairport.faceplate.avro.Policy> value) {
    this.policy = value;
  }

  /**
   * Creates a new Person RecordBuilder.
   * @return A new Person RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Person.Builder newBuilder() {
    return new com.dycn.healthairport.faceplate.avro.Person.Builder();
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Person RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Person.Builder newBuilder(com.dycn.healthairport.faceplate.avro.Person.Builder other) {
    return new com.dycn.healthairport.faceplate.avro.Person.Builder(other);
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Person instance.
   * @param other The existing instance to copy.
   * @return A new Person RecordBuilder
   */
  public static com.dycn.healthairport.faceplate.avro.Person.Builder newBuilder(com.dycn.healthairport.faceplate.avro.Person other) {
    return new com.dycn.healthairport.faceplate.avro.Person.Builder(other);
  }

  /**
   * RecordBuilder for Person instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
    implements org.apache.avro.data.RecordBuilder<Person> {

    private String id;
    private String displayInfo;
    private java.nio.ByteBuffer displayPic;
    private String picChecksum;
    private java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> faceFeatures;
    private String featureChecksum;
    private String otherInfoChecksum;
    private String cardNo;
    private java.util.List<com.dycn.healthairport.faceplate.avro.Policy> policy;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.Person.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.displayInfo)) {
        this.displayInfo = data().deepCopy(fields()[1].schema(), other.displayInfo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.displayPic)) {
        this.displayPic = data().deepCopy(fields()[2].schema(), other.displayPic);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.picChecksum)) {
        this.picChecksum = data().deepCopy(fields()[3].schema(), other.picChecksum);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.faceFeatures)) {
        this.faceFeatures = data().deepCopy(fields()[4].schema(), other.faceFeatures);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.featureChecksum)) {
        this.featureChecksum = data().deepCopy(fields()[5].schema(), other.featureChecksum);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.otherInfoChecksum)) {
        this.otherInfoChecksum = data().deepCopy(fields()[6].schema(), other.otherInfoChecksum);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.cardNo)) {
        this.cardNo = data().deepCopy(fields()[7].schema(), other.cardNo);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.policy)) {
        this.policy = data().deepCopy(fields()[8].schema(), other.policy);
        fieldSetFlags()[8] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Person instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.healthairport.faceplate.avro.Person other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.displayInfo)) {
        this.displayInfo = data().deepCopy(fields()[1].schema(), other.displayInfo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.displayPic)) {
        this.displayPic = data().deepCopy(fields()[2].schema(), other.displayPic);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.picChecksum)) {
        this.picChecksum = data().deepCopy(fields()[3].schema(), other.picChecksum);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.faceFeatures)) {
        this.faceFeatures = data().deepCopy(fields()[4].schema(), other.faceFeatures);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.featureChecksum)) {
        this.featureChecksum = data().deepCopy(fields()[5].schema(), other.featureChecksum);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.otherInfoChecksum)) {
        this.otherInfoChecksum = data().deepCopy(fields()[6].schema(), other.otherInfoChecksum);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.cardNo)) {
        this.cardNo = data().deepCopy(fields()[7].schema(), other.cardNo);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.policy)) {
        this.policy = data().deepCopy(fields()[8].schema(), other.policy);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public String getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setId(String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'displayInfo' field.
      * @return The value.
      */
    public String getDisplayInfo() {
      return displayInfo;
    }

    /**
      * Sets the value of the 'displayInfo' field.
      * @param value The value of 'displayInfo'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setDisplayInfo(String value) {
      validate(fields()[1], value);
      this.displayInfo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'displayInfo' field has been set.
      * @return True if the 'displayInfo' field has been set, false otherwise.
      */
    public boolean hasDisplayInfo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'displayInfo' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearDisplayInfo() {
      displayInfo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'displayPic' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getDisplayPic() {
      return displayPic;
    }

    /**
      * Sets the value of the 'displayPic' field.
      * @param value The value of 'displayPic'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setDisplayPic(java.nio.ByteBuffer value) {
      validate(fields()[2], value);
      this.displayPic = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'displayPic' field has been set.
      * @return True if the 'displayPic' field has been set, false otherwise.
      */
    public boolean hasDisplayPic() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'displayPic' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearDisplayPic() {
      displayPic = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'picChecksum' field.
      * @return The value.
      */
    public String getPicChecksum() {
      return picChecksum;
    }

    /**
      * Sets the value of the 'picChecksum' field.
      * @param value The value of 'picChecksum'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setPicChecksum(String value) {
      validate(fields()[3], value);
      this.picChecksum = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'picChecksum' field has been set.
      * @return True if the 'picChecksum' field has been set, false otherwise.
      */
    public boolean hasPicChecksum() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'picChecksum' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearPicChecksum() {
      picChecksum = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'faceFeatures' field.
      * @return The value.
      */
    public java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> getFaceFeatures() {
      return faceFeatures;
    }

    /**
      * Sets the value of the 'faceFeatures' field.
      * @param value The value of 'faceFeatures'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setFaceFeatures(java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures> value) {
      validate(fields()[4], value);
      this.faceFeatures = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'faceFeatures' field has been set.
      * @return True if the 'faceFeatures' field has been set, false otherwise.
      */
    public boolean hasFaceFeatures() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'faceFeatures' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearFaceFeatures() {
      faceFeatures = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'featureChecksum' field.
      * @return The value.
      */
    public String getFeatureChecksum() {
      return featureChecksum;
    }

    /**
      * Sets the value of the 'featureChecksum' field.
      * @param value The value of 'featureChecksum'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setFeatureChecksum(String value) {
      validate(fields()[5], value);
      this.featureChecksum = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'featureChecksum' field has been set.
      * @return True if the 'featureChecksum' field has been set, false otherwise.
      */
    public boolean hasFeatureChecksum() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'featureChecksum' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearFeatureChecksum() {
      featureChecksum = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'otherInfoChecksum' field.
      * @return The value.
      */
    public String getOtherInfoChecksum() {
      return otherInfoChecksum;
    }

    /**
      * Sets the value of the 'otherInfoChecksum' field.
      * @param value The value of 'otherInfoChecksum'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setOtherInfoChecksum(String value) {
      validate(fields()[6], value);
      this.otherInfoChecksum = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'otherInfoChecksum' field has been set.
      * @return True if the 'otherInfoChecksum' field has been set, false otherwise.
      */
    public boolean hasOtherInfoChecksum() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'otherInfoChecksum' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearOtherInfoChecksum() {
      otherInfoChecksum = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'cardNo' field.
      * @return The value.
      */
    public String getCardNo() {
      return cardNo;
    }

    /**
      * Sets the value of the 'cardNo' field.
      * @param value The value of 'cardNo'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setCardNo(String value) {
      validate(fields()[7], value);
      this.cardNo = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'cardNo' field has been set.
      * @return True if the 'cardNo' field has been set, false otherwise.
      */
    public boolean hasCardNo() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'cardNo' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearCardNo() {
      cardNo = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'policy' field.
      * @return The value.
      */
    public java.util.List<com.dycn.healthairport.faceplate.avro.Policy> getPolicy() {
      return policy;
    }

    /**
      * Sets the value of the 'policy' field.
      * @param value The value of 'policy'.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder setPolicy(java.util.List<com.dycn.healthairport.faceplate.avro.Policy> value) {
      validate(fields()[8], value);
      this.policy = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'policy' field has been set.
      * @return True if the 'policy' field has been set, false otherwise.
      */
    public boolean hasPolicy() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'policy' field.
      * @return This builder.
      */
    public com.dycn.healthairport.faceplate.avro.Person.Builder clearPolicy() {
      policy = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public Person build() {
      try {
        Person record = new Person();
        record.id = fieldSetFlags()[0] ? this.id : (String) defaultValue(fields()[0]);
        record.displayInfo = fieldSetFlags()[1] ? this.displayInfo : (String) defaultValue(fields()[1]);
        record.displayPic = fieldSetFlags()[2] ? this.displayPic : (java.nio.ByteBuffer) defaultValue(fields()[2]);
        record.picChecksum = fieldSetFlags()[3] ? this.picChecksum : (String) defaultValue(fields()[3]);
        record.faceFeatures = fieldSetFlags()[4] ? this.faceFeatures : (java.util.List<com.dycn.healthairport.faceplate.avro.FaceFeatures>) defaultValue(fields()[4]);
        record.featureChecksum = fieldSetFlags()[5] ? this.featureChecksum : (String) defaultValue(fields()[5]);
        record.otherInfoChecksum = fieldSetFlags()[6] ? this.otherInfoChecksum : (String) defaultValue(fields()[6]);
        record.cardNo = fieldSetFlags()[7] ? this.cardNo : (String) defaultValue(fields()[7]);
        record.policy = fieldSetFlags()[8] ? this.policy : (java.util.List<com.dycn.healthairport.faceplate.avro.Policy>) defaultValue(fields()[8]);
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