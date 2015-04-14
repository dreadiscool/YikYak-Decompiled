package com.parse;

import java.lang.ref.WeakReference;

class ParseACL$UserResolutionListener
  extends GetCallback<ParseObject>
{
  private final WeakReference<ParseACL> parent;
  
  public ParseACL$UserResolutionListener(ParseACL paramParseACL)
  {
    this.parent = new WeakReference(paramParseACL);
  }
  
  public void done(ParseObject paramParseObject, ParseException paramParseException)
  {
    try
    {
      ParseACL localParseACL = (ParseACL)this.parent.get();
      if (localParseACL != null) {
        ParseACL.access$000(localParseACL, (ParseUser)paramParseObject);
      }
      return;
    }
    finally
    {
      paramParseObject.unregisterSaveListener(this);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseACL.UserResolutionListener
 * JD-Core Version:    0.7.0.1
 */