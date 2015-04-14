package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public abstract class AbstractCaverphone
  implements StringEncoder
{
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
    return encode((String)paramObject);
  }
  
  public boolean isEncodeEqual(String paramString1, String paramString2)
  {
    return encode(paramString1).equals(encode(paramString2));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.AbstractCaverphone
 * JD-Core Version:    0.7.0.1
 */