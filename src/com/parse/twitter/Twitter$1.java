package com.parse.twitter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.parse.internal.AsyncCallback;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.OAuthProvider;

class Twitter$1
  extends AsyncTask<Void, Void, String>
{
  private Throwable error;
  
  Twitter$1(Twitter paramTwitter, AsyncCallback paramAsyncCallback, Context paramContext, OAuthProvider paramOAuthProvider, OAuthConsumer paramOAuthConsumer, ProgressDialog paramProgressDialog) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      String str2 = this.val$provider.retrieveRequestToken(this.val$consumer, "twitter-oauth://complete");
      str1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.error = localThrowable;
        String str1 = null;
      }
    }
    return str1;
  }
  
  /* Error */
  protected void onPostExecute(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 64	android/os/AsyncTask:onPostExecute	(Ljava/lang/Object;)V
    //   5: aload_0
    //   6: getfield 55	com/parse/twitter/Twitter$1:error	Ljava/lang/Throwable;
    //   9: ifnull +24 -> 33
    //   12: aload_0
    //   13: getfield 25	com/parse/twitter/Twitter$1:val$callback	Lcom/parse/internal/AsyncCallback;
    //   16: aload_0
    //   17: getfield 55	com/parse/twitter/Twitter$1:error	Ljava/lang/Throwable;
    //   20: invokeinterface 70 2 0
    //   25: aload_0
    //   26: getfield 33	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   29: invokevirtual 75	android/app/ProgressDialog:dismiss	()V
    //   32: return
    //   33: aload_0
    //   34: getfield 27	com/parse/twitter/Twitter$1:val$context	Landroid/content/Context;
    //   37: invokestatic 81	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   40: pop
    //   41: new 83	com/parse/oauth/OAuth1FlowDialog
    //   44: dup
    //   45: aload_0
    //   46: getfield 27	com/parse/twitter/Twitter$1:val$context	Landroid/content/Context;
    //   49: aload_1
    //   50: ldc 47
    //   52: ldc 85
    //   54: new 87	com/parse/twitter/Twitter$1$1
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 90	com/parse/twitter/Twitter$1$1:<init>	(Lcom/parse/twitter/Twitter$1;)V
    //   62: invokespecial 93	com/parse/oauth/OAuth1FlowDialog:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/parse/oauth/OAuth1FlowDialog$FlowResultHandler;)V
    //   65: invokevirtual 96	com/parse/oauth/OAuth1FlowDialog:show	()V
    //   68: aload_0
    //   69: getfield 33	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   72: invokevirtual 75	android/app/ProgressDialog:dismiss	()V
    //   75: goto -43 -> 32
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 33	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   83: invokevirtual 75	android/app/ProgressDialog:dismiss	()V
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	1
    //   0	88	1	paramString	String
    //   78	9	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   5	25	78	finally
    //   33	68	78	finally
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.val$progress.show();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.twitter.Twitter.1
 * JD-Core Version:    0.7.0.1
 */