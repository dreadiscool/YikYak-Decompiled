package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;

class RemoteInputCompatApi20
{
  static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    RemoteInput.addResultsToIntent(fromCompat(paramArrayOfRemoteInput), paramIntent, paramBundle);
  }
  
  static RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {}
    RemoteInput[] arrayOfRemoteInput;
    for (Object localObject = null;; localObject = arrayOfRemoteInput)
    {
      return localObject;
      arrayOfRemoteInput = new RemoteInput[paramArrayOfRemoteInput.length];
      for (int i = 0; i < paramArrayOfRemoteInput.length; i++)
      {
        RemoteInputCompatBase.RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
        arrayOfRemoteInput[i] = new RemoteInput.Builder(localRemoteInput.getResultKey()).setLabel(localRemoteInput.getLabel()).setChoices(localRemoteInput.getChoices()).setAllowFreeFormInput(localRemoteInput.getAllowFreeFormInput()).addExtras(localRemoteInput.getExtras()).build();
      }
    }
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return RemoteInput.getResultsFromIntent(paramIntent);
  }
  
  static RemoteInputCompatBase.RemoteInput[] toCompat(RemoteInput[] paramArrayOfRemoteInput, RemoteInputCompatBase.RemoteInput.Factory paramFactory)
  {
    if (paramArrayOfRemoteInput == null) {}
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput;
    for (Object localObject = null;; localObject = arrayOfRemoteInput)
    {
      return localObject;
      arrayOfRemoteInput = paramFactory.newArray(paramArrayOfRemoteInput.length);
      for (int i = 0; i < paramArrayOfRemoteInput.length; i++)
      {
        RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
        arrayOfRemoteInput[i] = paramFactory.build(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInputCompatApi20
 * JD-Core Version:    0.7.0.1
 */