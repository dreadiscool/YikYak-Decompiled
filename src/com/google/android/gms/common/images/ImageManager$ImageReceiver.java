package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import hu;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

final class ImageManager$ImageReceiver
  extends ResultReceiver
{
  private final ArrayList<a> LE;
  private final Uri mUri;
  
  ImageManager$ImageReceiver(ImageManager paramImageManager, Uri paramUri)
  {
    super(new Handler(Looper.getMainLooper()));
    this.mUri = paramUri;
    this.LE = new ArrayList();
  }
  
  public void b(a parama)
  {
    hu.a("ImageReceiver.addImageRequest() must be called in the main thread");
    this.LE.add(parama);
  }
  
  public void c(a parama)
  {
    hu.a("ImageReceiver.removeImageRequest() must be called in the main thread");
    this.LE.remove(parama);
  }
  
  public void hg()
  {
    Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
    localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
    localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
    localIntent.putExtra("com.google.android.gms.extras.priority", 3);
    ImageManager.b(this.LF).sendBroadcast(localIntent);
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
    ImageManager.f(this.LF).execute(new ImageManager.c(this.LF, this.mUri, localParcelFileDescriptor));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.ImageReceiver
 * JD-Core Version:    0.7.0.1
 */