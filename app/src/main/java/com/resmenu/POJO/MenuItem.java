package com.resmenu.POJO;

import java.io.Serializable;

public class MenuItem implements Serializable {
    int ItemId, ItemRating;
    String ItemName,ItemPic,ItemDescription,ItemPrize;

    public MenuItem(int itemId, int itemRating, String itemName, String itemPic, String itemDescription, String itemPrize) {
        ItemId = itemId;
        ItemRating = itemRating;
        ItemName = itemName;
        ItemPic = itemPic;
        ItemDescription = itemDescription;
        ItemPrize = itemPrize;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getItemRating() {
        return ItemRating;
    }

    public void setItemRating(int itemRating) {
        ItemRating = itemRating;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPic() {
        return ItemPic;
    }

    public void setItemPic(String itemPic) {
        ItemPic = itemPic;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getItemPrize() {
        return ItemPrize;
    }

    public void setItemPrize(String itemPrize) {
        ItemPrize = itemPrize;
    }
}