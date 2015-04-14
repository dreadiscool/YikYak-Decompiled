package com.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class PushConnection$ReaderThread
  extends Thread
{
  private Socket socket;
  private boolean stopped;
  
  public PushConnection$ReaderThread(PushConnection paramPushConnection, Socket paramSocket)
  {
    this.socket = paramSocket;
    this.stopped = false;
  }
  
  /* Error */
  private void runReaderLoop(BufferedReader paramBufferedReader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 33	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   4: astore 10
    //   6: aload 10
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 14	com/parse/PushConnection$ReaderThread:this$0	Lcom/parse/PushConnection;
    //   13: invokestatic 39	com/parse/PushConnection:access$1100	(Lcom/parse/PushConnection;)Ljava/util/concurrent/atomic/AtomicLong;
    //   16: invokestatic 45	android/os/SystemClock:elapsedRealtime	()J
    //   19: invokevirtual 51	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   22: aload_3
    //   23: astore 4
    //   25: aload 4
    //   27: ifnonnull +13 -> 40
    //   30: return
    //   31: astore_2
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: goto -12 -> 25
    //   40: new 53	org/json/JSONTokener
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 56	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: new 58	org/json/JSONObject
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 61	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +9 -> 73
    //   67: aload 6
    //   69: invokestatic 67	com/parse/PushRouter:handlePpnsPushAsync	(Lorg/json/JSONObject;)Lm;
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 21	com/parse/PushConnection$ReaderThread:stopped	Z
    //   79: ifeq +50 -> 129
    //   82: aload_0
    //   83: monitorexit
    //   84: goto -54 -> 30
    //   87: astore 7
    //   89: aload_0
    //   90: monitorexit
    //   91: aload 7
    //   93: athrow
    //   94: astore 9
    //   96: ldc 69
    //   98: new 71	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   105: ldc 74
    //   107: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 4
    //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aload 9
    //   120: invokestatic 87	com/parse/Parse:logE	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aconst_null
    //   124: astore 6
    //   126: goto -64 -> 62
    //   129: aload_0
    //   130: monitorexit
    //   131: goto -131 -> 0
    //   134: astore 11
    //   136: goto -102 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	ReaderThread
    //   0	139	1	paramBufferedReader	BufferedReader
    //   31	1	2	localIOException1	IOException
    //   8	27	3	str1	java.lang.String
    //   23	88	4	str2	java.lang.String
    //   49	7	5	localJSONTokener	org.json.JSONTokener
    //   60	65	6	localJSONObject	org.json.JSONObject
    //   87	5	7	localObject	Object
    //   94	25	9	localJSONException	org.json.JSONException
    //   4	3	10	str3	java.lang.String
    //   134	1	11	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   0	6	31	java/io/IOException
    //   75	91	87	finally
    //   129	131	87	finally
    //   51	62	94	org/json/JSONException
    //   9	22	134	java/io/IOException
  }
  
  public void run()
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      if (localBufferedReader != null) {
        runReaderLoop(localBufferedReader);
      }
      try
      {
        localBufferedReader.close();
        try
        {
          label35:
          if (!this.stopped) {
            PushConnection.access$300(this.this$0).signalEvent(PushConnection.Event.READ_ERROR);
          }
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
      catch (IOException localIOException1)
      {
        break label35;
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
  }
  
  public void stopReading()
  {
    try
    {
      this.stopped = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.ReaderThread
 * JD-Core Version:    0.7.0.1
 */