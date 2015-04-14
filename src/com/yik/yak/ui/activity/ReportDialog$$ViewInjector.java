package com.yik.yak.ui.activity;

import DE;
import DF;
import DG;
import DH;
import android.view.View;
import android.widget.CheckBox;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ReportDialog$$ViewInjector<T extends ReportDialog>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    paramT.blockYakkerCheckBox = ((CheckBox)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558623, "field 'blockYakkerCheckBox'"), 2131558623, "field 'blockYakkerCheckBox'"));
    ((View)paramFinder.findRequiredView(paramObject, 2131558615, "method 'onReportClick'")).setOnClickListener(new DE(this, paramT));
    ((View)paramFinder.findRequiredView(paramObject, 2131558617, "method 'onReportClick'")).setOnClickListener(new DF(this, paramT));
    ((View)paramFinder.findRequiredView(paramObject, 2131558619, "method 'onReportClick'")).setOnClickListener(new DG(this, paramT));
    ((View)paramFinder.findRequiredView(paramObject, 2131558621, "method 'onReportClick'")).setOnClickListener(new DH(this, paramT));
  }
  
  public void reset(T paramT)
  {
    paramT.blockYakkerCheckBox = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.ReportDialog..ViewInjector
 * JD-Core Version:    0.7.0.1
 */