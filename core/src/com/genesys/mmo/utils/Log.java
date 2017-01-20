package com.genesys.mmo.utils;

import com.genesys.mmo.utils.Constants;

/**
 * Created by brendan on 1/6/17.
 */
public class Log {

    public static void debug(String message) {
        if (Constants.SHOW_DEBUG_LOGS) {
            System.out.println(message);
        }
    }

    public static void debug(String tag, String message) {
        debug(tag + ": " + message);
    }

    public static void debug(Object object, String message) {
        debug(object.getClass().getSimpleName(), message);
    }
}
