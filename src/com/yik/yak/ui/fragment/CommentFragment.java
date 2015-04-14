package com.yik.yak.ui.fragment;

import ApplicationConfig;
import CK;
import CM;
import CQ;
import CR;
import CZ;
import FA;
import Fa;
import Fp;
import Fs;
import Ft;
import Fx;
import Fz;
import If;
import Ik;
import Im;
import Iq;
import Is;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.yik.yak.data.models.YakkerLocation;
import com.yik.yak.ui.activity.FamousActivity;
import com.yik.yak.ui.activity.ReportDialog;
import com.yik.yak.ui.activity.YikYakDialog;
import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import java.util.TreeMap;
import org.json.JSONObject;
import yV;
import zB;
import zC;
import zt;
import zu;
import zz;

public class CommentFragment
  extends Fa
{
  public ArrayList<CQ> b = new ArrayList();
  protected boolean c = true;
  public boolean d = true;
  public boolean e = true;
  public boolean f = true;
  public boolean g = false;
  public boolean h = false;
  protected Bundle i = null;
  protected String j = "MainFeed";
  public CK k;
  protected CK l;
  protected CM m = null;
  @InjectView(2131558632)
  protected RelativeLayout mCommentFooter;
  @InjectView(2131558634)
  public EditText mReplyField;
  @InjectView(2131558633)
  protected Button mSendButton;
  protected YakkerLocation n;
  public YakDetailAdapter o;
  public RefreshListView p;
  private View q;
  private Context r;
  private ViewTreeObserver.OnGlobalLayoutListener s;
  
  public static CommentFragment a(CK paramCK, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    CommentFragment localCommentFragment = new CommentFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("canSubmit", paramBoolean1);
    localBundle.putBoolean("canVote", paramBoolean2);
    localBundle.putBoolean("canReply", paramBoolean3);
    localBundle.putBoolean("canReport", paramBoolean4);
    localBundle.putString("caller", paramString);
    localCommentFragment.setArguments(localBundle);
    localCommentFragment.d(paramCK);
    return localCommentFragment;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramInt != 1) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("KEY_SHOULD_BLOCK_YAKKER", false)) {
        a(paramIntent);
      } else {
        b(paramIntent);
      }
    }
  }
  
  private void a(CK paramCK, String paramString1, boolean paramBoolean, String paramString2)
  {
    a(paramCK, paramString1, paramBoolean, false, paramString2);
  }
  
  private void a(CK paramCK, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("messageID", this.k.b);
    if (paramCK != null) {
      localTreeMap.put("commentID", paramCK.c);
    }
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    localTreeMap.put("lat", this.n.a());
    localTreeMap.put("long", this.n.b());
    if ((!paramBoolean1) && (!Ik.a(paramString2))) {
      localTreeMap.put("reason", paramString2);
    }
    if (paramBoolean2) {
      localTreeMap.put("block", String.valueOf(paramBoolean2));
    }
    String str = Im.a(CR.f(), paramString1, localTreeMap, this.n);
    zz localzz = new zB().a(str).b();
    Im.a(true).a(localzz).a(new Fx(this, paramBoolean1, paramCK, paramBoolean2));
  }
  
  private void a(Intent paramIntent)
  {
    Intent localIntent = new Intent(getActivity(), YikYakDialog.class);
    localIntent.putExtra("title", "Are you sure?");
    localIntent.putExtra("message", "You're about to banish the author of this yak from your feed for good. This can't be undone, so proceed wisely!");
    localIntent.putExtra("okText", "OK");
    localIntent.putExtra("cancelText", "CANCEL");
    startActivityForResult(localIntent, 7008);
  }
  
  private void a(Exception paramException)
  {
    if (!isAdded()) {}
    for (;;)
    {
      return;
      new Handler(this.r.getMainLooper()).post(new Fs(this, paramException));
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    a(null, paramString1, paramBoolean, paramString2);
  }
  
  private boolean a(CK paramCK)
  {
    if (paramCK.d < CR.a("shareThreshold", "shareThreshold", 0))
    {
      String str = CR.a("shareThreshold", "message", getResources().getString(2131231014));
      Intent localIntent2 = new Intent(getActivity(), YikYakDialog.class);
      localIntent2.putExtra("title", getActivity().getResources().getString(2131231019));
      localIntent2.putExtra("message", str);
      localIntent2.putExtra("okText", "OK");
      localIntent2.putExtra("okOnly", "true");
      startActivity(localIntent2);
    }
    for (;;)
    {
      return true;
      if ((paramCK.n.equals(this.m.b())) && (paramCK.d <= CR.a("shareThreshold", "famousThreshold", 1)))
      {
        Intent localIntent1 = new Intent(getActivity(), FamousActivity.class);
        localIntent1.addFlags(67108864);
        localIntent1.putExtra("yak", paramCK.d().toString());
        startActivity(localIntent1);
      }
      else
      {
        new Is(getActivity(), paramCK).execute(new Void[0]);
      }
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool;
    if (!this.e)
    {
      Toast.makeText(getActivity(), 2131230966, 0).show();
      this.g = false;
      this.mReplyField.clearFocus();
      b();
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramString.trim().length() == 0)
      {
        Toast.makeText(getActivity(), "You must enter a comment first.", 0).show();
        this.g = false;
        bool = false;
      }
      else
      {
        this.mReplyField.clearFocus();
        b();
        TreeMap localTreeMap = new TreeMap();
        localTreeMap.put("userID", ApplicationConfig.getYakkerID());
        localTreeMap.put("lat", this.n.a());
        localTreeMap.put("long", this.n.b());
        localTreeMap.put("messageID", this.k.b);
        localTreeMap.put("comment", paramString);
        localTreeMap.put("bypassedThreatPopup", String.valueOf(paramInt));
        String str1 = Im.b(CR.f(), "postComment", localTreeMap, this.n);
        String str2 = (String)localTreeMap.get("RequestBody:body");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = str2;
        Iq.a(this, arrayOfObject);
        zC localzC = zC.a(zt.a("application/x-www-form-urlencoded"), str2);
        zz localzz = new zB().a(localzC).a(str1).b();
        Im.a(true).a(localzz).a(new Fp(this));
        bool = true;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("result");
    boolean bool = paramIntent.getBooleanExtra("KEY_SHOULD_BLOCK_YAKKER", false);
    if (this.l != null) {}
    for (String str2 = "reportComment";; str2 = "reportMessage")
    {
      a(this.l, str2, false, bool, str1);
      Intent localIntent = new Intent(getActivity(), YikYakDialog.class);
      localIntent.putExtra("title", getActivity().getResources().getString(2131230970));
      localIntent.putExtra("message", getActivity().getResources().getString(2131230969));
      localIntent.putExtra("okText", "OK");
      localIntent.putExtra("okOnly", "true");
      startActivityForResult(localIntent, 7006);
      return;
    }
  }
  
  private boolean b(CK paramCK)
  {
    Intent localIntent = new Intent(getActivity(), YikYakDialog.class);
    localIntent.putExtra("title", "DELETE YAK");
    localIntent.putExtra("message", "Are you sure you want to delete this Yak?");
    localIntent.putExtra("okText", "YES");
    localIntent.putExtra("cancelText", "NO");
    this.l = paramCK;
    if (paramCK == null) {
      startActivityForResult(localIntent, 7001);
    }
    for (;;)
    {
      return true;
      startActivityForResult(localIntent, 7003);
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool = true;
    if (((!BV.a(2)) || (CR.a("threatWords", "alwaysShowMessage", bool))) && (Ik.b(paramString))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean c(CK paramCK)
  {
    if (this.m.a("YakBak", paramCK.c)) {
      Toast.makeText(getActivity(), "You have already reported this comment.", 0).show();
    }
    for (;;)
    {
      return true;
      this.l = paramCK;
      e();
    }
  }
  
  private void d()
  {
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  private void d(CK paramCK)
  {
    this.k = paramCK;
  }
  
  private void e()
  {
    startActivityForResult(new Intent(getActivity(), ReportDialog.class), 7002);
  }
  
  private void f()
  {
    this.p = ((RefreshListView)this.q.findViewById(2131558801));
    this.p.setOnRefreshListener(new FA(this));
    this.p.e().setLayoutManager(new LinearLayoutManager(getActivity()));
    this.o = new YakDetailAdapter(getActivity(), this);
    this.o.setHeaderData(this.k);
    this.p.setAdapter(this.o);
    this.o.notifyDataSetChanged();
    this.o.setShouldContextMenuShowOnSingleClick(true);
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = false;
    if ((this.k == null) || (Ik.a(this.k.b)))
    {
      this.b.clear();
      this.o.notifyDataSetChanged();
    }
    for (;;)
    {
      return;
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("userID", ApplicationConfig.getYakkerID());
      localTreeMap.put("messageID", this.k.b);
      localTreeMap.put("lat", this.n.a());
      localTreeMap.put("long", this.n.b());
      String str = Im.a("getComments", localTreeMap, this.n);
      zz localzz = new zB().a(str).b();
      if (this.b.isEmpty()) {
        this.o.addLoadingYak();
      }
      Im.a(true).a(localzz).a(new Ft(this, paramBoolean));
    }
  }
  
  protected void c()
  {
    if (!this.p.f())
    {
      if (!CZ.c()) {
        break label72;
      }
      if (!CR.c()) {
        break label51;
      }
      this.p.setRefreshStyle(1);
      this.p.setRefreshImageDrawable(CZ.c);
      this.p.setRefreshImage(CZ.c);
    }
    for (;;)
    {
      return;
      label51:
      this.p.setRefreshStyle(2);
      this.p.setAnimationBackgroundColor(CZ.b());
      continue;
      label72:
      this.p.setRefreshStyle(1);
      this.p.setRefreshImageDrawable(2130837837);
      this.p.setRefreshImage(2130837837);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    setHasOptionsMenu(true);
    this.m = CM.a(getActivity());
    this.i = getArguments();
    if (this.i != null)
    {
      this.c = this.i.getBoolean("canSubmit", true);
      this.d = this.i.getBoolean("canVote", true);
      this.e = this.i.getBoolean("canReply", true);
      this.f = this.i.getBoolean("canReport", true);
      this.j = this.i.getString("caller", "MainFeed");
    }
    this.n = CM.a(getActivity()).f();
    if ((this.n.getLatitude() == 0.0D) && (this.n.getLongitude() == 0.0D))
    {
      this.c = false;
      this.d = false;
      this.e = false;
    }
    if (this.e)
    {
      this.mReplyField.setFocusable(true);
      this.mReplyField.setFocusableInTouchMode(true);
      this.mReplyField.setClickable(true);
      this.mReplyField.setText("");
      this.mSendButton.setAlpha(1.0F);
      this.mSendButton.setClickable(true);
    }
    for (;;)
    {
      if ((this.k != null) && (!Ik.a(this.k.b)))
      {
        a();
        If.a().a(this.k, this.j);
      }
      return;
      this.mReplyField.setFocusable(false);
      this.mReplyField.setFocusableInTouchMode(false);
      this.mReplyField.setClickable(false);
      this.mReplyField.setHint(2131230966);
      this.mSendButton.setAlpha(0.5F);
      this.mSendButton.setClickable(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    case 7004: 
    case 7007: 
    default: 
    case 7002: 
    case 7003: 
    case 7001: 
    case 7005: 
    case 7008: 
      for (;;)
      {
        return;
        a(paramInt2, paramIntent);
        continue;
        if (paramInt2 == 1)
        {
          a(this.l, "deleteComment", true, null);
          continue;
          if (paramInt2 == 1)
          {
            a("deleteMessage2", true, null);
            continue;
            if (paramInt2 == 1)
            {
              a(paramIntent.getStringExtra("value"), 1);
              ApplicationConfig.b(2);
              continue;
              if (paramInt2 == 1)
              {
                paramIntent.putExtra("KEY_SHOULD_BLOCK_YAKKER", true);
                b(paramIntent);
              }
              else
              {
                e();
              }
            }
          }
        }
      }
    }
    if (this.l == null) {
      d();
    }
    for (;;)
    {
      this.l = null;
      break;
      a();
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    CK localCK = (CK)paramMenuItem.getActionView().getTag();
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onContextItemSelected(paramMenuItem);
    }
    for (;;)
    {
      return bool;
      bool = a(localCK);
      continue;
      bool = b(localCK);
      continue;
      bool = c(localCK);
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755009, paramMenu);
    if (this.k == null)
    {
      paramMenu.getItem(0).setVisible(false);
      paramMenu.getItem(1).setVisible(false);
    }
    for (;;)
    {
      return;
      if (!this.k.H)
      {
        paramMenu.getItem(0).setVisible(false);
        paramMenu.getItem(1).setVisible(false);
      }
      else if (this.k.n.equals(BV.getYakkerID()))
      {
        paramMenu.getItem(0).setVisible(false);
      }
      else
      {
        paramMenu.getItem(1).setVisible(false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2130903103, paramViewGroup, false);
    this.r = getActivity();
    ButterKnife.inject(this, this.q);
    f();
    if (this.s != null) {}
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.q.getViewTreeObserver().removeOnGlobalLayoutListener(this.s);
      }
      for (;;)
      {
        label62:
        this.s = new Fz(this);
        this.q.getViewTreeObserver().addOnGlobalLayoutListener(this.s);
        c();
        return this.q;
        this.q.getViewTreeObserver().removeGlobalOnLayoutListener(this.s);
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      break label62;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.clear();
    this.o.setData(null);
    this.p = null;
    ButterKnife.reset(this);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    for (;;)
    {
      return bool;
      if (!this.f) {
        Toast.makeText(getActivity(), "This yak cannot be reported.", 0).show();
      }
      for (;;)
      {
        bool = true;
        break;
        if (CM.a(getActivity()).a("Yak", this.k.b)) {
          Toast.makeText(getActivity(), "You have already reported this comment.", 0).show();
        } else {
          e();
        }
      }
      bool = b(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.g = false;
    if (!this.e) {
      this.mCommentFooter.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.mCommentFooter.setVisibility(0);
    }
  }
  
  @OnClick({2131558633})
  public void onSendCommentClicked()
  {
    String str1;
    if (!this.g)
    {
      this.g = true;
      str1 = this.mReplyField.getText().toString();
      if (!b(str1)) {
        break label120;
      }
      String str2 = CR.a("threatWords", "message", CR.c);
      Intent localIntent = new Intent(getActivity(), YikYakDialog.class);
      localIntent.putExtra("title", "WARNING");
      localIntent.putExtra("message", str2);
      localIntent.putExtra("value", str1);
      localIntent.putExtra("okText", "YES");
      localIntent.putExtra("cancelText", "NO");
      startActivityForResult(localIntent, 7005);
    }
    for (;;)
    {
      return;
      label120:
      a(str1, 0);
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.ui.fragment.CommentFragment

 * JD-Core Version:    0.7.0.1

 */