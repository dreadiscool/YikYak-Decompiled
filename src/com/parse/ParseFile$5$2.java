package com.parse;

import l;
import m;
import y;

class ParseFile$5$2
  implements l<byte[], m<byte[]>>
{
  ParseFile$5$2(ParseFile.5 param5) {}
  
  public m<byte[]> then(m<byte[]> paramm)
  {
    if ((paramm.d()) && ((paramm.f() instanceof IllegalStateException))) {
      paramm = m.a(new ParseException(100, paramm.f().getMessage()));
    }
    for (;;)
    {
      return paramm;
      if (this.this$1.val$tcs.a().c())
      {
        paramm = this.this$1.val$tcs.a();
      }
      else
      {
        this.this$1.this$0.data = ((byte[])paramm.e());
        if (this.this$1.this$0.data != null) {
          ParseFileUtils.writeByteArrayToFile(this.this$1.this$0.getCacheFile(), this.this$1.this$0.data);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.5.2
 * JD-Core Version:    0.7.0.1
 */