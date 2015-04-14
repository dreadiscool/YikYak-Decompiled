import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class NotificationSoundListener implements CompoundButton.OnCheckedChangeListener
{
    NotificationSoundListener(GI paramGI) {}
  
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
        ApplicationConfig.setAudibleNotifications(paramBoolean);
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     NotificationSoundListener

 * JD-Core Version:    0.7.0.1

 */