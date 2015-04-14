import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Bb
  implements AQ
{
  final AW a;
  private final LD b;
  private final AZ c;
  private final boolean d;
  
  Bb(LD paramLD, int paramInt, boolean paramBoolean)
  {
    this.b = paramLD;
    this.d = paramBoolean;
    this.c = new AZ(this.b);
    this.a = new AW(paramInt, this.c);
  }
  
  private List<AT> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    AZ localAZ = this.c;
    this.c.d = paramInt1;
    localAZ.a = paramInt1;
    this.c.e = paramShort;
    this.c.b = paramByte;
    this.c.c = paramInt2;
    this.a.a();
    return this.a.b();
  }
  
  private void a(AR paramAR, int paramInt)
  {
    this.b.m();
    this.b.k();
  }
  
  private void a(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 == 0) {
      throw AY.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x8) == 0) {
        break label103;
      }
    }
    label103:
    for (short s = (short)(0xFF & this.b.k());; s = 0)
    {
      if ((paramByte & 0x20) != 0)
      {
        a(paramAR, paramInt2);
        paramInt1 -= 5;
      }
      paramAR.a(false, bool, paramInt2, -1, a(AY.a(paramInt1, paramByte, s), s, paramByte, paramInt2), AU.d);
      return;
      bool = false;
      break;
    }
  }
  
  private void b(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool1 = true;
    short s = 0;
    boolean bool2;
    if ((paramByte & 0x1) != 0)
    {
      bool2 = bool1;
      if ((paramByte & 0x20) == 0) {
        break label44;
      }
    }
    for (;;)
    {
      if (!bool1) {
        break label50;
      }
      throw AY.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool2 = false;
      break;
      label44:
      bool1 = false;
    }
    label50:
    if ((paramByte & 0x8) != 0) {
      s = (short)(0xFF & this.b.k());
    }
    int i = AY.a(paramInt1, paramByte, s);
    paramAR.a(bool2, paramInt2, this.b, i);
    this.b.g(s);
  }
  
  private void c(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 5)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      throw AY.a("TYPE_PRIORITY length: %d != 5", arrayOfObject);
    }
    if (paramInt2 == 0) {
      throw AY.a("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    a(paramAR, paramInt2);
  }
  
  private void d(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw AY.a("TYPE_RST_STREAM length: %d != 4", arrayOfObject2);
    }
    if (paramInt2 == 0) {
      throw AY.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    int i = this.b.m();
    AP localAP = AP.b(i);
    if (localAP == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
      throw AY.a("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
    }
    paramAR.a(paramInt2, localAP);
  }
  
  private void e(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 != 0) {
      throw AY.a("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0) {
        throw AY.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
    }
    else
    {
      if (paramInt1 % 6 != 0)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(paramInt1);
        throw AY.a("TYPE_SETTINGS length %% 6 != 0: %s", arrayOfObject3);
      }
      Bn localBn = new Bn();
      int i = 0;
      if (i < paramInt1)
      {
        short s = this.b.l();
        int j = this.b.m();
        switch (s)
        {
        default: 
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Short.valueOf(s);
          throw AY.a("PROTOCOL_ERROR invalid settings id: %s", arrayOfObject2);
        case 2: 
          if ((j != 0) && (j != 1)) {
            throw AY.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
          }
          break;
        case 3: 
          s = 4;
        }
        do
        {
          do
          {
            localBn.a(s, 0, j);
            i += 6;
            break;
            s = 7;
          } while (j >= 0);
          throw AY.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        } while ((j >= 16384) && (j <= 16777215));
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        throw AY.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", arrayOfObject1);
      }
      paramAR.a(false, localBn);
      if (localBn.c() >= 0) {
        this.a.a(localBn.c());
      }
    }
  }
  
  private void f(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw AY.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x8) != 0) {
      s = (short)(0xFF & this.b.k());
    }
    paramAR.a(paramInt2, 0x7FFFFFFF & this.b.m(), a(AY.a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }
  
  private void g(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 != 8)
    {
      Object[] arrayOfObject = new Object[bool];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      throw AY.a("TYPE_PING length != 8: %s", arrayOfObject);
    }
    if (paramInt2 != 0) {
      throw AY.a("TYPE_PING streamId != 0", new Object[0]);
    }
    int i = this.b.m();
    int j = this.b.m();
    if ((paramByte & 0x1) != 0) {}
    for (;;)
    {
      paramAR.a(bool, i, j);
      return;
      bool = false;
    }
  }
  
  private void h(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 < 8)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw AY.a("TYPE_GOAWAY length < 8: %s", arrayOfObject2);
    }
    if (paramInt2 != 0) {
      throw AY.a("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    int i = this.b.m();
    int j = this.b.m();
    int k = paramInt1 - 8;
    AP localAP = AP.b(j);
    if (localAP == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(j);
      throw AY.a("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
    }
    LE localLE = LE.a;
    if (k > 0) {
      localLE = this.b.c(k);
    }
    paramAR.a(i, localAP, localLE);
  }
  
  private void i(AR paramAR, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt1);
      throw AY.a("TYPE_WINDOW_UPDATE length !=4: %s", arrayOfObject2);
    }
    long l = 0x7FFFFFFF & this.b.m();
    if (l == 0L)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf(l);
      throw AY.a("windowSizeIncrement was 0", arrayOfObject1);
    }
    paramAR.a(paramInt2, l);
  }
  
  public void a()
  {
    if (this.d) {}
    LE localLE;
    do
    {
      return;
      localLE = this.b.c(AY.a().e());
      if (AY.b().isLoggable(Level.FINE))
      {
        Logger localLogger = AY.b();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localLE.c();
        localLogger.fine(String.format("<< CONNECTION %s", arrayOfObject2));
      }
    } while (AY.a().equals(localLE));
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localLE.a();
    throw AY.a("Expected a connection header but was %s", arrayOfObject1);
  }
  
  public boolean a(AR paramAR)
  {
    boolean bool = true;
    int i;
    try
    {
      this.b.a(9L);
      i = AY.a(this.b);
      if ((i < 0) || (i > 16384))
      {
        Object[] arrayOfObject = new Object[bool];
        arrayOfObject[0] = Integer.valueOf(i);
        throw AY.a("FRAME_SIZE_ERROR: %s", arrayOfObject);
      }
    }
    catch (IOException localIOException)
    {
      bool = false;
    }
    for (;;)
    {
      return bool;
      byte b1 = 0xFF & this.b.k();
      byte b2 = 0xFF & this.b.k();
      int j = 0x7FFFFFFF & this.b.m();
      if (AY.b().isLoggable(Level.FINE)) {
        AY.b().fine(Ba.a(bool, j, i, b1, b2));
      }
      switch (b1)
      {
      default: 
        this.b.g(i);
        break;
      case 0: 
        b(paramAR, i, b2, j);
        break;
      case 1: 
        a(paramAR, i, b2, j);
        break;
      case 2: 
        c(paramAR, i, b2, j);
        break;
      case 3: 
        d(paramAR, i, b2, j);
        break;
      case 4: 
        e(paramAR, i, b2, j);
        break;
      case 5: 
        f(paramAR, i, b2, j);
        break;
      case 6: 
        g(paramAR, i, b2, j);
        break;
      case 7: 
        h(paramAR, i, b2, j);
        break;
      case 8: 
        i(paramAR, i, b2, j);
      }
    }
  }
  
  public void close()
  {
    this.b.close();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bb
 * JD-Core Version:    0.7.0.1
 */