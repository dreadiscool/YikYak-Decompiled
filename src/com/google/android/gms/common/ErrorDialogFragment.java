package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import hZ;

public class ErrorDialogFragment
  extends DialogFragment
{
  private DialogInterface.OnCancelListener Iw = null;
  private Dialog mDialog = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog)
  {
    return newInstance(paramDialog, null);
  }
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ErrorDialogFragment localErrorDialogFragment = new ErrorDialogFragment();
    Dialog localDialog = (Dialog)hZ.a(paramDialog, "Cannot display null dialog");
    localDialog.setOnCancelListener(null);
    localDialog.setOnDismissListener(null);
    localErrorDialogFragment.mDialog = localDialog;
    if (paramOnCancelListener != null) {
      localErrorDialogFragment.Iw = paramOnCancelListener;
    }
    return localErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.Iw != null) {
      this.Iw.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (this.mDialog == null) {
      setShowsDialog(false);
    }
    return this.mDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.ErrorDialogFragment
 * JD-Core Version:    0.7.0.1
 */