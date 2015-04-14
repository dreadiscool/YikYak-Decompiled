package com.squareup.picasso;

public abstract interface Picasso$RequestTransformer
{
  public static final RequestTransformer IDENTITY = new Picasso.RequestTransformer.1();
  
  public abstract Request transformRequest(Request paramRequest);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.RequestTransformer
 * JD-Core Version:    0.7.0.1
 */