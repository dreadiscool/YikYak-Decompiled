import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class wm
  implements SensorEventListener
{
  private int a = -1;
  private int b = 0;
  private long c = -1L;
  private final float[] d = new float[3];
  private final wn e;
  
  public wm(wn paramwn)
  {
    this.e = paramwn;
  }
  
  private float[] a(float[] paramArrayOfFloat)
  {
    for (int i = 0; i < 3; i++)
    {
      float f = this.d[i];
      this.d[i] = (f + 0.7F * (paramArrayOfFloat[i] - f));
    }
    return this.d;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = a(paramSensorEvent.values);
    int i = this.b;
    float f = arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[2] * arrayOfFloat[2];
    this.b = 0;
    if ((arrayOfFloat[2] > 7.8F) && (arrayOfFloat[2] < 11.8F)) {
      this.b = -1;
    }
    if ((arrayOfFloat[2] < -7.8F) && (arrayOfFloat[2] > -11.8F)) {
      this.b = 1;
    }
    if ((f < 60.840004F) || (f > 139.24001F)) {
      this.b = 0;
    }
    if (i != this.b) {
      this.c = paramSensorEvent.timestamp;
    }
    long l = paramSensorEvent.timestamp - this.c;
    switch (this.b)
    {
    }
    for (;;)
    {
      return;
      if ((l > 250000000L) && (this.a == 0))
      {
        this.a = 1;
        continue;
        if ((l > 250000000L) && (this.a == 1))
        {
          this.a = 0;
          this.e.a();
          continue;
          if ((l > 1000000000L) && (this.a != 0)) {
            this.a = 0;
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wm
 * JD-Core Version:    0.7.0.1
 */