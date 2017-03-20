package com.example.xiezhen.memoryleak;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * Created by xiezhen on 2017/3/16.
 */

public class CommonHelper {
    private Context context;
    private static CommonHelper commonHelper = null;

    private CommonHelper(Context context) {
        this.context = context;
    }

    public static CommonHelper getCommonHelper(Context context) {
        if (commonHelper == null) {
            commonHelper = new CommonHelper(context);
        }
        return commonHelper;
    }

    public int getVersionCode() {
        PackageInfo packInfo = getPackageInfo(context);
        if (packInfo != null) {
            return packInfo.versionCode;
        } else {
            return -1;
        }
    }

    public  String getVersionName() {
        PackageInfo packInfo = getPackageInfo(context);
        if (packInfo != null) {
            return packInfo.versionName;
        } else {
            return "";
        }
    }


    private PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e) {
            return null;
        }
    }


}

