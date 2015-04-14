package com.facebook.widget;

public enum FriendPickerFragment$FriendPickerType
{
  private final boolean requestIsCacheable;
  private final String requestPath;
  
  static
  {
    INVITABLE_FRIENDS = new FriendPickerType("INVITABLE_FRIENDS", 2, "/invitable_friends", false);
    FriendPickerType[] arrayOfFriendPickerType = new FriendPickerType[3];
    arrayOfFriendPickerType[0] = FRIENDS;
    arrayOfFriendPickerType[1] = TAGGABLE_FRIENDS;
    arrayOfFriendPickerType[2] = INVITABLE_FRIENDS;
    $VALUES = arrayOfFriendPickerType;
  }
  
  private FriendPickerFragment$FriendPickerType(String paramString, boolean paramBoolean)
  {
    this.requestPath = paramString;
    this.requestIsCacheable = paramBoolean;
  }
  
  String getRequestPath()
  {
    return this.requestPath;
  }
  
  boolean isCacheable()
  {
    return this.requestIsCacheable;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FriendPickerFragment.FriendPickerType
 * JD-Core Version:    0.7.0.1
 */