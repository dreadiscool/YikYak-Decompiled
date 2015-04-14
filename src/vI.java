import android.view.View.OnClickListener;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.surveys.SurveyActivity;

public class vI
  implements View.OnClickListener
{
  public vI(SurveyActivity paramSurveyActivity, InAppNotification paramInAppNotification) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	vI:a	Lcom/mixpanel/android/mpmetrics/InAppNotification;
    //   4: invokevirtual 31	com/mixpanel/android/mpmetrics/InAppNotification:j	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +59 -> 68
    //   12: aload_2
    //   13: invokevirtual 37	java/lang/String:length	()I
    //   16: ifle +52 -> 68
    //   19: aload_2
    //   20: invokestatic 43	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore 4
    //   25: new 45	android/content/Intent
    //   28: dup
    //   29: ldc 47
    //   31: aload 4
    //   33: invokespecial 50	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   36: astore 5
    //   38: aload_0
    //   39: getfield 14	vI:b	Lcom/mixpanel/android/surveys/SurveyActivity;
    //   42: aload 5
    //   44: invokevirtual 56	com/mixpanel/android/surveys/SurveyActivity:startActivity	(Landroid/content/Intent;)V
    //   47: aload_0
    //   48: getfield 14	vI:b	Lcom/mixpanel/android/surveys/SurveyActivity;
    //   51: invokestatic 59	com/mixpanel/android/surveys/SurveyActivity:a	(Lcom/mixpanel/android/surveys/SurveyActivity;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    //   54: invokevirtual 65	com/mixpanel/android/mpmetrics/MixpanelAPI:getPeople	()LuR;
    //   57: ldc 67
    //   59: aload_0
    //   60: getfield 16	vI:a	Lcom/mixpanel/android/mpmetrics/InAppNotification;
    //   63: invokeinterface 72 3 0
    //   68: aload_0
    //   69: getfield 14	vI:b	Lcom/mixpanel/android/surveys/SurveyActivity;
    //   72: invokevirtual 75	com/mixpanel/android/surveys/SurveyActivity:finish	()V
    //   75: aload_0
    //   76: getfield 14	vI:b	Lcom/mixpanel/android/surveys/SurveyActivity;
    //   79: invokestatic 78	com/mixpanel/android/surveys/SurveyActivity:b	(Lcom/mixpanel/android/surveys/SurveyActivity;)I
    //   82: invokestatic 83	com/mixpanel/android/mpmetrics/UpdateDisplayState:a	(I)V
    //   85: return
    //   86: astore_3
    //   87: goto -2 -> 85
    //   90: astore 6
    //   92: goto -24 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	vI
    //   0	95	1	paramView	android.view.View
    //   7	13	2	str	java.lang.String
    //   86	1	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   23	9	4	localUri	android.net.Uri
    //   36	7	5	localIntent	android.content.Intent
    //   90	1	6	localActivityNotFoundException	android.content.ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   19	25	86	java/lang/IllegalArgumentException
    //   25	68	90	android/content/ActivityNotFoundException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vI
 * JD-Core Version:    0.7.0.1
 */