package com.gildedrose;

/**
 * The GildedRose class represents the inventory system of a shop called "Gilded Rose".
 * It manages the items in the inventory and updates their properties based on the rules of the shop.
 */
public class GildedRose {

    protected final Item[] items;

    /**
     * The GildedRose class represents the inventory system of a shop called "Gilded Rose".
     * It manages the items in the inventory and updates their properties based on the rules of the shop.
     */
    public GildedRose(Item... items) {
        this.items = items;
    }

    /**
     * Updates the quality of all items in the inventory based on the rules of the shop.
     * It iterates over the items array and calls the update method on each ItemWrapper object returned by the ItemFactory.getByPatternName method.
     * The update method is responsible for updating the quality of the item, its sell-in value, and performing any additional required update.
     */
    public void updateQuality() {
        for (Item item : items) {
            ItemFactory.getByPatternName(item).update();
        }
    }
}
