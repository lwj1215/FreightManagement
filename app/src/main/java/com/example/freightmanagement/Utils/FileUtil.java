/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.example.freightmanagement.Utils;

import android.content.Context;

import java.io.File;

public class FileUtil {
    public static File getSaveFile(Context context,String path) {
        File file = new File(context.getFilesDir(),path+"pic.jpg");
        return file;
    }
    public static File getSaveFile(Context context) {
        File file = new File(context.getFilesDir(),"pic.jpg");
        return file;
    }
}
