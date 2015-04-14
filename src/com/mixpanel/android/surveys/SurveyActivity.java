package com.mixpanel.android.surveys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import tl;
import tm;
import tn;
import to;
import uJ;
import uR;
import vB;
import vH;
import vI;
import vJ;
import vK;
import vL;
import vM;
import vN;
import vm;
import vn;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class SurveyActivity
  extends Activity
{
  private static final int k = Color.argb(255, 90, 90, 90);
  private AlertDialog a;
  private CardCarouselLayout b;
  private MixpanelAPI c;
  private View d;
  private View e;
  private TextView f;
  private UpdateDisplayState g;
  private boolean h = false;
  private int i = 0;
  private int j = -1;
  
  private void a()
  {
    if (this.h) {}
    for (;;)
    {
      return;
      if (!uJ.a(this).h()) {
        f();
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("We'd love your feedback!");
      localBuilder.setMessage("Mind taking a quick survey?");
      localBuilder.setPositiveButton("Sure", new vM(this));
      localBuilder.setNegativeButton("No, Thanks", new vN(this));
      localBuilder.setCancelable(false);
      this.a = localBuilder.create();
      this.a.show();
    }
  }
  
  private void a(int paramInt)
  {
    UpdateDisplayState.DisplayState.SurveyState localSurveyState = c();
    List localList = localSurveyState.d().d();
    if ((paramInt == 0) || (localList.size() == 0)) {
      this.d.setEnabled(false);
    }
    for (;;)
    {
      label55:
      int m;
      vm localvm;
      String str;
      if (paramInt >= -1 + localList.size())
      {
        this.e.setEnabled(false);
        m = this.i;
        this.i = paramInt;
        localvm = (vm)localList.get(paramInt);
        str = localSurveyState.c().a(Integer.valueOf(localvm.a()));
        if (m >= paramInt) {
          break label190;
        }
      }
      try
      {
        this.b.a(localvm, str, vB.a);
        for (;;)
        {
          if (localList.size() <= 1) {
            break label236;
          }
          this.f.setText("" + (paramInt + 1) + " of " + localList.size());
          return;
          this.d.setEnabled(true);
          break;
          this.e.setEnabled(true);
          break label55;
          label190:
          if (m <= paramInt) {
            break label222;
          }
          this.b.a(localvm, str, vB.b);
        }
      }
      catch (vH localvH)
      {
        for (;;)
        {
          goToNextQuestion();
          continue;
          label222:
          this.b.a(localvm, str);
          continue;
          label236:
          this.f.setText("");
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    setContentView(to.com_mixpanel_android_activity_notification_full);
    ImageView localImageView = (ImageView)findViewById(tn.com_mixpanel_android_notification_gradient);
    FadingImageView localFadingImageView = (FadingImageView)findViewById(tn.com_mixpanel_android_notification_image);
    TextView localTextView1 = (TextView)findViewById(tn.com_mixpanel_android_notification_title);
    TextView localTextView2 = (TextView)findViewById(tn.com_mixpanel_android_notification_subtext);
    Button localButton = (Button)findViewById(tn.com_mixpanel_android_notification_button);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(tn.com_mixpanel_android_button_exit_wrapper);
    InAppNotification localInAppNotification = ((UpdateDisplayState.DisplayState.InAppNotificationState)this.g.c()).c();
    Display localDisplay = getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    if (getResources().getConfiguration().orientation == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.setMargins(0, 0, 0, (int)(0.06F * localPoint.y));
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
    GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = -446668676;
    arrayOfInt[1] = -448247715;
    arrayOfInt[2] = -451405793;
    arrayOfInt[3] = -451405793;
    GradientDrawable localGradientDrawable = new GradientDrawable(localOrientation, arrayOfInt);
    localGradientDrawable.setGradientType(1);
    Bitmap localBitmap;
    if (getResources().getConfiguration().orientation == 2)
    {
      localGradientDrawable.setGradientCenter(0.25F, 0.5F);
      localGradientDrawable.setGradientRadius(0.8F * Math.min(localPoint.x, localPoint.y));
      a(localImageView, localGradientDrawable);
      localTextView1.setText(localInAppNotification.e());
      localTextView2.setText(localInAppNotification.f());
      localBitmap = localInAppNotification.k();
      localFadingImageView.setBackgroundResource(tm.com_mixpanel_android_square_dropshadow);
      if ((localBitmap.getWidth() >= 100) && (localBitmap.getHeight() >= 100)) {
        break label566;
      }
      localFadingImageView.setBackgroundResource(tm.com_mixpanel_android_square_nodropshadow);
    }
    for (;;)
    {
      localFadingImageView.setImageBitmap(localBitmap);
      String str = localInAppNotification.j();
      if ((str != null) && (str.length() > 0)) {
        localButton.setText(localInAppNotification.i());
      }
      localButton.setOnClickListener(new vI(this, localInAppNotification));
      localButton.setOnTouchListener(new vJ(this));
      localLinearLayout.setOnClickListener(new vK(this));
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 1.0F);
      localScaleAnimation.setDuration(200L);
      localFadingImageView.startAnimation(localScaleAnimation);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.5F, 1, 0.0F);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localTranslateAnimation.setDuration(200L);
      localTextView1.startAnimation(localTranslateAnimation);
      localTextView2.startAnimation(localTranslateAnimation);
      localButton.startAnimation(localTranslateAnimation);
      localLinearLayout.startAnimation(AnimationUtils.loadAnimation(this, tl.com_mixpanel_android_fade_in));
      return;
      localGradientDrawable.setGradientCenter(0.5F, 0.33F);
      localGradientDrawable.setGradientRadius(0.7F * Math.min(localPoint.x, localPoint.y));
      break;
      label566:
      if (Color.alpha(Bitmap.createScaledBitmap(localBitmap, 1, 1, false).getPixel(0, 0)) < 255) {
        localFadingImageView.setBackgroundResource(tm.com_mixpanel_android_square_nodropshadow);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 16) {
      paramView.setBackgroundDrawable(paramDrawable);
    }
    for (;;)
    {
      return;
      paramView.setBackground(paramDrawable);
    }
  }
  
  private void a(vm paramvm, String paramString)
  {
    c().c().a(Integer.valueOf(paramvm.a()), paramString.toString());
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void b()
  {
    if (this.c != null)
    {
      if (this.g != null)
      {
        UpdateDisplayState.DisplayState.SurveyState localSurveyState = c();
        Survey localSurvey = localSurveyState.d();
        List localList = localSurvey.d();
        String str1 = this.g.d();
        uR localuR = this.c.getPeople().b(str1);
        localuR.a("$responses", Integer.valueOf(localSurvey.c()));
        UpdateDisplayState.AnswerMap localAnswerMap = localSurveyState.c();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          vm localvm = (vm)localIterator.next();
          String str2 = localAnswerMap.a(Integer.valueOf(localvm.a()));
          if (str2 != null) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("$survey_id", localSurvey.b());
              localJSONObject.put("$collection_id", localSurvey.c());
              localJSONObject.put("$question_id", localvm.a());
              localJSONObject.put("$question_type", localvm.d().toString());
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
              localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
              localJSONObject.put("$time", localSimpleDateFormat.format(new Date()));
              localJSONObject.put("$value", str2);
              localuR.a("$answers", localJSONObject);
            }
            catch (JSONException localJSONException) {}
          }
        }
      }
      this.c.flush();
    }
    UpdateDisplayState.a(this.j);
  }
  
  private void b(Bundle paramBundle)
  {
    g();
    if (paramBundle != null)
    {
      this.i = paramBundle.getInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", 0);
      this.h = paramBundle.getBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY");
    }
    if (this.g.d() == null)
    {
      finish();
      return;
    }
    setContentView(to.com_mixpanel_android_activity_survey);
    Bitmap localBitmap = c().b();
    if (localBitmap == null) {
      findViewById(tn.com_mixpanel_android_activity_survey_id).setBackgroundColor(k);
    }
    for (;;)
    {
      this.d = findViewById(tn.com_mixpanel_android_button_previous);
      this.e = findViewById(tn.com_mixpanel_android_button_next);
      this.f = ((TextView)findViewById(tn.com_mixpanel_android_progress_text));
      this.b = ((CardCarouselLayout)findViewById(tn.com_mixpanel_android_question_card_holder));
      this.b.setOnQuestionAnsweredListener(new vL(this));
      break;
      getWindow().setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
    }
  }
  
  private UpdateDisplayState.DisplayState.SurveyState c()
  {
    return (UpdateDisplayState.DisplayState.SurveyState)this.g.c();
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY", this.h);
    paramBundle.putInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", this.i);
    paramBundle.putParcelable("com.mixpanel.android.surveys.SurveyActivity.SURVEY_STATE_BUNDLE_KEY", this.g);
  }
  
  private void completeSurvey()
  {
    finish();
  }
  
  private boolean d()
  {
    if (this.g == null) {}
    for (boolean bool = false;; bool = "SurveyState".equals(this.g.c().a())) {
      return bool;
    }
  }
  
  private boolean e()
  {
    if (this.g == null) {}
    for (boolean bool = false;; bool = "InAppNotificationState".equals(this.g.c().a())) {
      return bool;
    }
  }
  
  private void f()
  {
    Survey localSurvey = c().d();
    uR localuR = this.c.getPeople().b(this.g.d());
    localuR.a("$surveys", Integer.valueOf(localSurvey.b()));
    localuR.a("$collections", Integer.valueOf(localSurvey.c()));
  }
  
  @SuppressLint({"NewApi"})
  private void g()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      setRequestedOrientation(14);
    }
    for (;;)
    {
      return;
      int m = getResources().getConfiguration().orientation;
      if (m == 2) {
        setRequestedOrientation(0);
      } else if (m == 1) {
        setRequestedOrientation(1);
      }
    }
  }
  
  private void goToNextQuestion()
  {
    int m = c().d().d().size();
    if (this.i < m - 1) {
      a(1 + this.i);
    }
    for (;;)
    {
      return;
      completeSurvey();
    }
  }
  
  private void goToPreviousQuestion()
  {
    if (this.i > 0) {
      a(-1 + this.i);
    }
    for (;;)
    {
      return;
      completeSurvey();
    }
  }
  
  public void completeSurvey(View paramView)
  {
    completeSurvey();
  }
  
  public void goToNextQuestion(View paramView)
  {
    goToNextQuestion();
  }
  
  public void goToPreviousQuestion(View paramView)
  {
    goToPreviousQuestion();
  }
  
  public void onBackPressed()
  {
    if ((d()) && (this.i > 0)) {
      goToPreviousQuestion();
    }
    for (;;)
    {
      return;
      if (e()) {
        UpdateDisplayState.a(this.j);
      }
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = getIntent().getIntExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", 2147483647);
    this.g = UpdateDisplayState.b(this.j);
    if (this.g == null) {
      finish();
    }
    for (;;)
    {
      return;
      this.c = MixpanelAPI.getInstance(this, this.g.e());
      if (e()) {
        a(paramBundle);
      } else if (d()) {
        b(paramBundle);
      } else {
        finish();
      }
    }
  }
  
  protected void onDestroy()
  {
    if (d()) {
      b();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null)
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (d()) {
      c(paramBundle);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    UpdateDisplayState.DisplayState localDisplayState = this.g.c();
    if ((localDisplayState != null) && (localDisplayState.a() == "SurveyState")) {
      a();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.SurveyActivity
 * JD-Core Version:    0.7.0.1
 */