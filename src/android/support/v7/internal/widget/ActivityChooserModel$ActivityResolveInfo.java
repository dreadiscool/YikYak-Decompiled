package android.support.v7.internal.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo
  implements Comparable<ActivityResolveInfo>
{
  public final ResolveInfo resolveInfo;
  public float weight;
  
  public ActivityChooserModel$ActivityResolveInfo(ActivityChooserModel paramActivityChooserModel, ResolveInfo paramResolveInfo)
  {
    this.resolveInfo = paramResolveInfo;
  }
  
  public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
  {
    return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (getClass() != paramObject.getClass())
      {
        bool = false;
      }
      else
      {
        ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)paramObject;
        if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(localActivityResolveInfo.weight)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return 31 + Float.floatToIntBits(this.weight);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.ActivityResolveInfo
 * JD-Core Version:    0.7.0.1
 */