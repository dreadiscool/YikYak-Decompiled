package com.facebook.widget;

import android.content.Context;
import com.facebook.android.R.drawable;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.model.GraphPlace;

class PlacePickerFragment$1
  extends PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace>
{
  PlacePickerFragment$1(PlacePickerFragment paramPlacePickerFragment, Context paramContext)
  {
    super(paramPlacePickerFragment, paramContext);
  }
  
  protected int getDefaultPicture()
  {
    return R.drawable.com_facebook_place_default_icon;
  }
  
  protected int getGraphObjectRowLayoutId(GraphPlace paramGraphPlace)
  {
    return R.layout.com_facebook_placepickerfragment_list_row;
  }
  
  protected CharSequence getSubTitleOfGraphObject(GraphPlace paramGraphPlace)
  {
    String str1 = paramGraphPlace.getCategory();
    Integer localInteger = (Integer)paramGraphPlace.getProperty("were_here_count");
    String str2;
    if ((str1 != null) && (localInteger != null))
    {
      PlacePickerFragment localPlacePickerFragment3 = this.this$0;
      int k = R.string.com_facebook_placepicker_subtitle_format;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = str1;
      arrayOfObject3[1] = localInteger;
      str2 = localPlacePickerFragment3.getString(k, arrayOfObject3);
    }
    for (;;)
    {
      return str2;
      if ((str1 == null) && (localInteger != null))
      {
        PlacePickerFragment localPlacePickerFragment2 = this.this$0;
        int j = R.string.com_facebook_placepicker_subtitle_were_here_only_format;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localInteger;
        str2 = localPlacePickerFragment2.getString(j, arrayOfObject2);
      }
      else if ((str1 != null) && (localInteger == null))
      {
        PlacePickerFragment localPlacePickerFragment1 = this.this$0;
        int i = R.string.com_facebook_placepicker_subtitle_catetory_only_format;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = str1;
        str2 = localPlacePickerFragment1.getString(i, arrayOfObject1);
      }
      else
      {
        str2 = null;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment.1
 * JD-Core Version:    0.7.0.1
 */