package com.parse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import l;
import m;

class ParseImageView$1
  implements l<byte[], m<byte[]>>
{
  ParseImageView$1(ParseImageView paramParseImageView, ParseFile paramParseFile) {}
  
  public m<byte[]> then(m<byte[]> paramm)
  {
    byte[] arrayOfByte = (byte[])paramm.e();
    if (ParseImageView.access$000(this.this$0) != this.val$loadingFile) {
      paramm = m.h();
    }
    for (;;)
    {
      return paramm;
      if (arrayOfByte != null)
      {
        Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        if (localBitmap != null) {
          this.this$0.setImageBitmap(localBitmap);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseImageView.1
 * JD-Core Version:    0.7.0.1
 */