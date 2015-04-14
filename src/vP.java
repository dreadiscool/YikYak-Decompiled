import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mixpanel.android.surveys.SurveyChoiceView;

public class vP
  extends Animation
{
  private vP(SurveyChoiceView paramSurveyChoiceView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = 0.0F;
    float f2 = 1.0F;
    if (paramFloat <= 0.5F) {
      f1 = paramFloat - 0.5F;
    }
    for (;;)
    {
      SurveyChoiceView.a(this.a, f1);
      SurveyChoiceView.b(this.a, f2);
      this.a.requestLayout();
      return;
      f2 += 2.0F * (paramFloat - 0.5F);
    }
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vP
 * JD-Core Version:    0.7.0.1
 */