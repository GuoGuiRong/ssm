package com.ggr.ssm.util;

import java.util.UUID;

/**
 * Created by GuiRunning on 2017/7/25.
 */
public class StringUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
