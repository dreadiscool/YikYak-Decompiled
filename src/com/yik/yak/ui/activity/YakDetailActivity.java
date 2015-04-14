package com.yik.yak.ui.activity;

import CK;
import Ik;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.yik.yak.ui.fragment.CommentFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class YakDetailActivity
  extends FragmentContainerActivity
{
  protected Fragment a()
  {
    boolean bool1 = getIntent().getBooleanExtra("canSubmit", false);
    boolean bool2 = getIntent().getBooleanExtra("canVote", false);
    boolean bool3 = getIntent().getBooleanExtra("canReply", false);
    boolean bool4 = getIntent().getBooleanExtra("canReport", false);
    String str1 = getIntent().getStringExtra("caller");
    if (Ik.a(str1)) {}
    for (String str2 = "MainFeed";; str2 = str1) {
      try
      {
        localCK = new CK(new JSONObject(getIntent().getStringExtra("yak")), bool2, bool3, bool4, this, 0);
        return CommentFragment.a(localCK, bool1, bool2, bool3, bool4, str2);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          CK localCK = null;
        }
      }
    }
  }
  
  protected String b()
  {
    return "Yak";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.YakDetailActivity
 * JD-Core Version:    0.7.0.1
 */