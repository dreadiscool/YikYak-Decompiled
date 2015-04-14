package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;

class FileBitmapHunter
  extends ContentStreamBitmapHunter
{
  FileBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
  }
  
  static int getFileExifRotation(Uri paramUri)
  {
    int i;
    switch (new ExifInterface(paramUri.getPath()).getAttributeInt("Orientation", 1))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  Bitmap decode(Request paramRequest)
  {
    setExifRotation(getFileExifRotation(paramRequest.uri));
    return super.decode(paramRequest);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.FileBitmapHunter
 * JD-Core Version:    0.7.0.1
 */