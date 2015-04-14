import com.yik.yak.ui.activity.SplashScreen;
import org.json.JSONObject;

public class En
    implements Cj
{
    public En(SplashScreen paramSplashScreen) {}
    
    public void a(zF paramzF, Object paramObject)
    {
        CR.initEndpoints((JSONObject)paramObject);
        CR.h();
        SplashScreen.e(this.a);
    }
    
    public void a(zz paramzz, Exception paramException)
    {
        SplashScreen.f(this.a);
        SplashScreen.e(this.a);
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     En

 * JD-Core Version:    0.7.0.1

 */