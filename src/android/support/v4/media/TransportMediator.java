package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

public class TransportMediator
  extends TransportController
{
  public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
  public static final int FLAG_KEY_MEDIA_NEXT = 128;
  public static final int FLAG_KEY_MEDIA_PAUSE = 16;
  public static final int FLAG_KEY_MEDIA_PLAY = 4;
  public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
  public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
  public static final int FLAG_KEY_MEDIA_REWIND = 2;
  public static final int FLAG_KEY_MEDIA_STOP = 32;
  public static final int KEYCODE_MEDIA_PAUSE = 127;
  public static final int KEYCODE_MEDIA_PLAY = 126;
  public static final int KEYCODE_MEDIA_RECORD = 130;
  final AudioManager mAudioManager;
  final TransportPerformer mCallbacks;
  final Context mContext;
  final TransportMediatorJellybeanMR2 mController;
  final Object mDispatcherState;
  final KeyEvent.Callback mKeyEventCallback = new TransportMediator.2(this);
  final ArrayList<TransportStateListener> mListeners = new ArrayList();
  final TransportMediatorCallback mTransportKeyCallback = new TransportMediator.1(this);
  final View mView;
  
  public TransportMediator(Activity paramActivity, TransportPerformer paramTransportPerformer)
  {
    this(paramActivity, null, paramTransportPerformer);
  }
  
  private TransportMediator(Activity paramActivity, View paramView, TransportPerformer paramTransportPerformer)
  {
    Object localObject;
    if (paramActivity != null)
    {
      localObject = paramActivity;
      this.mContext = ((Context)localObject);
      this.mCallbacks = paramTransportPerformer;
      this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      if (paramActivity != null) {
        paramView = paramActivity.getWindow().getDecorView();
      }
      this.mView = paramView;
      this.mDispatcherState = KeyEventCompat.getKeyDispatcherState(this.mView);
      if (Build.VERSION.SDK_INT < 18) {
        break label146;
      }
    }
    label146:
    for (this.mController = new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);; this.mController = null)
    {
      return;
      localObject = paramView.getContext();
      break;
    }
  }
  
  public TransportMediator(View paramView, TransportPerformer paramTransportPerformer)
  {
    this(null, paramView, paramTransportPerformer);
  }
  
  private TransportStateListener[] getListeners()
  {
    TransportStateListener[] arrayOfTransportStateListener;
    if (this.mListeners.size() <= 0) {
      arrayOfTransportStateListener = null;
    }
    for (;;)
    {
      return arrayOfTransportStateListener;
      arrayOfTransportStateListener = new TransportStateListener[this.mListeners.size()];
      this.mListeners.toArray(arrayOfTransportStateListener);
    }
  }
  
  static boolean isMediaKey(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private void pushControllerState()
  {
    if (this.mController != null) {
      this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
    }
  }
  
  private void reportPlayingChanged()
  {
    TransportStateListener[] arrayOfTransportStateListener = getListeners();
    if (arrayOfTransportStateListener != null)
    {
      int i = arrayOfTransportStateListener.length;
      for (int j = 0; j < i; j++) {
        arrayOfTransportStateListener[j].onPlayingChanged(this);
      }
    }
  }
  
  private void reportTransportControlsChanged()
  {
    TransportStateListener[] arrayOfTransportStateListener = getListeners();
    if (arrayOfTransportStateListener != null)
    {
      int i = arrayOfTransportStateListener.length;
      for (int j = 0; j < i; j++) {
        arrayOfTransportStateListener[j].onTransportControlsChanged(this);
      }
    }
  }
  
  public void destroy()
  {
    this.mController.destroy();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return KeyEventCompat.dispatch(paramKeyEvent, this.mKeyEventCallback, this.mDispatcherState, this);
  }
  
  public int getBufferPercentage()
  {
    return this.mCallbacks.onGetBufferPercentage();
  }
  
  public long getCurrentPosition()
  {
    return this.mCallbacks.onGetCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.mCallbacks.onGetDuration();
  }
  
  public Object getRemoteControlClient()
  {
    if (this.mController != null) {}
    for (Object localObject = this.mController.getRemoteControlClient();; localObject = null) {
      return localObject;
    }
  }
  
  public int getTransportControlFlags()
  {
    return this.mCallbacks.onGetTransportControlFlags();
  }
  
  public boolean isPlaying()
  {
    return this.mCallbacks.onIsPlaying();
  }
  
  public void pausePlaying()
  {
    if (this.mController != null) {
      this.mController.pausePlaying();
    }
    this.mCallbacks.onPause();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void refreshState()
  {
    pushControllerState();
    reportPlayingChanged();
    reportTransportControlsChanged();
  }
  
  public void registerStateListener(TransportStateListener paramTransportStateListener)
  {
    this.mListeners.add(paramTransportStateListener);
  }
  
  public void seekTo(long paramLong)
  {
    this.mCallbacks.onSeekTo(paramLong);
  }
  
  public void startPlaying()
  {
    if (this.mController != null) {
      this.mController.startPlaying();
    }
    this.mCallbacks.onStart();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void stopPlaying()
  {
    if (this.mController != null) {
      this.mController.stopPlaying();
    }
    this.mCallbacks.onStop();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void unregisterStateListener(TransportStateListener paramTransportStateListener)
  {
    this.mListeners.remove(paramTransportStateListener);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator
 * JD-Core Version:    0.7.0.1
 */