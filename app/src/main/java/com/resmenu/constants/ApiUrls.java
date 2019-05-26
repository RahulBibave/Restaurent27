package com.resmenu.constants;

public class ApiUrls {

    // user login
    public static final String mUrlLogin="http://webapi.emenuhotels.in/token";

    // all categotry
    //public static final String mUrlMenuList = "http://webapi.emenuhotels.in/api/Category/GetAllCategory";
    public static final String mUrlMenuList = "http://webapi.emenuhotels.in/api/Menu/GetActiveMenu";

    public static final String mUrlStaff="http://webapi.emenuhotels.in/api/Account/GetWaiters";
//    public static final String mUrlSubCategories = "http://webapi.emenuhotels.in/api/Item/GetItemList?HotelId=1&ItemTypeId=2";
    public static final String mUrlSubCategories = "http://webapi.emenuhotels.in/api/Item/GetItemByMenuId";

   // http://webapi.emenuhotels.in/api/ItemType/GetItemTypeList?HotelId=1
}
