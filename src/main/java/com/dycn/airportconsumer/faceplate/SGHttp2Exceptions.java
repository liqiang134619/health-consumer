package com.dycn.airportconsumer.faceplate;

/**
 * 异常处理类
 */
public class SGHttp2Exceptions {
    /**
     * 网络异常
     */
    public class NetworkException extends Exception {
        public NetworkException() {
            super();
        }

        public NetworkException(String message) {
            super(message);
        }
    }

    /**
     * 操作异常
     */
    public static class OperationException extends Exception {
        public OperationException(String message) {
            super(message);
        }
    }

    /**
     * 设备异常，当前设备重置会有这个异常
     */
    public static class DeviceException extends Exception {
        public DeviceException(String message) {
            super(message);
        }
    }

    /**
     * Method not allowed 405
     */
    public static class MethodNotAllowedException extends Exception {
        public MethodNotAllowedException(String message) {
            super(message);
        }
    }


    /**
     * 用户名密码错误
     */
    public static class PasswordException extends Exception {

        public PasswordException(String message) {
            super(message);
        }
    }

    public static class BadRequestException extends Exception {

        public BadRequestException(String message) {
            super(message);
        }
    }

    public static class DeviceInternalError extends Exception {

        public DeviceInternalError(String message) {
            super(message);
        }
    }

    public static class UnexpectedException extends Exception {

        public UnexpectedException(String message) {
            super(message);
        }
    }

    public static class InvalidChecksumException extends Exception {

    }

    public static class PackageDownloadException extends Exception {

        public PackageDownloadException(String message) {
            super(message);
        }
    }

    public static class PackageNotExistException extends Exception {

        public PackageNotExistException(String message) {
            super(message);
        }
    }

    public static class InvalidPackageException extends Exception {

        public InvalidPackageException(String message) {
            super(message);
        }
    }
}
