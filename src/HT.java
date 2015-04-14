import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class HT
  implements HN, HS, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  static final Interpolator a = new AccelerateDecelerateInterpolator();
  private static final boolean d = Log.isLoggable("PhotoViewAttacher", 3);
  private ImageView.ScaleType A = ImageView.ScaleType.FIT_CENTER;
  int b = 200;
  private int c = 2;
  private final Matrix e = new Matrix();
  private final Matrix f = new Matrix();
  private final Matrix g = new Matrix();
  private final RectF h = new RectF();
  private final float[] i = new float[9];
  private float j = 1.0F;
  private float k = 1.75F;
  private float l = 3.0F;
  private boolean m = true;
  private WeakReference<ImageView> n;
  private GestureDetector o;
  private HL p;
  private HY q;
  private HZ r;
  private Ia s;
  private View.OnLongClickListener t;
  private int u;
  private int v;
  private int w;
  private int x;
  private HX y;
  private boolean z;
  
  public HT(ImageView paramImageView)
  {
    this.n = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    b(paramImageView);
    if (paramImageView.isInEditMode()) {}
    for (;;)
    {
      return;
      this.p = Id.a(paramImageView.getContext(), this);
      this.o = new GestureDetector(paramImageView.getContext(), new HU(this));
      this.o.setOnDoubleTapListener(new HH(this));
      b(true);
    }
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.i);
    return this.i[paramInt];
  }
  
  private RectF a(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      Drawable localDrawable = localImageView.getDrawable();
      if (localDrawable != null)
      {
        this.h.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramMatrix.mapRect(this.h);
      }
    }
    for (RectF localRectF = this.h;; localRectF = null) {
      return localRectF;
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    ImageView localImageView = c();
    if ((localImageView == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = c(localImageView);
    float f2 = d(localImageView);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.e.reset();
    float f3 = f1 / i1;
    float f4 = f2 / i2;
    if (this.A == ImageView.ScaleType.CENTER) {
      this.e.postTranslate((f1 - i1) / 2.0F, (f2 - i2) / 2.0F);
    }
    for (;;)
    {
      r();
      break;
      if (this.A == ImageView.ScaleType.CENTER_CROP)
      {
        float f6 = Math.max(f3, f4);
        this.e.postScale(f6, f6);
        this.e.postTranslate((f1 - f6 * i1) / 2.0F, (f2 - f6 * i2) / 2.0F);
      }
      else if (this.A == ImageView.ScaleType.CENTER_INSIDE)
      {
        float f5 = Math.min(1.0F, Math.min(f3, f4));
        this.e.postScale(f5, f5);
        this.e.postTranslate((f1 - f5 * i1) / 2.0F, (f2 - f5 * i2) / 2.0F);
      }
      else
      {
        RectF localRectF1 = new RectF(0.0F, 0.0F, i1, i2);
        RectF localRectF2 = new RectF(0.0F, 0.0F, f1, f2);
        switch (HV.a[this.A.ordinal()])
        {
        default: 
          break;
        case 2: 
          this.e.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.START);
          break;
        case 4: 
          this.e.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
          break;
        case 3: 
          this.e.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.END);
          break;
        case 5: 
          this.e.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  private static boolean a(ImageView paramImageView)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
    }
  }
  
  private void b(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      p();
      localImageView.setImageMatrix(paramMatrix);
      if (this.q != null) {
        a(paramMatrix);
      }
    }
  }
  
  private static void b(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof HN)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private static boolean b(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      switch (HV.a[paramScaleType.ordinal()])
      {
      }
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }
  
  private int c(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    for (int i1 = 0;; i1 = paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight()) {
      return i1;
    }
  }
  
  private int d(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    for (int i1 = 0;; i1 = paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom()) {
      return i1;
    }
  }
  
  private void n()
  {
    if (this.y != null)
    {
      this.y.a();
      this.y = null;
    }
  }
  
  private void o()
  {
    if (q()) {
      b(l());
    }
  }
  
  private void p()
  {
    ImageView localImageView = c();
    if ((localImageView != null) && (!(localImageView instanceof HN)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType()))) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
    }
  }
  
  private boolean q()
  {
    float f1 = 0.0F;
    ImageView localImageView = c();
    if (localImageView == null) {}
    RectF localRectF;
    for (boolean bool = false;; bool = false)
    {
      return bool;
      localRectF = a(l());
      if (localRectF != null) {
        break;
      }
    }
    float f2 = localRectF.height();
    float f3 = localRectF.width();
    int i1 = d(localImageView);
    float f4;
    if (f2 <= i1) {
      switch (HV.a[this.A.ordinal()])
      {
      default: 
        f4 = (i1 - f2) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      label111:
      int i2 = c(localImageView);
      if (f3 <= i2) {
        switch (HV.a[this.A.ordinal()])
        {
        default: 
          f1 = (i2 - f3) / 2.0F - localRectF.left;
          label174:
          this.c = 2;
        }
      }
      for (;;)
      {
        this.g.postTranslate(f1, f4);
        bool = true;
        break;
        f4 = -localRectF.top;
        break label111;
        f4 = i1 - f2 - localRectF.top;
        break label111;
        if (localRectF.top > 0.0F)
        {
          f4 = -localRectF.top;
          break label111;
        }
        if (localRectF.bottom >= i1) {
          break label349;
        }
        f4 = i1 - localRectF.bottom;
        break label111;
        f1 = -localRectF.left;
        break label174;
        f1 = i2 - f3 - localRectF.left;
        break label174;
        if (localRectF.left > 0.0F)
        {
          this.c = 0;
          f1 = -localRectF.left;
        }
        else if (localRectF.right < i2)
        {
          f1 = i2 - localRectF.right;
          this.c = 1;
        }
        else
        {
          this.c = -1;
        }
      }
      label349:
      f4 = 0.0F;
    }
  }
  
  private void r()
  {
    this.g.reset();
    b(l());
    q();
  }
  
  public void a()
  {
    if (this.n == null) {}
    for (;;)
    {
      return;
      ImageView localImageView = (ImageView)this.n.get();
      if (localImageView != null)
      {
        ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
        if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
        localImageView.setOnTouchListener(null);
        n();
      }
      if (this.o != null) {
        this.o.setOnDoubleTapListener(null);
      }
      this.q = null;
      this.r = null;
      this.s = null;
      this.n = null;
    }
  }
  
  public void a(float paramFloat)
  {
    this.g.setRotate(paramFloat % 360.0F);
    o();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.p.a()) {}
    for (;;)
    {
      return;
      if (d)
      {
        HP.a();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Float.valueOf(paramFloat1);
        arrayOfObject[1] = Float.valueOf(paramFloat2);
        String.format("onDrag: dx: %.2f. dy: %.2f", arrayOfObject);
      }
      ImageView localImageView = c();
      this.g.postTranslate(paramFloat1, paramFloat2);
      o();
      ViewParent localViewParent = localImageView.getParent();
      if ((this.m) && (!this.p.a()))
      {
        if (((this.c == 2) || ((this.c == 0) && (paramFloat1 >= 1.0F)) || ((this.c == 1) && (paramFloat1 <= -1.0F))) && (localViewParent != null)) {
          localViewParent.requestDisallowInterceptTouchEvent(false);
        }
      }
      else if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (d)
    {
      HP.a();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Float.valueOf(paramFloat1);
      arrayOfObject[1] = Float.valueOf(paramFloat2);
      arrayOfObject[2] = Float.valueOf(paramFloat3);
      String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", arrayOfObject);
    }
    if ((g() < this.l) || (paramFloat1 < 1.0F))
    {
      this.g.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      o();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (d)
    {
      HP.a();
      new StringBuilder().append("onFling. sX: ").append(paramFloat1).append(" sY: ").append(paramFloat2).append(" Vx: ").append(paramFloat3).append(" Vy: ").append(paramFloat4).toString();
    }
    ImageView localImageView = c();
    this.y = new HX(this, localImageView.getContext());
    this.y.a(c(localImageView), d(localImageView), (int)paramFloat3, (int)paramFloat4);
    localImageView.post(this.y);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if ((paramFloat1 >= this.j) && (paramFloat1 <= this.l)) {
        break label34;
      }
      HP.a();
    }
    for (;;)
    {
      return;
      label34:
      if (paramBoolean)
      {
        localImageView.post(new HW(this, g(), paramFloat1, paramFloat2, paramFloat3));
      }
      else
      {
        this.g.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
        o();
      }
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null) {
      a(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 200;
    }
    this.b = paramInt;
  }
  
  public void a(HY paramHY)
  {
    this.q = paramHY;
  }
  
  public void a(HZ paramHZ)
  {
    this.r = paramHZ;
  }
  
  public void a(Ia paramIa)
  {
    this.s = paramIa;
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    if (paramOnDoubleTapListener != null) {
      this.o.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
    for (;;)
    {
      return;
      this.o.setOnDoubleTapListener(new HH(this));
    }
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.t = paramOnLongClickListener;
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if ((b(paramScaleType)) && (paramScaleType != this.A))
    {
      this.A = paramScaleType;
      k();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public RectF b()
  {
    q();
    return a(l());
  }
  
  public void b(float paramFloat)
  {
    this.g.postRotate(paramFloat % 360.0F);
    o();
  }
  
  public void b(boolean paramBoolean)
  {
    this.z = paramBoolean;
    k();
  }
  
  public ImageView c()
  {
    ImageView localImageView = null;
    if (this.n != null) {
      localImageView = (ImageView)this.n.get();
    }
    if (localImageView == null) {
      a();
    }
    return localImageView;
  }
  
  public void c(float paramFloat)
  {
    b(paramFloat, this.k, this.l);
    this.j = paramFloat;
  }
  
  public float d()
  {
    return this.j;
  }
  
  public void d(float paramFloat)
  {
    b(this.j, paramFloat, this.l);
    this.k = paramFloat;
  }
  
  public float e()
  {
    return this.k;
  }
  
  public void e(float paramFloat)
  {
    b(this.j, this.k, paramFloat);
    this.l = paramFloat;
  }
  
  public float f()
  {
    return this.l;
  }
  
  public void f(float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public float g()
  {
    return FloatMath.sqrt((float)Math.pow(a(this.g, 0), 2.0D) + (float)Math.pow(a(this.g, 3), 2.0D));
  }
  
  public ImageView.ScaleType h()
  {
    return this.A;
  }
  
  public HZ i()
  {
    return this.r;
  }
  
  public Ia j()
  {
    return this.s;
  }
  
  public void k()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (!this.z) {
        break label29;
      }
      b(localImageView);
      a(localImageView.getDrawable());
    }
    for (;;)
    {
      return;
      label29:
      r();
    }
  }
  
  public Matrix l()
  {
    this.f.set(this.e);
    this.f.postConcat(this.g);
    return this.f;
  }
  
  public void onGlobalLayout()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (!this.z) {
        break label103;
      }
      int i1 = localImageView.getTop();
      int i2 = localImageView.getRight();
      int i3 = localImageView.getBottom();
      int i4 = localImageView.getLeft();
      if ((i1 != this.u) || (i3 != this.w) || (i4 != this.x) || (i2 != this.v))
      {
        a(localImageView.getDrawable());
        this.u = i1;
        this.v = i2;
        this.w = i3;
        this.x = i4;
      }
    }
    for (;;)
    {
      return;
      label103:
      a(localImageView.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent;
    if ((this.z) && (a((ImageView)paramView)))
    {
      localViewParent = paramView.getParent();
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        bool = false;
        label58:
        if ((this.p != null) && (this.p.c(paramMotionEvent))) {
          bool = true;
        }
        if ((this.o == null) || (!this.o.onTouchEvent(paramMotionEvent))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
      n();
      bool = false;
      break label58;
      if (g() >= this.j) {
        break;
      }
      RectF localRectF = b();
      if (localRectF == null) {
        break;
      }
      paramView.post(new HW(this, g(), this.j, localRectF.centerX(), localRectF.centerY()));
      bool = true;
      break label58;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HT
 * JD-Core Version:    0.7.0.1
 */