package android.support.v7.internal.widget;

class AdapterViewCompat$SelectionNotifier
  implements Runnable
{
  private AdapterViewCompat$SelectionNotifier(AdapterViewCompat paramAdapterViewCompat) {}
  
  public void run()
  {
    if (this.this$0.mDataChanged) {
      if (this.this$0.getAdapter() != null) {
        this.this$0.post(this);
      }
    }
    for (;;)
    {
      return;
      AdapterViewCompat.access$200(this.this$0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat.SelectionNotifier
 * JD-Core Version:    0.7.0.1
 */