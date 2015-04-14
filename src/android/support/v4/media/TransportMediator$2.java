package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

class TransportMediator$2
  implements KeyEvent.Callback
{
  TransportMediator$2(TransportMediator paramTransportMediator) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.isMediaKey(paramInt)) {}
    for (boolean bool = this.this$0.mCallbacks.onMediaButtonDown(paramInt, paramKeyEvent);; bool = false) {
      return bool;
    }
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.isMediaKey(paramInt)) {}
    for (boolean bool = this.this$0.mCallbacks.onMediaButtonUp(paramInt, paramKeyEvent);; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator.2
 * JD-Core Version:    0.7.0.1
 */