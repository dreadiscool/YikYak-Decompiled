import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class wQ
{
  private IvParameterSpec a;
  private SecretKeySpec b;
  private Cipher c;
  
  public wQ(String paramString1, String paramString2)
  {
    this.a = new IvParameterSpec(paramString2.getBytes());
    this.b = new SecretKeySpec(paramString1.getBytes(), "AES");
    try
    {
      this.c = Cipher.getInstance("AES/CBC/NoPadding");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      for (;;)
      {
        localNoSuchPaddingException.printStackTrace();
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      str = null;
      return str;
    }
    int i = paramArrayOfByte.length;
    String str = "";
    int j = 0;
    label16:
    if (j < i) {
      if ((0xFF & paramArrayOfByte[j]) >= 16) {
        break label72;
      }
    }
    label72:
    for (str = str + "0" + Integer.toHexString(0xFF & paramArrayOfByte[j]);; str = str + Integer.toHexString(0xFF & paramArrayOfByte[j]))
    {
      j++;
      break label16;
      break;
    }
  }
  
  private static String b(String paramString)
  {
    int i = 16 - paramString.length() % 16;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return paramString;
      }
      paramString = paramString + ' ';
    }
  }
  
  public byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Exception("Empty string");
    }
    try
    {
      this.c.init(1, this.b, this.a);
      byte[] arrayOfByte = this.c.doFinal(b(paramString).getBytes());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new Exception("[encrypt] " + localException.getMessage());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wQ
 * JD-Core Version:    0.7.0.1
 */