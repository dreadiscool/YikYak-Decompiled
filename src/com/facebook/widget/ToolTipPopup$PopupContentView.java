package com.facebook.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;

class ToolTipPopup$PopupContentView
  extends FrameLayout
{
  private View bodyFrame;
  private ImageView bottomArrow;
  private ImageView topArrow;
  private ImageView xOut;
  
  public ToolTipPopup$PopupContentView(ToolTipPopup paramToolTipPopup, Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
    this.topArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer));
    this.bottomArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer));
    this.bodyFrame = findViewById(R.id.com_facebook_body_frame);
    this.xOut = ((ImageView)findViewById(R.id.com_facebook_button_xout));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void showBottomArrow()
  {
    this.topArrow.setVisibility(4);
    this.bottomArrow.setVisibility(0);
  }
  
  public void showTopArrow()
  {
    this.topArrow.setVisibility(0);
    this.bottomArrow.setVisibility(4);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.ToolTipPopup.PopupContentView
 * JD-Core Version:    0.7.0.1
 */