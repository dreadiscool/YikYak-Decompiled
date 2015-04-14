package com.parse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import m;

public class ParseImageView
  extends ImageView
{
  private ParseFile file;
  private boolean isLoaded = false;
  private Drawable placeholder;
  
  public ParseImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParseImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParseImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public m<byte[]> loadInBackground()
  {
    if (this.file == null) {}
    ParseFile localParseFile;
    for (m localm = m.a(null);; localm = this.file.getDataInBackground().d(new ParseImageView.1(this, localParseFile), m.b))
    {
      return localm;
      localParseFile = this.file;
    }
  }
  
  public void loadInBackground(GetDataCallback paramGetDataCallback)
  {
    Parse.callbackOnMainThreadAsync(loadInBackground(), paramGetDataCallback, true);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.file != null) {
      this.file.cancel();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.isLoaded = true;
  }
  
  public void setParseFile(ParseFile paramParseFile)
  {
    if (this.file != null) {
      this.file.cancel();
    }
    this.isLoaded = false;
    this.file = paramParseFile;
    setImageDrawable(this.placeholder);
  }
  
  public void setPlaceholder(Drawable paramDrawable)
  {
    this.placeholder = paramDrawable;
    if (!this.isLoaded) {
      setImageDrawable(this.placeholder);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseImageView
 * JD-Core Version:    0.7.0.1
 */