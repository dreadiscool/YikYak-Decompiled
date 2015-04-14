package com.facebook.model;

public abstract interface GraphLocation
  extends GraphObject
{
  public abstract String getCity();
  
  public abstract String getCountry();
  
  public abstract double getLatitude();
  
  public abstract double getLongitude();
  
  public abstract String getState();
  
  public abstract String getStreet();
  
  public abstract String getZip();
  
  public abstract void setCity(String paramString);
  
  public abstract void setCountry(String paramString);
  
  public abstract void setLatitude(double paramDouble);
  
  public abstract void setLongitude(double paramDouble);
  
  public abstract void setState(String paramString);
  
  public abstract void setStreet(String paramString);
  
  public abstract void setZip(String paramString);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphLocation
 * JD-Core Version:    0.7.0.1
 */