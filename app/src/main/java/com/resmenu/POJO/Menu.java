package com.resmenu.POJO;

import java.io.Serializable;

public class Menu implements Serializable {
    String ItemTypeid,ItemTypeName,ItemTypePic;

    public Menu(String itemTypeid, String itemTypeName, String itemTypePic) {
        ItemTypeid = itemTypeid;
        ItemTypeName = itemTypeName;
        ItemTypePic = itemTypePic;
    }

    public String getItemTypeid() {
        return ItemTypeid;
    }

    public void setItemTypeid(String itemTypeid) {
        ItemTypeid = itemTypeid;
    }

    public String getItemTypeName() {
        return ItemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        ItemTypeName = itemTypeName;
    }

    public String getItemTypePic() {
        return ItemTypePic;
    }

    public void setItemTypePic(String itemTypePic) {
        ItemTypePic = itemTypePic;
    }
}
