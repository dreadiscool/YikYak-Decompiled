package com.facebook.widget;

import android.content.Context;
import com.facebook.android.R.drawable;
import com.facebook.android.R.layout;
import com.facebook.model.GraphUser;

class FriendPickerFragment$1
  extends PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser>
{
  FriendPickerFragment$1(FriendPickerFragment paramFriendPickerFragment, Context paramContext)
  {
    super(paramFriendPickerFragment, paramContext);
  }
  
  protected int getDefaultPicture()
  {
    return R.drawable.com_facebook_profile_default_icon;
  }
  
  protected int getGraphObjectRowLayoutId(GraphUser paramGraphUser)
  {
    return R.layout.com_facebook_picker_list_row;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FriendPickerFragment.1
 * JD-Core Version:    0.7.0.1
 */