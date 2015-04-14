package com.parse.entity.mime;

import com.parse.entity.mime.content.ContentBody;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class MultipartEntity
  implements HttpEntity
{
  private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final Header contentType;
  private volatile boolean dirty;
  private long length;
  private final HttpMultipart multipart;
  
  public MultipartEntity()
  {
    this(HttpMultipartMode.STRICT, null, null);
  }
  
  public MultipartEntity(HttpMultipartMode paramHttpMultipartMode)
  {
    this(paramHttpMultipartMode, null, null);
  }
  
  public MultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      paramString = generateBoundary();
    }
    if (paramHttpMultipartMode == null) {
      paramHttpMultipartMode = HttpMultipartMode.STRICT;
    }
    this.multipart = new HttpMultipart("form-data", paramCharset, paramString, paramHttpMultipartMode);
    this.contentType = new BasicHeader("Content-Type", generateContentType(paramString, paramCharset));
    this.dirty = true;
  }
  
  public void addPart(FormBodyPart paramFormBodyPart)
  {
    this.multipart.addBodyPart(paramFormBodyPart);
    this.dirty = true;
  }
  
  public void addPart(String paramString, ContentBody paramContentBody)
  {
    addPart(new FormBodyPart(paramString, paramContentBody));
  }
  
  public void consumeContent()
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  protected String generateBoundary()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int i = 30 + localRandom.nextInt(11);
    for (int j = 0; j < i; j++) {
      localStringBuilder.append(MULTIPART_CHARS[localRandom.nextInt(MULTIPART_CHARS.length)]);
    }
    return localStringBuilder.toString();
  }
  
  protected String generateContentType(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }
  
  public InputStream getContent()
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    if (this.dirty)
    {
      this.length = this.multipart.getTotalLength();
      this.dirty = false;
    }
    return this.length;
  }
  
  public Header getContentType()
  {
    return this.contentType;
  }
  
  public boolean isChunked()
  {
    if (!isRepeatable()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isRepeatable()
  {
    Iterator localIterator = this.multipart.getBodyParts().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((FormBodyPart)localIterator.next()).getBody().getContentLength() >= 0L);
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public boolean isStreaming()
  {
    if (!isRepeatable()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.multipart.writeTo(paramOutputStream);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.MultipartEntity
 * JD-Core Version:    0.7.0.1
 */