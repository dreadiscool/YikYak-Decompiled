package com.yik.yak.ui.adapter.viewholder;

import Ct;
import EN;
import EV;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShareCardViewHolder
  extends EV<Ct>
{
  @InjectView(2131558484)
  protected ImageView imgShareCard;
  @InjectView(2131558753)
  protected TextView txtShareCardCaption;
  
  public ShareCardViewHolder(EN paramEN, View paramView)
  {
    super(paramEN, paramView);
    ButterKnife.inject(this, paramView);
  }
  
  public void onBindView(Ct paramCt)
  {
    this.imgShareCard.setBackgroundColor(paramCt.c());
    this.imgShareCard.setImageDrawable(paramCt.b());
    this.txtShareCardCaption.setText(paramCt.a());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.viewholder.ShareCardViewHolder
 * JD-Core Version:    0.7.0.1
 */