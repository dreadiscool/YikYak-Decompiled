package com.squareup.picasso;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public class Picasso$Builder
{
  private Cache cache;
  private final Context context;
  private Downloader downloader;
  private boolean indicatorsEnabled;
  private Picasso.Listener listener;
  private boolean loggingEnabled;
  private ExecutorService service;
  private Picasso.RequestTransformer transformer;
  
  public Picasso$Builder(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null.");
    }
    this.context = paramContext.getApplicationContext();
  }
  
  public Picasso build()
  {
    Context localContext = this.context;
    if (this.downloader == null) {
      this.downloader = Utils.createDefaultDownloader(localContext);
    }
    if (this.cache == null) {
      this.cache = new LruCache(localContext);
    }
    if (this.service == null) {
      this.service = new PicassoExecutorService();
    }
    if (this.transformer == null) {
      this.transformer = Picasso.RequestTransformer.IDENTITY;
    }
    Stats localStats = new Stats(this.cache);
    return new Picasso(localContext, new Dispatcher(localContext, this.service, Picasso.HANDLER, this.downloader, this.cache, localStats), this.cache, this.listener, this.transformer, localStats, this.indicatorsEnabled, this.loggingEnabled);
  }
  
  @Deprecated
  public Builder debugging(boolean paramBoolean)
  {
    return indicatorsEnabled(paramBoolean);
  }
  
  public Builder downloader(Downloader paramDownloader)
  {
    if (paramDownloader == null) {
      throw new IllegalArgumentException("Downloader must not be null.");
    }
    if (this.downloader != null) {
      throw new IllegalStateException("Downloader already set.");
    }
    this.downloader = paramDownloader;
    return this;
  }
  
  public Builder executor(ExecutorService paramExecutorService)
  {
    if (paramExecutorService == null) {
      throw new IllegalArgumentException("Executor service must not be null.");
    }
    if (this.service != null) {
      throw new IllegalStateException("Executor service already set.");
    }
    this.service = paramExecutorService;
    return this;
  }
  
  public Builder indicatorsEnabled(boolean paramBoolean)
  {
    this.indicatorsEnabled = paramBoolean;
    return this;
  }
  
  public Builder listener(Picasso.Listener paramListener)
  {
    if (paramListener == null) {
      throw new IllegalArgumentException("Listener must not be null.");
    }
    if (this.listener != null) {
      throw new IllegalStateException("Listener already set.");
    }
    this.listener = paramListener;
    return this;
  }
  
  public Builder loggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
    return this;
  }
  
  public Builder memoryCache(Cache paramCache)
  {
    if (paramCache == null) {
      throw new IllegalArgumentException("Memory cache must not be null.");
    }
    if (this.cache != null) {
      throw new IllegalStateException("Memory cache already set.");
    }
    this.cache = paramCache;
    return this;
  }
  
  public Builder requestTransformer(Picasso.RequestTransformer paramRequestTransformer)
  {
    if (paramRequestTransformer == null) {
      throw new IllegalArgumentException("Transformer must not be null.");
    }
    if (this.transformer != null) {
      throw new IllegalStateException("Transformer already set.");
    }
    this.transformer = paramRequestTransformer;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.Builder
 * JD-Core Version:    0.7.0.1
 */