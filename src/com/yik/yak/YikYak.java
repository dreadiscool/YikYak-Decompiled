package com.yik.yak;

import ApplicationConfig;
import BW;
import BZ;
import CR;
import CU;
import CZ;
import G;
import IC;
import IM;
import If;
import Ik;
import Ip;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import java.net.CookieHandler;
import java.net.CookieManager;

@SuppressLint({"TrulyRandom"})
public class YikYak
    extends Application
{
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    private static YikYak instance;
    private static int pendingNotifications = 0;
    private static String g = null;
    
    // public static YikYak a()
    public static YikYak getInstance()
    {
        return instance;
    }
    
    // public static void a(int)
    public static void setPendingNotifications(int paramInt)
    {
        pendingNotifications = paramInt;
    }
    
    // public static void a(String)
    public static void setParseChannel(String paramString)
    {
        try
        {
            ParseInstallation.getCurrentInstallation().saveInBackground();
            Parse.setLogLevel(6);
            Ip.a("setParseChannel", "c" + paramString + "c");
            ParsePush.subscribeInBackground("c" + paramString + "c", new BW());
        }
        catch (Exception localException) { }
    }
    
    // public static int b()
    public static int getPendingNotifications()
    {
        return pendingNotifications;
    }
    
    // public static int c()
    public static int incrementAndGetPendingNotifications()
    {
        return ++pendingNotifications;
    }
    
    // public static Context d()
    public static Context getContext()
    {
        return instance.getApplicationContext();
    }
    
    // public static String e()
    public static String getVersion()
    {
        String version = null;
        // I don't know why this is in a loop, perhaps it's called before
        // PackageManager has a chance to initialize, so it blocks until it's
        // available?
        for (;;)
        {
            try
            {
                version = e.getPackageManager().getPackageInfo(e.getPackageName(), 0).versionName + d;
                break;
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException) { }
            return version;
        }
    }
    
    @SuppressLint({"TrulyRandom"})
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        IM[] arrayOfIM = new IM[1];
        arrayOfIM[0] = new G();
        IC.a(this, arrayOfIM);
        If.a().a(BV.n());
        BZ.a(this);
        CZ.a();
        registerActivityLifecycleCallbacks(new ActivityCallback());
        CookieHandler.setDefault(new CookieManager());
        CR.initYakBandC();
        Parse.initialize(this, b, c);
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.YikYak

 * JD-Core Version:    0.7.0.1

 */