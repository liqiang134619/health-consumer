package com.dycn.airportconsumer.faceplate.common;

/**
 * 连接状态类
 */
public enum ConnectionStatus {
    CONNECTED(0),
    DISCONNECTED(1);

    private final int value;

    private ConnectionStatus(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Find a the enum type by its integer value.
     *
     * @return null if the value is not found.
     */
    public static ConnectionStatus findByValue(int value) {
        switch (value) {
            case 0:
                return CONNECTED;
            case 1:
                return DISCONNECTED;
            default:
                return null;
        }
    }
}
