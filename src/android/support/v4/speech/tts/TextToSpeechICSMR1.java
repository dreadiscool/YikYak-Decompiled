package android.support.v4.speech.tts;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
import java.util.Set;

class TextToSpeechICSMR1
{
  public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
  public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
  
  static Set<String> getFeatures(TextToSpeech paramTextToSpeech, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 15) {}
    for (Set localSet = paramTextToSpeech.getFeatures(paramLocale);; localSet = null) {
      return localSet;
    }
  }
  
  static void setUtteranceProgressListener(TextToSpeech paramTextToSpeech, TextToSpeechICSMR1.UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      paramTextToSpeech.setOnUtteranceProgressListener(new TextToSpeechICSMR1.1(paramUtteranceProgressListenerICSMR1));
    }
    for (;;)
    {
      return;
      paramTextToSpeech.setOnUtteranceCompletedListener(new TextToSpeechICSMR1.2(paramUtteranceProgressListenerICSMR1));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.speech.tts.TextToSpeechICSMR1
 * JD-Core Version:    0.7.0.1
 */