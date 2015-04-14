import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public abstract class tv
  extends ts
  implements Runnable, tp
{
  protected URI a = null;
  private tt c = null;
  private Socket d = null;
  private InputStream e;
  private OutputStream f;
  private Proxy g = Proxy.NO_PROXY;
  private Thread h;
  private ty i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  
  static
  {
    if (!tv.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public tv(URI paramURI, ty paramty, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (paramty == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.a = paramURI;
    this.i = paramty;
    this.j = paramMap;
    this.m = paramInt;
    this.c = new tt(this, paramty);
  }
  
  private int g()
  {
    int n = this.a.getPort();
    String str;
    if (n == -1)
    {
      str = this.a.getScheme();
      if (!str.equals("wss")) {
        break label37;
      }
    }
    for (n = 443;; n = 80)
    {
      return n;
      label37:
      if (!str.equals("ws")) {
        break;
      }
    }
    throw new RuntimeException("unkonow scheme" + str);
  }
  
  private void h()
  {
    String str1 = this.a.getPath();
    String str2 = this.a.getQuery();
    if ((str1 == null) || (str1.length() == 0)) {
      str1 = "/";
    }
    if (str2 != null) {
      str1 = str1 + "?" + str2;
    }
    int n = g();
    StringBuilder localStringBuilder = new StringBuilder().append(this.a.getHost());
    if (n != 80) {}
    tW localtW;
    for (String str3 = ":" + n;; str3 = "")
    {
      String str4 = str3;
      localtW = new tW();
      localtW.a(str1);
      localtW.a("Host", str4);
      if (this.j == null) {
        break;
      }
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localtW.a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    this.c.a(localtW);
  }
  
  public InetSocketAddress a()
  {
    return this.c.a();
  }
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void a(Exception paramException);
  
  public abstract void a(String paramString);
  
  public void a(Socket paramSocket)
  {
    if (this.d != null) {
      throw new IllegalStateException("socket has already been set");
    }
    this.d = paramSocket;
  }
  
  public void a(tQ paramtQ)
  {
    this.c.a(paramtQ);
  }
  
  public void a(tR paramtR, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.c.a(paramtR, paramByteBuffer, paramBoolean);
  }
  
  public final void a(tp paramtp, int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    if (this.h != null) {
      this.h.interrupt();
    }
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      a(paramInt, paramString, paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        a(this, localIOException);
      }
    }
  }
  
  public final void a(tp paramtp, Exception paramException)
  {
    a(paramException);
  }
  
  public final void a(tp paramtp, String paramString)
  {
    a(paramString);
  }
  
  public final void a(tp paramtp, tY paramtY)
  {
    this.k.countDown();
    a((ua)paramtY);
  }
  
  public abstract void a(ua paramua);
  
  public InetSocketAddress b(tp paramtp)
  {
    if (this.d != null) {}
    for (InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.d.getLocalSocketAddress();; localInetSocketAddress = null) {
      return localInetSocketAddress;
    }
  }
  
  public void b()
  {
    if (this.h != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    this.h = new Thread(this);
    this.h.start();
  }
  
  public boolean c()
  {
    b();
    this.k.await();
    return this.c.c();
  }
  
  public boolean d()
  {
    return this.c.e();
  }
  
  public boolean e()
  {
    return this.c.f();
  }
  
  public boolean f()
  {
    return this.c.d();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	tv:d	Ljava/net/Socket;
    //   4: ifnonnull +190 -> 194
    //   7: aload_0
    //   8: new 227	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 61	tv:g	Ljava/net/Proxy;
    //   16: invokespecial 279	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 54	tv:d	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 54	tv:d	Ljava/net/Socket;
    //   26: invokevirtual 282	java/net/Socket:isBound	()Z
    //   29: ifne +32 -> 61
    //   32: aload_0
    //   33: getfield 54	tv:d	Ljava/net/Socket;
    //   36: new 252	java/net/InetSocketAddress
    //   39: dup
    //   40: aload_0
    //   41: getfield 50	tv:a	Ljava/net/URI;
    //   44: invokevirtual 146	java/net/URI:getHost	()Ljava/lang/String;
    //   47: aload_0
    //   48: invokespecial 143	tv:g	()I
    //   51: invokespecial 285	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   54: aload_0
    //   55: getfield 72	tv:m	I
    //   58: invokevirtual 289	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 54	tv:d	Ljava/net/Socket;
    //   66: invokevirtual 293	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   69: putfield 295	tv:e	Ljava/io/InputStream;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 54	tv:d	Ljava/net/Socket;
    //   77: invokevirtual 299	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   80: putfield 93	tv:f	Ljava/io/OutputStream;
    //   83: aload_0
    //   84: invokespecial 301	tv:h	()V
    //   87: aload_0
    //   88: new 222	java/lang/Thread
    //   91: dup
    //   92: new 303	tx
    //   95: dup
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 306	tx:<init>	(Ltv;Ltw;)V
    //   101: invokespecial 257	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   104: putfield 220	tv:h	Ljava/lang/Thread;
    //   107: aload_0
    //   108: getfield 220	tv:h	Ljava/lang/Thread;
    //   111: invokevirtual 260	java/lang/Thread:start	()V
    //   114: getstatic 308	tt:a	I
    //   117: newarray byte
    //   119: astore_2
    //   120: aload_0
    //   121: invokevirtual 309	tv:e	()Z
    //   124: ifne +112 -> 236
    //   127: aload_0
    //   128: getfield 295	tv:e	Ljava/io/InputStream;
    //   131: aload_2
    //   132: invokevirtual 315	java/io/InputStream:read	([B)I
    //   135: istore 5
    //   137: iload 5
    //   139: bipush 255
    //   141: if_icmpeq +95 -> 236
    //   144: aload_0
    //   145: getfield 52	tv:c	Ltt;
    //   148: aload_2
    //   149: iconst_0
    //   150: iload 5
    //   152: invokestatic 321	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   155: invokevirtual 324	tt:a	(Ljava/nio/ByteBuffer;)V
    //   158: goto -38 -> 120
    //   161: astore 4
    //   163: aload_0
    //   164: getfield 52	tv:c	Ltt;
    //   167: invokevirtual 325	tt:b	()V
    //   170: getstatic 44	tv:b	Z
    //   173: ifne +62 -> 235
    //   176: aload_0
    //   177: getfield 54	tv:d	Ljava/net/Socket;
    //   180: invokevirtual 328	java/net/Socket:isClosed	()Z
    //   183: ifne +52 -> 235
    //   186: new 330	java/lang/AssertionError
    //   189: dup
    //   190: invokespecial 331	java/lang/AssertionError:<init>	()V
    //   193: athrow
    //   194: aload_0
    //   195: getfield 54	tv:d	Ljava/net/Socket;
    //   198: invokevirtual 328	java/net/Socket:isClosed	()Z
    //   201: ifeq -179 -> 22
    //   204: new 215	java/io/IOException
    //   207: dup
    //   208: invokespecial 332	java/io/IOException:<init>	()V
    //   211: athrow
    //   212: astore_1
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 52	tv:c	Ltt;
    //   218: aload_1
    //   219: invokevirtual 235	tv:a	(Ltp;Ljava/lang/Exception;)V
    //   222: aload_0
    //   223: getfield 52	tv:c	Ltt;
    //   226: bipush 255
    //   228: aload_1
    //   229: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 338	tt:b	(ILjava/lang/String;)V
    //   235: return
    //   236: aload_0
    //   237: getfield 52	tv:c	Ltt;
    //   240: invokevirtual 325	tt:b	()V
    //   243: goto -73 -> 170
    //   246: astore_3
    //   247: aload_0
    //   248: aload_3
    //   249: invokevirtual 237	tv:a	(Ljava/lang/Exception;)V
    //   252: aload_0
    //   253: getfield 52	tv:c	Ltt;
    //   256: sipush 1006
    //   259: aload_3
    //   260: invokevirtual 339	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 338	tt:b	(ILjava/lang/String;)V
    //   266: goto -96 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	tv
    //   212	17	1	localException	Exception
    //   119	30	2	arrayOfByte	byte[]
    //   246	14	3	localRuntimeException	RuntimeException
    //   161	1	4	localIOException	IOException
    //   135	16	5	n	int
    // Exception table:
    //   from	to	target	type
    //   120	158	161	java/io/IOException
    //   236	243	161	java/io/IOException
    //   0	87	212	java/lang/Exception
    //   194	212	212	java/lang/Exception
    //   120	158	246	java/lang/RuntimeException
    //   236	243	246	java/lang/RuntimeException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tv
 * JD-Core Version:    0.7.0.1
 */