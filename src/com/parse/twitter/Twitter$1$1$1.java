package com.parse.twitter;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.parse.signpost.OAuthProvider;
import com.parse.signpost.http.HttpParameters;

class Twitter$1$1$1
  extends AsyncTask<Void, Void, HttpParameters>
{
  private Throwable error;
  
  Twitter$1$1$1(Twitter.1.1 param1, String paramString) {}
  
  protected HttpParameters doInBackground(Void... paramVarArgs)
  {
    try
    {
      this.this$2.this$1.val$provider.retrieveAccessToken(this.this$2.this$1.val$consumer, this.val$verifier);
      return this.this$2.this$1.val$provider.getResponseParameters();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.error = localThrowable;
      }
    }
  }
  
  /* Error */
  protected void onPostExecute(HttpParameters paramHttpParameters)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 62	android/os/AsyncTask:onPostExecute	(Ljava/lang/Object;)V
    //   5: aload_0
    //   6: getfield 52	com/parse/twitter/Twitter$1$1$1:error	Ljava/lang/Throwable;
    //   9: ifnull +36 -> 45
    //   12: aload_0
    //   13: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   16: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   19: getfield 66	com/parse/twitter/Twitter$1:val$callback	Lcom/parse/internal/AsyncCallback;
    //   22: aload_0
    //   23: getfield 52	com/parse/twitter/Twitter$1$1$1:error	Ljava/lang/Throwable;
    //   26: invokeinterface 72 2 0
    //   31: aload_0
    //   32: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   35: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   38: getfield 76	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   41: invokevirtual 81	android/app/ProgressDialog:dismiss	()V
    //   44: return
    //   45: aload_0
    //   46: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   49: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   52: getfield 85	com/parse/twitter/Twitter$1:this$0	Lcom/parse/twitter/Twitter;
    //   55: aload_0
    //   56: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   59: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   62: getfield 40	com/parse/twitter/Twitter$1:val$consumer	Lcom/parse/signpost/OAuthConsumer;
    //   65: invokeinterface 91 1 0
    //   70: invokevirtual 97	com/parse/twitter/Twitter:setAuthToken	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   77: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   80: getfield 85	com/parse/twitter/Twitter$1:this$0	Lcom/parse/twitter/Twitter;
    //   83: aload_0
    //   84: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   87: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   90: getfield 40	com/parse/twitter/Twitter$1:val$consumer	Lcom/parse/signpost/OAuthConsumer;
    //   93: invokeinterface 100 1 0
    //   98: invokevirtual 103	com/parse/twitter/Twitter:setAuthTokenSecret	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   105: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   108: getfield 85	com/parse/twitter/Twitter$1:this$0	Lcom/parse/twitter/Twitter;
    //   111: aload_1
    //   112: ldc 105
    //   114: invokevirtual 111	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 114	com/parse/twitter/Twitter:setScreenName	(Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   124: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   127: getfield 85	com/parse/twitter/Twitter$1:this$0	Lcom/parse/twitter/Twitter;
    //   130: aload_1
    //   131: ldc 116
    //   133: invokevirtual 111	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 119	com/parse/twitter/Twitter:setUserId	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   143: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   146: getfield 66	com/parse/twitter/Twitter$1:val$callback	Lcom/parse/internal/AsyncCallback;
    //   149: aload_0
    //   150: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   153: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   156: getfield 85	com/parse/twitter/Twitter$1:this$0	Lcom/parse/twitter/Twitter;
    //   159: invokeinterface 122 2 0
    //   164: aload_0
    //   165: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   168: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   171: getfield 76	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   174: invokevirtual 81	android/app/ProgressDialog:dismiss	()V
    //   177: goto -133 -> 44
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   185: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   188: getfield 66	com/parse/twitter/Twitter$1:val$callback	Lcom/parse/internal/AsyncCallback;
    //   191: aload_3
    //   192: invokeinterface 72 2 0
    //   197: aload_0
    //   198: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   201: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   204: getfield 76	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   207: invokevirtual 81	android/app/ProgressDialog:dismiss	()V
    //   210: goto -166 -> 44
    //   213: astore_2
    //   214: aload_0
    //   215: getfield 15	com/parse/twitter/Twitter$1$1$1:this$2	Lcom/parse/twitter/Twitter$1$1;
    //   218: getfield 30	com/parse/twitter/Twitter$1$1:this$1	Lcom/parse/twitter/Twitter$1;
    //   221: getfield 76	com/parse/twitter/Twitter$1:val$progress	Landroid/app/ProgressDialog;
    //   224: invokevirtual 81	android/app/ProgressDialog:dismiss	()V
    //   227: aload_2
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	1
    //   0	229	1	paramHttpParameters	HttpParameters
    //   213	15	2	localObject	java.lang.Object
    //   180	12	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	139	180	java/lang/Throwable
    //   5	31	213	finally
    //   45	139	213	finally
    //   139	164	213	finally
    //   181	197	213	finally
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.this$2.this$1.val$progress.show();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.twitter.Twitter.1.1.1
 * JD-Core Version:    0.7.0.1
 */