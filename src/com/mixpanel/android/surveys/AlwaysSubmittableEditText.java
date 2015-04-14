package com.mixpanel.android.surveys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class AlwaysSubmittableEditText
  extends EditText
{
  public AlwaysSubmittableEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlwaysSubmittableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlwaysSubmittableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo.imeOptions = (0xBFFFFFFF & paramEditorInfo.imeOptions);
    return localInputConnection;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.AlwaysSubmittableEditText
 * JD-Core Version:    0.7.0.1
 */