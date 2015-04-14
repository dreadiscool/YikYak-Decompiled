import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;

class uA
  implements Runnable
{
  uA(uy paramuy) {}
  
  public void run()
  {
    uy.b(this.a).setVisibility(0);
    uy.b(this.a).setBackgroundColor(uy.c(this.a).b());
    uy.b(this.a).setOnTouchListener(new uB(this));
    ImageView localImageView = (ImageView)uy.b(this.a).findViewById(tn.com_mixpanel_android_notification_image);
    float f = TypedValue.applyDimension(1, 75.0F, uy.e(this.a).getResources().getDisplayMetrics());
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(200L);
    uy.b(this.a).startAnimation(localTranslateAnimation);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, f / 2.0F, f / 2.0F);
    localScaleAnimation.setInterpolator(new uD(this.a));
    localScaleAnimation.setDuration(400L);
    localScaleAnimation.setStartOffset(200L);
    localImageView.startAnimation(localScaleAnimation);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uA
 * JD-Core Version:    0.7.0.1
 */