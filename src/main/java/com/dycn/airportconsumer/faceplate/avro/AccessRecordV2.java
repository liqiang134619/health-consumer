/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dycn.airportconsumer.faceplate.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AccessRecordV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5577000180846823304L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccessRecordV2\",\"namespace\":\"com.dycn.airportconsumer.faceplate.avro\",\"fields\":[{\"name\":\"devId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"timestamp\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"personId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureIndex\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"featureMd5\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"similarity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"imagesList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ImageStructV2\",\"fields\":[{\"name\":\"imageType\",\"type\":{\"type\":\"enum\",\"name\":\"ImageTypeV2\",\"symbols\":[\"SCENE_IMAGE\",\"CAPTURED_IMAGE\",\"INFRARED_SCENE_IMAGE\",\"INFRARED_CAPTURED_IMAGE\"]}},{\"name\":\"image\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"featuresList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FaceFeatureStructV2\",\"fields\":[{\"name\":\"featureType\",\"type\":{\"type\":\"enum\",\"name\":\"FeatureTypeV2\",\"symbols\":[\"RGB_FEATURE\",\"INFRARED_FEATURE\"]}},{\"name\":\"faceFeature\",\"type\":[\"null\",\"bytes\"]}]}}},{\"name\":\"cardNumber\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"passed\",\"type\":[\"null\",\"boolean\"]},{\"name\":\"password\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"verificationType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"QRCode\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":\"\"},{\"name\":\"meta\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"{}\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public String devId;
  @Deprecated public String timestamp;
  @Deprecated public String personId;
  @Deprecated public String featureIndex;
  @Deprecated public String featureMd5;
  @Deprecated public String similarity;
  @Deprecated public java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> imagesList;
  @Deprecated public java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> featuresList;
  @Deprecated public String cardNumber;
  @Deprecated public Boolean passed;
  @Deprecated public String password;
  @Deprecated public String verificationType;
  @Deprecated public String QRCode;
  @Deprecated public String meta;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccessRecordV2() {}

  /**
   * All-args constructor.
   * @param devId The new value for devId
   * @param timestamp The new value for timestamp
   * @param personId The new value for personId
   * @param featureIndex The new value for featureIndex
   * @param featureMd5 The new value for featureMd5
   * @param similarity The new value for similarity
   * @param imagesList The new value for imagesList
   * @param featuresList The new value for featuresList
   * @param cardNumber The new value for cardNumber
   * @param passed The new value for passed
   * @param password The new value for password
   * @param verificationType The new value for verificationType
   * @param QRCode The new value for QRCode
   * @param meta The new value for meta
   */
  public AccessRecordV2(String devId, String timestamp, String personId, String featureIndex, String featureMd5, String similarity, java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> imagesList, java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> featuresList, String cardNumber, Boolean passed, String password, String verificationType, String QRCode, String meta) {
    this.devId = devId;
    this.timestamp = timestamp;
    this.personId = personId;
    this.featureIndex = featureIndex;
    this.featureMd5 = featureMd5;
    this.similarity = similarity;
    this.imagesList = imagesList;
    this.featuresList = featuresList;
    this.cardNumber = cardNumber;
    this.passed = passed;
    this.password = password;
    this.verificationType = verificationType;
    this.QRCode = QRCode;
    this.meta = meta;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return devId;
    case 1: return timestamp;
    case 2: return personId;
    case 3: return featureIndex;
    case 4: return featureMd5;
    case 5: return similarity;
    case 6: return imagesList;
    case 7: return featuresList;
    case 8: return cardNumber;
    case 9: return passed;
    case 10: return password;
    case 11: return verificationType;
    case 12: return QRCode;
    case 13: return meta;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: devId = (String)value$; break;
    case 1: timestamp = (String)value$; break;
    case 2: personId = (String)value$; break;
    case 3: featureIndex = (String)value$; break;
    case 4: featureMd5 = (String)value$; break;
    case 5: similarity = (String)value$; break;
    case 6: imagesList = (java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2>)value$; break;
    case 7: featuresList = (java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2>)value$; break;
    case 8: cardNumber = (String)value$; break;
    case 9: passed = (Boolean)value$; break;
    case 10: password = (String)value$; break;
    case 11: verificationType = (String)value$; break;
    case 12: QRCode = (String)value$; break;
    case 13: meta = (String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'devId' field.
   * @return The value of the 'devId' field.
   */
  public String getDevId() {
    return devId;
  }

  /**
   * Sets the value of the 'devId' field.
   * @param value the value to set.
   */
  public void setDevId(String value) {
    this.devId = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(String value) {
    this.timestamp = value;
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
   * Gets the value of the 'featureIndex' field.
   * @return The value of the 'featureIndex' field.
   */
  public String getFeatureIndex() {
    return featureIndex;
  }

  /**
   * Sets the value of the 'featureIndex' field.
   * @param value the value to set.
   */
  public void setFeatureIndex(String value) {
    this.featureIndex = value;
  }

  /**
   * Gets the value of the 'featureMd5' field.
   * @return The value of the 'featureMd5' field.
   */
  public String getFeatureMd5() {
    return featureMd5;
  }

  /**
   * Sets the value of the 'featureMd5' field.
   * @param value the value to set.
   */
  public void setFeatureMd5(String value) {
    this.featureMd5 = value;
  }

  /**
   * Gets the value of the 'similarity' field.
   * @return The value of the 'similarity' field.
   */
  public String getSimilarity() {
    return similarity;
  }

  /**
   * Sets the value of the 'similarity' field.
   * @param value the value to set.
   */
  public void setSimilarity(String value) {
    this.similarity = value;
  }

  /**
   * Gets the value of the 'imagesList' field.
   * @return The value of the 'imagesList' field.
   */
  public java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> getImagesList() {
    return imagesList;
  }

  /**
   * Sets the value of the 'imagesList' field.
   * @param value the value to set.
   */
  public void setImagesList(java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> value) {
    this.imagesList = value;
  }

  /**
   * Gets the value of the 'featuresList' field.
   * @return The value of the 'featuresList' field.
   */
  public java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> getFeaturesList() {
    return featuresList;
  }

  /**
   * Sets the value of the 'featuresList' field.
   * @param value the value to set.
   */
  public void setFeaturesList(java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> value) {
    this.featuresList = value;
  }

  /**
   * Gets the value of the 'cardNumber' field.
   * @return The value of the 'cardNumber' field.
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Sets the value of the 'cardNumber' field.
   * @param value the value to set.
   */
  public void setCardNumber(String value) {
    this.cardNumber = value;
  }

  /**
   * Gets the value of the 'passed' field.
   * @return The value of the 'passed' field.
   */
  public Boolean getPassed() {
    return passed;
  }

  /**
   * Sets the value of the 'passed' field.
   * @param value the value to set.
   */
  public void setPassed(Boolean value) {
    this.passed = value;
  }

  /**
   * Gets the value of the 'password' field.
   * @return The value of the 'password' field.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the value of the 'password' field.
   * @param value the value to set.
   */
  public void setPassword(String value) {
    this.password = value;
  }

  /**
   * Gets the value of the 'verificationType' field.
   * @return The value of the 'verificationType' field.
   */
  public String getVerificationType() {
    return verificationType;
  }

  /**
   * Sets the value of the 'verificationType' field.
   * @param value the value to set.
   */
  public void setVerificationType(String value) {
    this.verificationType = value;
  }

  /**
   * Gets the value of the 'QRCode' field.
   * @return The value of the 'QRCode' field.
   */
  public String getQRCode() {
    return QRCode;
  }

  /**
   * Sets the value of the 'QRCode' field.
   * @param value the value to set.
   */
  public void setQRCode(String value) {
    this.QRCode = value;
  }

  /**
   * Gets the value of the 'meta' field.
   * @return The value of the 'meta' field.
   */
  public String getMeta() {
    return meta;
  }

  /**
   * Sets the value of the 'meta' field.
   * @param value the value to set.
   */
  public void setMeta(String value) {
    this.meta = value;
  }

  /**
   * Creates a new AccessRecordV2 RecordBuilder.
   * @return A new AccessRecordV2 RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder newBuilder() {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder();
  }

  /**
   * Creates a new AccessRecordV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccessRecordV2 RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder other) {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder(other);
  }

  /**
   * Creates a new AccessRecordV2 RecordBuilder by copying an existing AccessRecordV2 instance.
   * @param other The existing instance to copy.
   * @return A new AccessRecordV2 RecordBuilder
   */
  public static com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder newBuilder(com.dycn.airportconsumer.faceplate.avro.AccessRecordV2 other) {
    return new com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder(other);
  }

  /**
   * RecordBuilder for AccessRecordV2 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccessRecordV2>
    implements org.apache.avro.data.RecordBuilder<AccessRecordV2> {

    private String devId;
    private String timestamp;
    private String personId;
    private String featureIndex;
    private String featureMd5;
    private String similarity;
    private java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> imagesList;
    private java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> featuresList;
    private String cardNumber;
    private Boolean passed;
    private String password;
    private String verificationType;
    private String QRCode;
    private String meta;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.devId)) {
        this.devId = data().deepCopy(fields()[0].schema(), other.devId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.personId)) {
        this.personId = data().deepCopy(fields()[2].schema(), other.personId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.featureIndex)) {
        this.featureIndex = data().deepCopy(fields()[3].schema(), other.featureIndex);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.featureMd5)) {
        this.featureMd5 = data().deepCopy(fields()[4].schema(), other.featureMd5);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.similarity)) {
        this.similarity = data().deepCopy(fields()[5].schema(), other.similarity);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.imagesList)) {
        this.imagesList = data().deepCopy(fields()[6].schema(), other.imagesList);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.featuresList)) {
        this.featuresList = data().deepCopy(fields()[7].schema(), other.featuresList);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.cardNumber)) {
        this.cardNumber = data().deepCopy(fields()[8].schema(), other.cardNumber);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.passed)) {
        this.passed = data().deepCopy(fields()[9].schema(), other.passed);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.password)) {
        this.password = data().deepCopy(fields()[10].schema(), other.password);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.verificationType)) {
        this.verificationType = data().deepCopy(fields()[11].schema(), other.verificationType);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.QRCode)) {
        this.QRCode = data().deepCopy(fields()[12].schema(), other.QRCode);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.meta)) {
        this.meta = data().deepCopy(fields()[13].schema(), other.meta);
        fieldSetFlags()[13] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AccessRecordV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dycn.airportconsumer.faceplate.avro.AccessRecordV2 other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.devId)) {
        this.devId = data().deepCopy(fields()[0].schema(), other.devId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.personId)) {
        this.personId = data().deepCopy(fields()[2].schema(), other.personId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.featureIndex)) {
        this.featureIndex = data().deepCopy(fields()[3].schema(), other.featureIndex);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.featureMd5)) {
        this.featureMd5 = data().deepCopy(fields()[4].schema(), other.featureMd5);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.similarity)) {
        this.similarity = data().deepCopy(fields()[5].schema(), other.similarity);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.imagesList)) {
        this.imagesList = data().deepCopy(fields()[6].schema(), other.imagesList);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.featuresList)) {
        this.featuresList = data().deepCopy(fields()[7].schema(), other.featuresList);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.cardNumber)) {
        this.cardNumber = data().deepCopy(fields()[8].schema(), other.cardNumber);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.passed)) {
        this.passed = data().deepCopy(fields()[9].schema(), other.passed);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.password)) {
        this.password = data().deepCopy(fields()[10].schema(), other.password);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.verificationType)) {
        this.verificationType = data().deepCopy(fields()[11].schema(), other.verificationType);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.QRCode)) {
        this.QRCode = data().deepCopy(fields()[12].schema(), other.QRCode);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.meta)) {
        this.meta = data().deepCopy(fields()[13].schema(), other.meta);
        fieldSetFlags()[13] = true;
      }
    }

    /**
      * Gets the value of the 'devId' field.
      * @return The value.
      */
    public String getDevId() {
      return devId;
    }

    /**
      * Sets the value of the 'devId' field.
      * @param value The value of 'devId'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setDevId(String value) {
      validate(fields()[0], value);
      this.devId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'devId' field has been set.
      * @return True if the 'devId' field has been set, false otherwise.
      */
    public boolean hasDevId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'devId' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearDevId() {
      devId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public String getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setTimestamp(String value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearTimestamp() {
      timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
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
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setPersonId(String value) {
      validate(fields()[2], value);
      this.personId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'personId' field has been set.
      * @return True if the 'personId' field has been set, false otherwise.
      */
    public boolean hasPersonId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'personId' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearPersonId() {
      personId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'featureIndex' field.
      * @return The value.
      */
    public String getFeatureIndex() {
      return featureIndex;
    }

    /**
      * Sets the value of the 'featureIndex' field.
      * @param value The value of 'featureIndex'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setFeatureIndex(String value) {
      validate(fields()[3], value);
      this.featureIndex = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'featureIndex' field has been set.
      * @return True if the 'featureIndex' field has been set, false otherwise.
      */
    public boolean hasFeatureIndex() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'featureIndex' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearFeatureIndex() {
      featureIndex = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'featureMd5' field.
      * @return The value.
      */
    public String getFeatureMd5() {
      return featureMd5;
    }

    /**
      * Sets the value of the 'featureMd5' field.
      * @param value The value of 'featureMd5'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setFeatureMd5(String value) {
      validate(fields()[4], value);
      this.featureMd5 = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'featureMd5' field has been set.
      * @return True if the 'featureMd5' field has been set, false otherwise.
      */
    public boolean hasFeatureMd5() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'featureMd5' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearFeatureMd5() {
      featureMd5 = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'similarity' field.
      * @return The value.
      */
    public String getSimilarity() {
      return similarity;
    }

    /**
      * Sets the value of the 'similarity' field.
      * @param value The value of 'similarity'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setSimilarity(String value) {
      validate(fields()[5], value);
      this.similarity = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'similarity' field has been set.
      * @return True if the 'similarity' field has been set, false otherwise.
      */
    public boolean hasSimilarity() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'similarity' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearSimilarity() {
      similarity = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'imagesList' field.
      * @return The value.
      */
    public java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> getImagesList() {
      return imagesList;
    }

    /**
      * Sets the value of the 'imagesList' field.
      * @param value The value of 'imagesList'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setImagesList(java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2> value) {
      validate(fields()[6], value);
      this.imagesList = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'imagesList' field has been set.
      * @return True if the 'imagesList' field has been set, false otherwise.
      */
    public boolean hasImagesList() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'imagesList' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearImagesList() {
      imagesList = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'featuresList' field.
      * @return The value.
      */
    public java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> getFeaturesList() {
      return featuresList;
    }

    /**
      * Sets the value of the 'featuresList' field.
      * @param value The value of 'featuresList'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setFeaturesList(java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2> value) {
      validate(fields()[7], value);
      this.featuresList = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'featuresList' field has been set.
      * @return True if the 'featuresList' field has been set, false otherwise.
      */
    public boolean hasFeaturesList() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'featuresList' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearFeaturesList() {
      featuresList = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'cardNumber' field.
      * @return The value.
      */
    public String getCardNumber() {
      return cardNumber;
    }

    /**
      * Sets the value of the 'cardNumber' field.
      * @param value The value of 'cardNumber'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setCardNumber(String value) {
      validate(fields()[8], value);
      this.cardNumber = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'cardNumber' field has been set.
      * @return True if the 'cardNumber' field has been set, false otherwise.
      */
    public boolean hasCardNumber() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'cardNumber' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearCardNumber() {
      cardNumber = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'passed' field.
      * @return The value.
      */
    public Boolean getPassed() {
      return passed;
    }

    /**
      * Sets the value of the 'passed' field.
      * @param value The value of 'passed'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setPassed(Boolean value) {
      validate(fields()[9], value);
      this.passed = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'passed' field has been set.
      * @return True if the 'passed' field has been set, false otherwise.
      */
    public boolean hasPassed() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'passed' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearPassed() {
      passed = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'password' field.
      * @return The value.
      */
    public String getPassword() {
      return password;
    }

    /**
      * Sets the value of the 'password' field.
      * @param value The value of 'password'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setPassword(String value) {
      validate(fields()[10], value);
      this.password = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'password' field has been set.
      * @return True if the 'password' field has been set, false otherwise.
      */
    public boolean hasPassword() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'password' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearPassword() {
      password = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'verificationType' field.
      * @return The value.
      */
    public String getVerificationType() {
      return verificationType;
    }

    /**
      * Sets the value of the 'verificationType' field.
      * @param value The value of 'verificationType'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setVerificationType(String value) {
      validate(fields()[11], value);
      this.verificationType = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'verificationType' field has been set.
      * @return True if the 'verificationType' field has been set, false otherwise.
      */
    public boolean hasVerificationType() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'verificationType' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearVerificationType() {
      verificationType = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'QRCode' field.
      * @return The value.
      */
    public String getQRCode() {
      return QRCode;
    }

    /**
      * Sets the value of the 'QRCode' field.
      * @param value The value of 'QRCode'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setQRCode(String value) {
      validate(fields()[12], value);
      this.QRCode = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'QRCode' field has been set.
      * @return True if the 'QRCode' field has been set, false otherwise.
      */
    public boolean hasQRCode() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'QRCode' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearQRCode() {
      QRCode = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'meta' field.
      * @return The value.
      */
    public String getMeta() {
      return meta;
    }

    /**
      * Sets the value of the 'meta' field.
      * @param value The value of 'meta'.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder setMeta(String value) {
      validate(fields()[13], value);
      this.meta = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'meta' field has been set.
      * @return True if the 'meta' field has been set, false otherwise.
      */
    public boolean hasMeta() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'meta' field.
      * @return This builder.
      */
    public com.dycn.airportconsumer.faceplate.avro.AccessRecordV2.Builder clearMeta() {
      meta = null;
      fieldSetFlags()[13] = false;
      return this;
    }

    @Override
    public AccessRecordV2 build() {
      try {
        AccessRecordV2 record = new AccessRecordV2();
        record.devId = fieldSetFlags()[0] ? this.devId : (String) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (String) defaultValue(fields()[1]);
        record.personId = fieldSetFlags()[2] ? this.personId : (String) defaultValue(fields()[2]);
        record.featureIndex = fieldSetFlags()[3] ? this.featureIndex : (String) defaultValue(fields()[3]);
        record.featureMd5 = fieldSetFlags()[4] ? this.featureMd5 : (String) defaultValue(fields()[4]);
        record.similarity = fieldSetFlags()[5] ? this.similarity : (String) defaultValue(fields()[5]);
        record.imagesList = fieldSetFlags()[6] ? this.imagesList : (java.util.List<com.dycn.airportconsumer.faceplate.avro.ImageStructV2>) defaultValue(fields()[6]);
        record.featuresList = fieldSetFlags()[7] ? this.featuresList : (java.util.List<com.dycn.airportconsumer.faceplate.avro.FaceFeatureStructV2>) defaultValue(fields()[7]);
        record.cardNumber = fieldSetFlags()[8] ? this.cardNumber : (String) defaultValue(fields()[8]);
        record.passed = fieldSetFlags()[9] ? this.passed : (Boolean) defaultValue(fields()[9]);
        record.password = fieldSetFlags()[10] ? this.password : (String) defaultValue(fields()[10]);
        record.verificationType = fieldSetFlags()[11] ? this.verificationType : (String) defaultValue(fields()[11]);
        record.QRCode = fieldSetFlags()[12] ? this.QRCode : (String) defaultValue(fields()[12]);
        record.meta = fieldSetFlags()[13] ? this.meta : (String) defaultValue(fields()[13]);
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
