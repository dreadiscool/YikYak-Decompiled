package com.yik.yak.ui.view;

import Hj;
import Hk;
import Hn;
import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.util.AttributeSet;
import android.util.Patterns;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkDetectingEditText
  extends EditText
{
  private Hk a;
  private ArrayList<Hn> b = new ArrayList();
  private boolean c = false;
  
  public LinkDetectingEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LinkDetectingEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LinkDetectingEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a(String paramString, String[] paramArrayOfString, Matcher paramMatcher, Linkify.TransformFilter paramTransformFilter)
  {
    boolean bool = true;
    if (paramTransformFilter != null) {}
    for (String str1 = paramTransformFilter.transformUrl(paramMatcher, paramString);; str1 = paramString)
    {
      int i = 0;
      if (i < paramArrayOfString.length) {
        if (str1.regionMatches(bool, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
        {
          String str2 = paramArrayOfString[i];
          int j = paramArrayOfString[i].length();
          if (!str1.regionMatches(false, 0, str2, 0, j)) {
            str1 = paramArrayOfString[i] + str1.substring(paramArrayOfString[i].length());
          }
        }
      }
      for (;;)
      {
        if (!bool) {
          str1 = paramArrayOfString[0] + str1;
        }
        return str1;
        i++;
        break;
        bool = false;
      }
    }
  }
  
  private void a(ArrayList<Hn> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    Matcher localMatcher = paramPattern.matcher(paramSpannable);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        Hn localHn = new Hn();
        localHn.a = a(localMatcher.group(0), paramArrayOfString, localMatcher, paramTransformFilter);
        localHn.b = i;
        localHn.c = j;
        paramArrayList.add(localHn);
      }
    }
  }
  
  private void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  private void d()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  private void e()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    Editable localEditable = getText();
    Pattern localPattern = Patterns.WEB_URL;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "http://";
    arrayOfString[1] = "https://";
    arrayOfString[2] = "rtsp://";
    a(localArrayList, localEditable, localPattern, arrayOfString, Linkify.sUrlMatchFilter, null);
    if (localArrayList.size() > 1) {
      c();
    }
    for (;;)
    {
      this.b = localArrayList;
      return;
      if (localArrayList.size() == 1) {
        d();
      } else {
        e();
      }
    }
  }
  
  public void a()
  {
    setAutoLinkMask(1);
    addTextChangedListener(new Hj(this));
  }
  
  public boolean b()
  {
    int i = 1;
    if (this.b.size() > i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public void setLinksEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnLinkAddedOrEditedListener(Hk paramHk)
  {
    this.a = paramHk;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.LinkDetectingEditText
 * JD-Core Version:    0.7.0.1
 */