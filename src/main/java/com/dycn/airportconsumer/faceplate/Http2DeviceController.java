package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.OperationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class Http2DeviceController {
    private static final Logger mLogger = (Logger) LoggerFactory.getLogger(Http2DeviceController.class);
    private HttpConnection mHttpConnection;
    private Http2ClientHandler mHttp2ClientHandler;

    public Http2DeviceController(HttpConnection httpConnection) {
        mHttpConnection = httpConnection;
        mHttp2ClientHandler = mHttpConnection.getInitializer().getHttp2ClientHandler();
    }
//
//    public void remoteRebootSettings(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.remoteRebootsettings(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//            mLogger.error("error: " + e.getMessage());
//        }
//    }
//
//    public void displayImageSettings(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.displayImageSettings(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//            mLogger.error("error: " + e.getMessage());
//        }
//    }
//
    public void updateRepoSettings(String url, String username, String password, int repoSize,
                                   OperationType operationType, File[] fileArray, String cardNo) {
        try {
            mHttp2ClientHandler.updateRepoSettings(url, username, password, repoSize, operationType, fileArray, cardNo);
        } catch (Exception e) {
            e.printStackTrace();
            mLogger.error("error: " + e.getMessage());
        }
    }


    public void updateRepoSettings(String url, String username, String password, int repoSize,
                                   OperationType operationType, InputStream inputStream, String cardNo, String name) {
        try {
            mHttp2ClientHandler.updateRepoSettings(url, username, password, repoSize, operationType, inputStream,name, cardNo);
        } catch (Exception e) {
            e.printStackTrace();
            mLogger.error("error: " + e.getMessage());
        }
    }



    public void updateRepoSettings(String url, String username, String password,
                                   OperationType operationType, List<String> list) {
        try {
            mHttp2ClientHandler.updateRepoSettings(url, username, password,operationType, list);
        } catch (Exception e) {
            e.printStackTrace();
            mLogger.error("error: " + e.getMessage());
        }
    }

//
//
//    public void getRepoSummary(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.getRepoSummary(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void getPersonsDetail(String user, String password) {
//        try {
//            mHttp2ClientHandler.getPersonsDetail(user, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    public String getSinglePerson(String person_id, String user, String password) {
        try {
            return mHttp2ClientHandler.getSinglePerson(person_id, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public void getDeviceInfo(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.getDeviceInfo(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void getOperationRecords(String url, String username, String password, String checkpoint, int limit) {
//        try {
//            mHttp2ClientHandler.getOperationRecords(url, username, password, checkpoint, limit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void backupSettings(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.backupSettings(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void restoreSettings(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.restoreSettings(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void postSettings(String url, String username, String password) {
//        try {
//            mHttp2ClientHandler.postSettings(url, username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void getSettings(String url, String username, String password) {
        try {
            mHttp2ClientHandler.getSettings(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSettings(String url, String username, String password, HttpServletResponse response) {
        try {
            mHttp2ClientHandler.getSettings(url, username, password,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
