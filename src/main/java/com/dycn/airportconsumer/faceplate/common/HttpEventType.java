package com.dycn.airportconsumer.faceplate.common;

/**
 * 事件类型类
 */
public enum HttpEventType {
    ACCESS_RECORD(1),
    PERSONS(2),
    RECENT_RECORD(3),
    OPEATION_RECORD(4);

    private final int value;

    private HttpEventType(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    public int getValue() {
        return value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     *
     * @return null if the value is not found.
     */
    public static HttpEventType findByValue(int value) {
        switch (value) {
            case 1:
                return ACCESS_RECORD;
            case 2:
                return PERSONS;
            case 3:
                return RECENT_RECORD;
            case 4:
                return OPEATION_RECORD;
            default:
                return null;

        }
    }
}
