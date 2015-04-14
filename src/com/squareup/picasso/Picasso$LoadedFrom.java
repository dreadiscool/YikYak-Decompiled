package com.squareup.picasso;

public enum Picasso$LoadedFrom
{
  final int debugColor;
  
  static
  {
    DISK = new LoadedFrom("DISK", 1, -256);
    NETWORK = new LoadedFrom("NETWORK", 2, -65536);
    LoadedFrom[] arrayOfLoadedFrom = new LoadedFrom[3];
    arrayOfLoadedFrom[0] = MEMORY;
    arrayOfLoadedFrom[1] = DISK;
    arrayOfLoadedFrom[2] = NETWORK;
    $VALUES = arrayOfLoadedFrom;
  }
  
  private Picasso$LoadedFrom(int paramInt)
  {
    this.debugColor = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.LoadedFrom
 * JD-Core Version:    0.7.0.1
 */