package com.facebook.widget;

import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

class PlacePickerFragment$3
  implements Runnable
{
  PlacePickerFragment$3(PlacePickerFragment paramPlacePickerFragment) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.this$0.loadData(true);
        PickerFragment.OnErrorListener localOnErrorListener4;
        return;
      }
      catch (FacebookException localFacebookException2)
      {
        LoggingBehavior localLoggingBehavior4;
        Object[] arrayOfObject4;
        if (localFacebookException2 == null) {
          continue;
        }
        localOnErrorListener3 = this.this$0.getOnErrorListener();
        if (localOnErrorListener3 == null) {
          continue;
        }
        localOnErrorListener3.onError(this.this$0, localFacebookException2);
        continue;
        localLoggingBehavior3 = LoggingBehavior.REQUESTS;
        arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localFacebookException2;
        Logger.log(localLoggingBehavior3, "PlacePickerFragment", "Error loading data : %s", arrayOfObject3);
        continue;
      }
      catch (Exception localException)
      {
        localFacebookException1 = new FacebookException(localException);
        if (localFacebookException1 == null) {
          continue;
        }
        localOnErrorListener2 = this.this$0.getOnErrorListener();
        if (localOnErrorListener2 == null) {
          continue;
        }
        localOnErrorListener2.onError(this.this$0, localFacebookException1);
        continue;
        localLoggingBehavior2 = LoggingBehavior.REQUESTS;
        arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localFacebookException1;
        Logger.log(localLoggingBehavior2, "PlacePickerFragment", "Error loading data : %s", arrayOfObject2);
        continue;
      }
      finally
      {
        if (0 == 0) {
          break label244;
        }
        localOnErrorListener1 = this.this$0.getOnErrorListener();
        if (localOnErrorListener1 == null) {
          break label246;
        }
        localOnErrorListener1.onError(this.this$0, null);
      }
      localLoggingBehavior4 = LoggingBehavior.REQUESTS;
      arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = null;
      Logger.log(localLoggingBehavior4, "PlacePickerFragment", "Error loading data : %s", arrayOfObject4);
    }
    for (;;)
    {
      PickerFragment.OnErrorListener localOnErrorListener3;
      LoggingBehavior localLoggingBehavior3;
      Object[] arrayOfObject3;
      FacebookException localFacebookException1;
      PickerFragment.OnErrorListener localOnErrorListener2;
      LoggingBehavior localLoggingBehavior2;
      Object[] arrayOfObject2;
      PickerFragment.OnErrorListener localOnErrorListener1;
      label244:
      throw localObject;
      label246:
      LoggingBehavior localLoggingBehavior1 = LoggingBehavior.REQUESTS;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = null;
      Logger.log(localLoggingBehavior1, "PlacePickerFragment", "Error loading data : %s", arrayOfObject1);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment.3
 * JD-Core Version:    0.7.0.1
 */