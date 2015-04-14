package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;

@TargetApi(14)
class ContactsPhotoBitmapHunter$ContactPhotoStreamIcs
{
  static InputStream get(ContentResolver paramContentResolver, Uri paramUri)
  {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContactsPhotoBitmapHunter.ContactPhotoStreamIcs
 * JD-Core Version:    0.7.0.1
 */