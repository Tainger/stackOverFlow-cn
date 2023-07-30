package com.knowns.rss.generator.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/8/13 14:15
 */
public class RequestID {

    private static final Logger logger = LoggerFactory.getLogger(RequestID.class);

    public static String getExceptionStackTrace(Throwable anexcepObj) {
        StringWriter sw = null;
        PrintWriter printWriter = null;
        try {
            if(anexcepObj != null) {
                sw = new StringWriter();
                printWriter = new PrintWriter(sw);
                anexcepObj.printStackTrace(printWriter);
                printWriter.flush();
                sw.flush();
                return sw.toString();
            } else {
                return null;
            }
        } finally {
            try {
                if (sw != null) {
                    sw.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                logger.error(String.format("Reason: %s, ExceptionStackTrace: %s", "Failed to ClosIO",
                        e.getMessage()));
            }
        }
    }

    /**
     * 生成uuid
     * @return
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }
}
