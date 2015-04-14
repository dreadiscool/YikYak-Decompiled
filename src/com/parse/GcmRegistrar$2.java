package com.parse;

import l;
import m;

class GcmRegistrar$2
  implements l<String, Void>
{
  GcmRegistrar$2(GcmRegistrar paramGcmRegistrar) {}
  
  public Void then(m<String> paramm)
  {
    Exception localException = paramm.f();
    if (localException != null) {
      Parse.logE("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", localException);
    }
    synchronized (GcmRegistrar.access$000(this.this$0))
    {
      GcmRegistrar.access$102(this.this$0, null);
      return null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmRegistrar.2
 * JD-Core Version:    0.7.0.1
 */