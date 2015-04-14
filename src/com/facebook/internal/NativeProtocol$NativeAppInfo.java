package com.facebook.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;

abstract class NativeProtocol$NativeAppInfo
{
  private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
  private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
  private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
  private static final HashSet<String> validAppSignatureHashes = ;
  
  private static HashSet<String> buildAppSignatureHashes()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
    localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
    localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
    return localHashSet;
  }
  
  protected abstract String getPackage();
  
  public boolean validateSignature(Context paramContext, String paramString)
  {
    boolean bool = true;
    String str1 = Build.BRAND;
    int i = paramContext.getApplicationInfo().flags;
    if ((str1.startsWith("generic")) && ((i & 0x2) != 0)) {}
    for (;;)
    {
      return bool;
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        Signature[] arrayOfSignature = localPackageInfo.signatures;
        int j = arrayOfSignature.length;
        for (int k = 0;; k++)
        {
          if (k >= j) {
            break label106;
          }
          String str2 = Utility.sha1hash(arrayOfSignature[k].toByteArray());
          if (validAppSignatureHashes.contains(str2)) {
            break;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        bool = false;
      }
      label106:
      bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol.NativeAppInfo
 * JD-Core Version:    0.7.0.1
 */