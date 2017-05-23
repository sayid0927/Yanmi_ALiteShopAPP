/**
 * Copyright(C)2012-2013 深圳市掌星立意科技有限公司版权所有
 * 创 建 人:Jacky
 * 修 改 人:
 * 创 建日期:2013-7-25
 * 描    述:xml储存数据
 * 版 本 号:
 */
package com.aliteshopapp.base;

import android.content.Context;
import android.content.SharedPreferences;


public final class PreferUtil {

    public static PreferUtil INSTANCE;
    private static SharedPreferences mPrefer;
    private static final String APP_NAME = "com.zxly.o2o.sharedPreferences";
    private static final String LOGIN_USER = "login_user";
    private static final String LOGIN_TOKEN = "login_token";
    private static final String TOPIC_BV = "Topicbv";
    private static final String ARTICLE_BV = "Articlebv";
    private static final String ARTICLEREPLY_BV = "ArticleReplybv";
    private static final String HOME_MAINTAIN = "homepage_maintain";

    private static final String NOTIFY_ALL = "notification_all";
    private static final String NOTIFY_LOGOUT = "notification_logout";
    private static final String NOTIFY_SLEEP = "notification_sleep";
    private static final String NOTIFY_ORDER = "notification_order";
    private static final String NOTIFY_MONEY = "notification_money";
    private static final String NOTIFY_SYSTEM = "notification_system";
    private static final String NOTIFY_FEEDBACK = "notification_feedback";
    private static final String CONTACT_UPDATE = "contact_update";

    private PreferUtil() {
    }

    public static PreferUtil getInstance() {
        if (INSTANCE == null) {
            return new PreferUtil();
        }
        return INSTANCE;
    }

    public void init(Context ctx) {
        mPrefer = ctx.getSharedPreferences(APP_NAME, Context.MODE_WORLD_READABLE
                | Context.MODE_WORLD_WRITEABLE);
        mPrefer.edit().commit();
    }


    public String getString(String key, String defValue) {
        return mPrefer.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mPrefer.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefer.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mPrefer.edit().putString(key, value).commit();
    }

    public void putInt(String key, int value) {
        mPrefer.edit().putInt(key, value).commit();
    }

    public void putBoolean(String key, boolean value) {
        mPrefer.edit().putBoolean(key, value).commit();
    }

    public void putLong(String key, long value) {
        mPrefer.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mPrefer.getLong(key, defValue);
    }

    public void removeKey(String key) {
        mPrefer.edit().remove(key).commit();
    }

    public void setLoginToken(String tokenStr) {
        putString(LOGIN_TOKEN, tokenStr);
    }

    public String getLoginToken() {
        return getString(LOGIN_TOKEN, "");
    }
}
