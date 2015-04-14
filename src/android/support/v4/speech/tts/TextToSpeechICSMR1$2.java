package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;

final class TextToSpeechICSMR1$2
  implements TextToSpeech.OnUtteranceCompletedListener
{
  TextToSpeechICSMR1$2(TextToSpeechICSMR1.UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1) {}
  
  public void onUtteranceCompleted(String paramString)
  {
    this.val$listener.onStart(paramString);
    this.val$listener.onDone(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.speech.tts.TextToSpeechICSMR1.2
 * JD-Core Version:    0.7.0.1
 */