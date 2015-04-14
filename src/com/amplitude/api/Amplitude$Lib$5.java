package com.amplitude.api;

class Amplitude$Lib$5
  implements Runnable
{
  Amplitude$Lib$5(Amplitude.Lib paramLib, long paramLong) {}
  
  public void run()
  {
    this.this$0.logThread.removeCallbacks(Amplitude.Lib.access$1600(this.this$0));
    long l1 = Amplitude.Lib.access$1700(this.this$0);
    long l2 = Amplitude.Lib.access$1800(this.this$0);
    if ((l1 != -1L) && (this.val$now - l2 < 15000L)) {
      DatabaseHelper.getDatabaseHelper(Amplitude.Lib.access$1900(this.this$0)).removeEvent(l1);
    }
    Amplitude.Lib.access$2000(this.this$0, this.val$now);
    Amplitude.Lib.access$2100(this.this$0);
    Amplitude.Lib.access$2200(this.this$0, this.val$now);
    this.this$0.uploadEvents();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.Amplitude.Lib.5
 * JD-Core Version:    0.7.0.1
 */