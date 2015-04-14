package com.parse;

import java.io.IOException;
import l;
import m;

class ParseFile$3$2
  implements l<Void, m<Void>>
{
  ParseFile$3$2(ParseFile.3 param3) {}
  
  public m<Void> then(m<Void> paramm)
  {
    if (!paramm.d()) {}
    try
    {
      ParseFileUtils.writeByteArrayToFile(this.this$1.this$0.getCacheFile(), this.this$1.this$0.data);
      label30:
      ParseFile.access$102(this.this$1.this$0, false);
      return paramm;
    }
    catch (IOException localIOException)
    {
      break label30;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.3.2
 * JD-Core Version:    0.7.0.1
 */