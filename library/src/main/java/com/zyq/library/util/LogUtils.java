package com.zyq.library.util;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author: zhu yun qi
 * @mail: zhuyunqi_88@163.com
 * @date: 2018/3/14
 * @describe:
 */
public class LogUtils {
    private static final int JSON_INDENT = 4;
    private static String preTag = "";
    private static boolean isDebug = true;
    private static String className;
    private static String methodName;
    private static int lineNumber;

    private LogUtils() {
    }

    public static void setPreTag(String preTag) {
        LogUtils.preTag = preTag;
    }

    private static boolean isDebug() {
        return isDebug;
    }

    public static void setEnable(boolean enable) {
        isDebug = enable;
    }

    public static void e(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.e(formatTag(), createLog(message));
    }

    public static void i(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.i(formatTag(), createLog(message));
    }

    private static String formatTag() {
        if (preTag == null || preTag.trim().isEmpty()) {
            return className;
        }
        return preTag + ":" + className;
    }

    public static void d(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.d(formatTag(), createLog(message));
    }

    public static void v(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.v(formatTag(), createLog(message));
    }

    public static void w(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.w(formatTag(), createLog(message));
    }

    public static void wtf(Object... message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(formatTag(), createLog(message));
    }


    private static String createLog(Object... msg) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(methodName);
        sb.append(":");
        sb.append(lineNumber);
        sb.append("]");

        for (Object string : msg) {
            if (string instanceof Throwable) {
                sb.append('\n');
                String stackTraceString = Log.getStackTraceString((Throwable) string);
                if (stackTraceString.trim().isEmpty()) {
                    stackTraceString = string.toString();
                }
                sb.append(stackTraceString);
                sb.append('\n');
            } else {
                sb.append(formatReadableJson(string));
                if (string == null || !string.toString().endsWith("=")) {
                    sb.append(", ");
                }
            }
        }

        if (sb.toString().endsWith(", ")) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }

        return sb.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    private static String formatReadableJson(Object jsonStr) {

        String strJson = jsonStr != null ? jsonStr.toString() : null;

        if (TextUtils.isEmpty(strJson)) {
            return strJson;
        }
        try {
            if (strJson.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(strJson);
                return "\n" + jsonObject.toString(JSON_INDENT) + "\n";
            }
            if (strJson.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(strJson);
                return "\n" + jsonArray.toString(JSON_INDENT) + "\n";
            }
        } catch (JSONException e) {
        }

        return strJson;

    }

}
