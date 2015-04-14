package android.support.v4.widget;

class ContentLoadingProgressBar$2
  implements Runnable
{
  ContentLoadingProgressBar$2(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public void run()
  {
    ContentLoadingProgressBar.access$202(this.this$0, false);
    if (!ContentLoadingProgressBar.access$300(this.this$0))
    {
      ContentLoadingProgressBar.access$102(this.this$0, System.currentTimeMillis());
      this.this$0.setVisibility(0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar.2
 * JD-Core Version:    0.7.0.1
 */