package com.facebook;

public enum FacebookRequestError$Category
{
  static
  {
    AUTHENTICATION_REOPEN_SESSION = new Category("AUTHENTICATION_REOPEN_SESSION", 1);
    PERMISSION = new Category("PERMISSION", 2);
    SERVER = new Category("SERVER", 3);
    THROTTLING = new Category("THROTTLING", 4);
    OTHER = new Category("OTHER", 5);
    BAD_REQUEST = new Category("BAD_REQUEST", 6);
    CLIENT = new Category("CLIENT", 7);
    Category[] arrayOfCategory = new Category[8];
    arrayOfCategory[0] = AUTHENTICATION_RETRY;
    arrayOfCategory[1] = AUTHENTICATION_REOPEN_SESSION;
    arrayOfCategory[2] = PERMISSION;
    arrayOfCategory[3] = SERVER;
    arrayOfCategory[4] = THROTTLING;
    arrayOfCategory[5] = OTHER;
    arrayOfCategory[6] = BAD_REQUEST;
    arrayOfCategory[7] = CLIENT;
    $VALUES = arrayOfCategory;
  }
  
  private FacebookRequestError$Category() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.FacebookRequestError.Category
 * JD-Core Version:    0.7.0.1
 */