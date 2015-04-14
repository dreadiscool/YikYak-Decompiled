package com.parse;

import java.io.IOException;
import java.util.concurrent.Callable;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

class ParseRequest$3
  implements Callable<Response>
{
  ParseRequest$3(ParseRequest paramParseRequest, ProgressCallback paramProgressCallback) {}
  
  public Response call()
  {
    try
    {
      HttpResponse localHttpResponse = ParseRequest.access$100(this.this$0).execute(ParseRequest.access$000(this.this$0));
      Object localObject = this.this$0.onResponse(localHttpResponse, this.val$progressCallback);
      return localObject;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      throw this.this$0.connectionFailed("bad protocol", localClientProtocolException);
    }
    catch (IOException localIOException)
    {
      throw this.this$0.connectionFailed("i/o failure", localIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest.3
 * JD-Core Version:    0.7.0.1
 */