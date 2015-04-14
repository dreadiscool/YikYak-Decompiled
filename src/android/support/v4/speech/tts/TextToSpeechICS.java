package android.support.v4.speech.tts;

import android.content.Context;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

class TextToSpeechICS
{
  private static final String TAG = "android.support.v4.speech.tts";
  
  static TextToSpeech construct(Context paramContext, TextToSpeech.OnInitListener paramOnInitListener, String paramString)
  {
    TextToSpeech localTextToSpeech;
    if (Build.VERSION.SDK_INT < 14) {
      if (paramString == null) {
        localTextToSpeech = new TextToSpeech(paramContext, paramOnInitListener);
      }
    }
    for (;;)
    {
      return localTextToSpeech;
      localTextToSpeech = new TextToSpeech(paramContext, paramOnInitListener);
      continue;
      localTextToSpeech = new TextToSpeech(paramContext, paramOnInitListener, paramString);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.speech.tts.TextToSpeechICS
 * JD-Core Version:    0.7.0.1
 */