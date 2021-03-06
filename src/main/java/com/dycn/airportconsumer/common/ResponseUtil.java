package com.dycn.airportconsumer.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liq
 * @date 2021/1/22
 */
@Slf4j
public class ResponseUtil {



    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param status   状态
     */
    public static void renderJson(HttpServletResponse response, Status status) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");

            response.setContentType("application/json;charset=UTF-8");
//            switch (status.getCode()) {
//                case 401: response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    break;
//                case 403: response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                    break;
//                case 500: response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//                    break;
//                default:response.setStatus(HttpServletResponse.SC_OK);
//            }

            response.setStatus(200);

            response.getWriter().write(JSON.toJSONString(ApiResponse.ofStatus(status)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }


}
