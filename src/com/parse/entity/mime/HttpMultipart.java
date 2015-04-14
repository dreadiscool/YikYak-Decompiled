package com.parse.entity.mime;

import com.parse.entity.mime.content.ContentBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class HttpMultipart
{
  private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
  private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
  private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
  private final String boundary;
  private final Charset charset;
  private final HttpMultipartMode mode;
  private final List<FormBodyPart> parts;
  private final String subType;
  
  public HttpMultipart(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public HttpMultipart(String paramString1, Charset paramCharset, String paramString2)
  {
    this(paramString1, paramCharset, paramString2, HttpMultipartMode.STRICT);
  }
  
  public HttpMultipart(String paramString1, Charset paramCharset, String paramString2, HttpMultipartMode paramHttpMultipartMode)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Multipart subtype may not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Multipart boundary may not be null");
    }
    this.subType = paramString1;
    if (paramCharset != null) {}
    for (;;)
    {
      this.charset = paramCharset;
      this.boundary = paramString2;
      this.parts = new ArrayList();
      this.mode = paramHttpMultipartMode;
      return;
      paramCharset = MIME.DEFAULT_CHARSET;
    }
  }
  
  private void doWriteTo(HttpMultipartMode paramHttpMultipartMode, OutputStream paramOutputStream, boolean paramBoolean)
  {
    ByteArrayBuffer localByteArrayBuffer = encode(this.charset, getBoundary());
    Iterator localIterator1 = this.parts.iterator();
    if (localIterator1.hasNext())
    {
      FormBodyPart localFormBodyPart = (FormBodyPart)localIterator1.next();
      writeBytes(TWO_DASHES, paramOutputStream);
      writeBytes(localByteArrayBuffer, paramOutputStream);
      writeBytes(CR_LF, paramOutputStream);
      Header localHeader = localFormBodyPart.getHeader();
      switch (HttpMultipart.1.$SwitchMap$com$parse$entity$mime$HttpMultipartMode[paramHttpMultipartMode.ordinal()])
      {
      }
      for (;;)
      {
        writeBytes(CR_LF, paramOutputStream);
        if (paramBoolean) {
          localFormBodyPart.getBody().writeTo(paramOutputStream);
        }
        writeBytes(CR_LF, paramOutputStream);
        break;
        Iterator localIterator2 = localHeader.iterator();
        while (localIterator2.hasNext()) {
          writeField((MinimalField)localIterator2.next(), paramOutputStream);
        }
        writeField(localFormBodyPart.getHeader().getField("Content-Disposition"), this.charset, paramOutputStream);
        if (localFormBodyPart.getBody().getFilename() != null) {
          writeField(localFormBodyPart.getHeader().getField("Content-Type"), this.charset, paramOutputStream);
        }
      }
    }
    writeBytes(TWO_DASHES, paramOutputStream);
    writeBytes(localByteArrayBuffer, paramOutputStream);
    writeBytes(TWO_DASHES, paramOutputStream);
    writeBytes(CR_LF, paramOutputStream);
  }
  
  private static ByteArrayBuffer encode(Charset paramCharset, String paramString)
  {
    ByteBuffer localByteBuffer = paramCharset.encode(CharBuffer.wrap(paramString));
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(localByteBuffer.remaining());
    localByteArrayBuffer.append(localByteBuffer.array(), localByteBuffer.position(), localByteBuffer.remaining());
    return localByteArrayBuffer;
  }
  
  private static void writeBytes(String paramString, OutputStream paramOutputStream)
  {
    writeBytes(encode(MIME.DEFAULT_CHARSET, paramString), paramOutputStream);
  }
  
  private static void writeBytes(String paramString, Charset paramCharset, OutputStream paramOutputStream)
  {
    writeBytes(encode(paramCharset, paramString), paramOutputStream);
  }
  
  private static void writeBytes(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }
  
  private static void writeField(MinimalField paramMinimalField, OutputStream paramOutputStream)
  {
    writeBytes(paramMinimalField.getName(), paramOutputStream);
    writeBytes(FIELD_SEP, paramOutputStream);
    writeBytes(paramMinimalField.getBody(), paramOutputStream);
    writeBytes(CR_LF, paramOutputStream);
  }
  
  private static void writeField(MinimalField paramMinimalField, Charset paramCharset, OutputStream paramOutputStream)
  {
    writeBytes(paramMinimalField.getName(), paramCharset, paramOutputStream);
    writeBytes(FIELD_SEP, paramOutputStream);
    writeBytes(paramMinimalField.getBody(), paramCharset, paramOutputStream);
    writeBytes(CR_LF, paramOutputStream);
  }
  
  public void addBodyPart(FormBodyPart paramFormBodyPart)
  {
    if (paramFormBodyPart == null) {}
    for (;;)
    {
      return;
      this.parts.add(paramFormBodyPart);
    }
  }
  
  public List<FormBodyPart> getBodyParts()
  {
    return this.parts;
  }
  
  public String getBoundary()
  {
    return this.boundary;
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public HttpMultipartMode getMode()
  {
    return this.mode;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
  
  public long getTotalLength()
  {
    Iterator localIterator = this.parts.iterator();
    long l1 = 0L;
    long l2;
    while (localIterator.hasNext())
    {
      long l3 = ((FormBodyPart)localIterator.next()).getBody().getContentLength();
      if (l3 >= 0L) {
        l1 = l3 + l1;
      } else {
        l2 = -1L;
      }
    }
    for (;;)
    {
      return l2;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        doWriteTo(this.mode, localByteArrayOutputStream, false);
        int i = localByteArrayOutputStream.toByteArray().length;
        l2 = l1 + i;
      }
      catch (IOException localIOException)
      {
        l2 = -1L;
      }
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    doWriteTo(this.mode, paramOutputStream, true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.HttpMultipart
 * JD-Core Version:    0.7.0.1
 */