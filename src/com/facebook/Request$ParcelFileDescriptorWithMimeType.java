package com.facebook;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Request$ParcelFileDescriptorWithMimeType
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelFileDescriptorWithMimeType> CREATOR = new Request.ParcelFileDescriptorWithMimeType.1();
  private final ParcelFileDescriptor fileDescriptor;
  private final String mimeType;
  
  private Request$ParcelFileDescriptorWithMimeType(Parcel paramParcel)
  {
    this.mimeType = paramParcel.readString();
    this.fileDescriptor = paramParcel.readFileDescriptor();
  }
  
  public Request$ParcelFileDescriptorWithMimeType(ParcelFileDescriptor paramParcelFileDescriptor, String paramString)
  {
    this.mimeType = paramString;
    this.fileDescriptor = paramParcelFileDescriptor;
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public ParcelFileDescriptor getFileDescriptor()
  {
    return this.fileDescriptor;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeFileDescriptor(this.fileDescriptor.getFileDescriptor());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.ParcelFileDescriptorWithMimeType
 * JD-Core Version:    0.7.0.1
 */