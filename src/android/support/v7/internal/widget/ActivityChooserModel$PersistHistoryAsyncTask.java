package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class ActivityChooserModel$PersistHistoryAsyncTask
  extends AsyncTask<Object, Void, Void>
{
  private ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
  public Void doInBackground(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    String str = (String)paramVarArgs[1];
    FileOutputStream localFileOutputStream;
    for (;;)
    {
      try
      {
        localFileOutputStream = ActivityChooserModel.access$200(this.this$0).openFileOutput(str, 0);
        localXmlSerializer = Xml.newSerializer();
        int j;
        ActivityChooserModel.HistoricalRecord localHistoricalRecord;
        localXmlSerializer.endTag(null, "historical-records");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        try
        {
          localXmlSerializer.setOutput(localFileOutputStream, null);
          localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
          localXmlSerializer.startTag(null, "historical-records");
          j = localList.size();
          if (i >= j) {
            break label211;
          }
          localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)localList.remove(0);
          localXmlSerializer.startTag(null, "historical-record");
          localXmlSerializer.attribute(null, "activity", localHistoricalRecord.activity.flattenToString());
          localXmlSerializer.attribute(null, "time", String.valueOf(localHistoricalRecord.time));
          localXmlSerializer.attribute(null, "weight", String.valueOf(localHistoricalRecord.weight));
          localXmlSerializer.endTag(null, "historical-record");
          i++;
          continue;
          localFileNotFoundException = localFileNotFoundException;
          ActivityChooserModel.access$300();
          new StringBuilder().append("Error writing historical recrod file: ").append(str).toString();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          XmlSerializer localXmlSerializer;
          ActivityChooserModel.access$300();
          new StringBuilder().append("Error writing historical recrod file: ").append(ActivityChooserModel.access$400(this.this$0)).toString();
          ActivityChooserModel.access$502(this.this$0, true);
          if (localFileOutputStream == null) {
            continue;
          }
          try
          {
            localFileOutputStream.close();
          }
          catch (IOException localIOException5) {}
          continue;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ActivityChooserModel.access$300();
          new StringBuilder().append("Error writing historical recrod file: ").append(ActivityChooserModel.access$400(this.this$0)).toString();
          ActivityChooserModel.access$502(this.this$0, true);
          if (localFileOutputStream == null) {
            continue;
          }
          try
          {
            localFileOutputStream.close();
          }
          catch (IOException localIOException4) {}
          continue;
        }
        catch (IOException localIOException2)
        {
          ActivityChooserModel.access$300();
          new StringBuilder().append("Error writing historical recrod file: ").append(ActivityChooserModel.access$400(this.this$0)).toString();
          ActivityChooserModel.access$502(this.this$0, true);
          if (localFileOutputStream == null) {
            continue;
          }
          try
          {
            localFileOutputStream.close();
          }
          catch (IOException localIOException3) {}
          continue;
        }
        finally
        {
          ActivityChooserModel.access$502(this.this$0, true);
          if (localFileOutputStream == null) {
            break label454;
          }
        }
        return null;
      }
      label211:
      localXmlSerializer.endDocument();
      ActivityChooserModel.access$502(this.this$0, true);
      if (localFileOutputStream != null) {
        try
        {
          localFileOutputStream.close();
        }
        catch (IOException localIOException6) {}
      }
    }
    try
    {
      localFileOutputStream.close();
      label454:
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      break label454;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * JD-Core Version:    0.7.0.1
 */