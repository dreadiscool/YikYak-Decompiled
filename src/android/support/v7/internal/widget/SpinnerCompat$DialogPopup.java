package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;

class SpinnerCompat$DialogPopup
  implements DialogInterface.OnClickListener, SpinnerCompat.SpinnerPopup
{
  private ListAdapter mListAdapter;
  private AlertDialog mPopup;
  private CharSequence mPrompt;
  
  private SpinnerCompat$DialogPopup(SpinnerCompat paramSpinnerCompat) {}
  
  public void dismiss()
  {
    if (this.mPopup != null)
    {
      this.mPopup.dismiss();
      this.mPopup = null;
    }
  }
  
  public Drawable getBackground()
  {
    return null;
  }
  
  public CharSequence getHintText()
  {
    return this.mPrompt;
  }
  
  public int getHorizontalOffset()
  {
    return 0;
  }
  
  public int getVerticalOffset()
  {
    return 0;
  }
  
  public boolean isShowing()
  {
    if (this.mPopup != null) {}
    for (boolean bool = this.mPopup.isShowing();; bool = false) {
      return bool;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.setSelection(paramInt);
    if (this.this$0.mOnItemClickListener != null) {
      this.this$0.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
    }
    dismiss();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.mListAdapter = paramListAdapter;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setHorizontalOffset(int paramInt) {}
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mPrompt = paramCharSequence;
  }
  
  public void setVerticalOffset(int paramInt) {}
  
  public void show()
  {
    if (this.mListAdapter == null) {}
    for (;;)
    {
      return;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.this$0.getContext());
      if (this.mPrompt != null) {
        localBuilder.setTitle(this.mPrompt);
      }
      this.mPopup = localBuilder.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
      this.mPopup.show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DialogPopup
 * JD-Core Version:    0.7.0.1
 */