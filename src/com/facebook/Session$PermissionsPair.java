package com.facebook;

import java.util.List;

class Session$PermissionsPair
{
  List<String> declinedPermissions;
  List<String> grantedPermissions;
  
  public Session$PermissionsPair(List<String> paramList1, List<String> paramList2)
  {
    this.grantedPermissions = paramList1;
    this.declinedPermissions = paramList2;
  }
  
  public List<String> getDeclinedPermissions()
  {
    return this.declinedPermissions;
  }
  
  public List<String> getGrantedPermissions()
  {
    return this.grantedPermissions;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.PermissionsPair
 * JD-Core Version:    0.7.0.1
 */