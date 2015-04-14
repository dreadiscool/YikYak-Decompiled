package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

abstract class BitmapHunter
  implements Runnable
{
  private static final Object DECODE_LOCK = new Object();
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new BitmapHunter.1();
  Action action;
  List<Action> actions;
  final Cache cache;
  final Request data;
  final Dispatcher dispatcher;
  Exception exception;
  int exifRotation;
  Future<?> future;
  final String key;
  Picasso.LoadedFrom loadedFrom;
  final Picasso picasso;
  Bitmap result;
  final boolean skipMemoryCache;
  final Stats stats;
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.skipMemoryCache = paramAction.skipCache;
    this.action = paramAction;
  }
  
  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap)
  {
    int i = paramList.size();
    int j = 0;
    Object localObject1 = paramBitmap;
    Transformation localTransformation;
    Bitmap localBitmap;
    Object localObject2;
    if (j < i)
    {
      localTransformation = (Transformation)paramList.get(j);
      localBitmap = localTransformation.transform((Bitmap)localObject1);
      if (localBitmap == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Transformation ").append(localTransformation.key()).append(" returned null after ").append(j).append(" previous transformation(s).\n\nTransformation list:\n");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((Transformation)localIterator.next()).key()).append('\n');
        }
        Picasso.HANDLER.post(new BitmapHunter.2(localStringBuilder));
        localObject2 = null;
      }
    }
    for (;;)
    {
      return localObject2;
      if ((localBitmap == localObject1) && (((Bitmap)localObject1).isRecycled()))
      {
        Picasso.HANDLER.post(new BitmapHunter.3(localTransformation));
        localObject2 = null;
      }
      else if ((localBitmap != localObject1) && (!((Bitmap)localObject1).isRecycled()))
      {
        Picasso.HANDLER.post(new BitmapHunter.4(localTransformation));
        localObject2 = null;
      }
      else
      {
        j++;
        localObject1 = localBitmap;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  static void calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    int j;
    if ((paramInt4 > paramInt2) || (paramInt3 > paramInt1))
    {
      i = (int)Math.floor(paramInt4 / paramInt2);
      j = (int)Math.floor(paramInt3 / paramInt1);
      if (i >= j) {
        break label58;
      }
    }
    for (;;)
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      return;
      label58:
      i = j;
    }
  }
  
  static void calculateInSampleSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    calculateInSampleSize(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions);
  }
  
  static BitmapFactory.Options createBitmapOptions(Request paramRequest)
  {
    boolean bool = paramRequest.hasSize();
    if (paramRequest.config != null) {}
    for (int i = 1;; i = 0)
    {
      BitmapFactory.Options localOptions = null;
      if ((bool) || (i != 0))
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = bool;
        if (i != 0) {
          localOptions.inPreferredConfig = paramRequest.config;
        }
      }
      return localOptions;
    }
  }
  
  static BitmapHunter forRequest(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, Downloader paramDownloader)
  {
    Object localObject;
    if (paramAction.getRequest().resourceId != 0) {
      localObject = new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    for (;;)
    {
      return localObject;
      Uri localUri = paramAction.getRequest().uri;
      String str = localUri.getScheme();
      if ("content".equals(str))
      {
        if ((ContactsContract.Contacts.CONTENT_URI.getHost().equals(localUri.getHost())) && (!localUri.getPathSegments().contains("photo"))) {
          localObject = new ContactsPhotoBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
        } else if ("media".equals(localUri.getAuthority())) {
          localObject = new MediaStoreBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
        } else {
          localObject = new ContentStreamBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
        }
      }
      else if ("file".equals(str))
      {
        if ((!localUri.getPathSegments().isEmpty()) && ("android_asset".equals(localUri.getPathSegments().get(0)))) {
          localObject = new AssetBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
        } else {
          localObject = new FileBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
        }
      }
      else if ("android.resource".equals(str)) {
        localObject = new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      } else {
        localObject = new NetworkBitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, paramDownloader);
      }
    }
  }
  
  static boolean requiresInSampleSize(BitmapFactory.Options paramOptions)
  {
    if ((paramOptions != null) && (paramOptions.inJustDecodeBounds)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    int i2;
    int i3;
    float f1;
    float f4;
    float f5;
    int i6;
    int i8;
    int i7;
    label147:
    int m;
    int n;
    int i1;
    if (paramRequest.needsMatrixTransform())
    {
      i2 = paramRequest.targetWidth;
      i3 = paramRequest.targetHeight;
      f1 = paramRequest.rotationDegrees;
      if (f1 != 0.0F)
      {
        if (paramRequest.hasRotationPivot) {
          localMatrix.setRotate(f1, paramRequest.rotationPivotX, paramRequest.rotationPivotY);
        }
      }
      else
      {
        if (!paramRequest.centerCrop) {
          break label280;
        }
        f4 = i2 / j;
        f5 = i3 / k;
        if (f4 <= f5) {
          break label234;
        }
        i6 = (int)Math.ceil(k * (f5 / f4));
        int i11 = (k - i6) / 2;
        int i12 = j;
        i8 = i11;
        i7 = i12;
        localMatrix.preScale(f4, f4);
        int i9 = i6;
        m = i;
        n = i9;
        int i10 = i8;
        j = i7;
        i1 = i10;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localMatrix.preRotate(paramInt);
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, m, i1, j, n, localMatrix, true);
      if (localBitmap != paramBitmap)
      {
        paramBitmap.recycle();
        paramBitmap = localBitmap;
      }
      return paramBitmap;
      localMatrix.setRotate(f1);
      break;
      label234:
      int i4 = (int)Math.ceil(j * (f4 / f5));
      int i5 = (j - i4) / 2;
      i6 = k;
      i7 = i4;
      f4 = f5;
      i = i5;
      i8 = 0;
      break label147;
      label280:
      if (paramRequest.centerInside)
      {
        float f2 = i2 / j;
        float f3 = i3 / k;
        if (f2 < f3) {}
        for (;;)
        {
          localMatrix.preScale(f2, f2);
          m = 0;
          n = k;
          i1 = 0;
          break;
          f2 = f3;
        }
      }
      if ((i2 != 0) && (i3 != 0) && ((i2 != j) || (i3 != k))) {
        localMatrix.preScale(i2 / j, i3 / k);
      }
      m = 0;
      n = k;
      i1 = 0;
    }
  }
  
  static void updateThreadName(Request paramRequest)
  {
    String str = paramRequest.getName();
    StringBuilder localStringBuilder = (StringBuilder)NAME_BUILDER.get();
    localStringBuilder.ensureCapacity("Picasso-".length() + str.length());
    localStringBuilder.replace("Picasso-".length(), localStringBuilder.length(), str);
    Thread.currentThread().setName(localStringBuilder.toString());
  }
  
  void attach(Action paramAction)
  {
    boolean bool = this.picasso.loggingEnabled;
    Request localRequest = paramAction.request;
    if (this.action == null)
    {
      this.action = paramAction;
      if (bool)
      {
        if ((this.actions != null) && (!this.actions.isEmpty())) {
          break label65;
        }
        Utils.log("Hunter", "joined", localRequest.logId(), "to empty hunter");
      }
    }
    for (;;)
    {
      return;
      label65:
      Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      continue;
      if (this.actions == null) {
        this.actions = new ArrayList(3);
      }
      this.actions.add(paramAction);
      if (bool) {
        Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      }
    }
  }
  
  boolean cancel()
  {
    boolean bool = false;
    if ((this.action == null) && ((this.actions == null) || (this.actions.isEmpty())) && (this.future != null) && (this.future.cancel(false))) {
      bool = true;
    }
    return bool;
  }
  
  abstract Bitmap decode(Request paramRequest);
  
  void detach(Action paramAction)
  {
    if (this.action == paramAction) {
      this.action = null;
    }
    for (;;)
    {
      if (this.picasso.loggingEnabled) {
        Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from "));
      }
      return;
      if (this.actions != null) {
        this.actions.remove(paramAction);
      }
    }
  }
  
  Action getAction()
  {
    return this.action;
  }
  
  List<Action> getActions()
  {
    return this.actions;
  }
  
  Request getData()
  {
    return this.data;
  }
  
  Exception getException()
  {
    return this.exception;
  }
  
  String getKey()
  {
    return this.key;
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return this.loadedFrom;
  }
  
  Picasso getPicasso()
  {
    return this.picasso;
  }
  
  Bitmap getResult()
  {
    return this.result;
  }
  
  Bitmap hunt()
  {
    Bitmap localBitmap;
    if (!this.skipMemoryCache)
    {
      localBitmap = this.cache.get(this.key);
      if (localBitmap != null)
      {
        this.stats.dispatchCacheHit();
        this.loadedFrom = Picasso.LoadedFrom.MEMORY;
        if (this.picasso.loggingEnabled) {
          Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
        }
      }
    }
    for (;;)
    {
      return localBitmap;
      localBitmap = decode(this.data);
      if (localBitmap == null) {
        continue;
      }
      if (this.picasso.loggingEnabled) {
        Utils.log("Hunter", "decoded", this.data.logId());
      }
      this.stats.dispatchBitmapDecoded(localBitmap);
      if ((!this.data.needsTransformation()) && (this.exifRotation == 0)) {
        continue;
      }
      synchronized (DECODE_LOCK)
      {
        if ((this.data.needsMatrixTransform()) || (this.exifRotation != 0))
        {
          localBitmap = transformResult(this.data, localBitmap, this.exifRotation);
          if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "transformed", this.data.logId());
          }
        }
        if (this.data.hasCustomTransformations())
        {
          localBitmap = applyCustomTransformations(this.data.transformations, localBitmap);
          if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
          }
        }
        if (localBitmap == null) {
          continue;
        }
        this.stats.dispatchBitmapTransformed(localBitmap);
      }
    }
  }
  
  boolean isCancelled()
  {
    if ((this.future != null) && (this.future.isCancelled())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        updateThreadName(this.data);
        if (this.picasso.loggingEnabled) {
          Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
        }
        this.result = hunt();
        if (this.result == null)
        {
          this.dispatcher.dispatchFailed(this);
          return;
        }
      }
      catch (Downloader.ResponseException localResponseException)
      {
        this.exception = localResponseException;
        this.dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (IOException localIOException)
      {
        this.exception = localIOException;
        this.dispatcher.dispatchRetry(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringWriter localStringWriter = new StringWriter();
        this.stats.createSnapshot().dump(new PrintWriter(localStringWriter));
        this.exception = new RuntimeException(localStringWriter.toString(), localOutOfMemoryError);
        this.dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (Exception localException)
      {
        this.exception = localException;
        this.dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      finally
      {
        Thread.currentThread().setName("Picasso-Idle");
      }
      this.dispatcher.dispatchComplete(this);
    }
  }
  
  protected void setExifRotation(int paramInt)
  {
    this.exifRotation = paramInt;
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return false;
  }
  
  boolean shouldSkipMemoryCache()
  {
    return this.skipMemoryCache;
  }
  
  boolean supportsReplay()
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter
 * JD-Core Version:    0.7.0.1
 */