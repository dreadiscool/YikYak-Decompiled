package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public class Caverphone
  implements StringEncoder
{
  private final Caverphone2 encoder = new Caverphone2();
  
  public String caverphone(String paramString)
  {
    return this.encoder.encode(paramString);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
    return caverphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return caverphone(paramString);
  }
  
  public boolean isCaverphoneEqual(String paramString1, String paramString2)
  {
    return caverphone(paramString1).equals(caverphone(paramString2));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.Caverphone
 * JD-Core Version:    0.7.0.1
 */