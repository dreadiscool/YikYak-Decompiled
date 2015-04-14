package android.support.v4.net;

import java.net.Socket;

class TrafficStatsCompat$IcsTrafficStatsCompatImpl
  implements TrafficStatsCompat.TrafficStatsCompatImpl
{
  public void clearThreadStatsTag() {}
  
  public int getThreadStatsTag()
  {
    return TrafficStatsCompatIcs.getThreadStatsTag();
  }
  
  public void incrementOperationCount(int paramInt)
  {
    TrafficStatsCompatIcs.incrementOperationCount(paramInt);
  }
  
  public void incrementOperationCount(int paramInt1, int paramInt2)
  {
    TrafficStatsCompatIcs.incrementOperationCount(paramInt1, paramInt2);
  }
  
  public void setThreadStatsTag(int paramInt)
  {
    TrafficStatsCompatIcs.setThreadStatsTag(paramInt);
  }
  
  public void tagSocket(Socket paramSocket)
  {
    TrafficStatsCompatIcs.tagSocket(paramSocket);
  }
  
  public void untagSocket(Socket paramSocket)
  {
    TrafficStatsCompatIcs.untagSocket(paramSocket);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.TrafficStatsCompat.IcsTrafficStatsCompatImpl
 * JD-Core Version:    0.7.0.1
 */