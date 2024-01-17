package com.gildedrose;

/**
 * An abstract sealed class that serves as a blueprint for various types of inventory items.
 * Being a sealed class, it permits a restricted set of subclasses namely 'AgedBrie', 'BackstagePasses', 'BaseItem', and 'Legendary'.
 * It provides a default mechanism to update an item's quality and sell-in values which can be overridden by the subclasses.
 */
public abstract sealed class ItemWrapper permits AgedBrie, BackstagePasses, BaseItem, Legendary {

    // Constants denoting the minimum and maximum quality an item can have and the day an item expires.
    protected final int MIN_QUALITY = 0;
    protected final int MAX_QUALITY = 50;
    protected final int EXPIRED_DAY = 0;

    // 'item' represents an instance of the 'Item' class which this wrapper class encapsulates.
    protected final Item item;

    /**
     * Constructor for ItemWrapper class.
     *
     * @param item An instance of 'Item' class.
     */
    public ItemWrapper(Item item) {
        this.item = item;
    }

    /**
     * Method to update an item's properties.
     * Firstly, it updates the quality of an item, then its sell-in value, and finally performs any additional required update.
     */
    public final void update() {
        updateQuality();
        updateSellin();
        additionalUpdate();
    }


    /**
     * This method is responsible for updating the quality of an item.
     * It decreases the quality of the item by 1 unit, to a minimum of 0.
     * This method is called in the {@link #update()} method of the `ItemWrapper` class to update the quality of the item.
     */
    protected void updateQuality() {
        decreaseQuality();
    }


    /**
     * Method to update the sell-in value of an item.
     * It decreases the sell-in value of the item by 1 unit.
     * It's declared 'protected' and thus is only accessible within the class and its subclasses.
     * This method is called in the {@link #update()} method of the `ItemWrapper` class to update the sell-in value of the item.
     */
    protected void updateSellin() {
        decreaseSellin();
    }


    /**
     * This method is responsible for performing any additional updates specific to the item.
     * It checks if the item has expired and decreases its quality if it has.
     * This method is called in the {@link #update()} method of the {@link ItemWrapper} class
     * to update the item's quality.
     */
    protected void additionalUpdate() {
        if (isExpired()) {
            decreaseQuality();
        }
    }

    /**
     * This method is responsible for decreasing the quality of an item.
     * It decreases the quality of the item by 1 unit, to a minimum of 0.
     * This method is called in the updateQuality() method of the ItemWrapper class to update the quality of the item.
     */
    protected final void decreaseQuality() {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    /**
     * Method to increase the item's quality by 1 unit, to a maximum of 50.
     * It's declared 'final' and thus cannot be overridden by subclasses.
     */
    protected final void increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    /**
     * Method to decrease the item's sell-in value by 1 unit.
     * It's declared 'final' and thus cannot be overridden by subclasses.
     */
    protected final void decreaseSellin() {
        item.sellIn--;
    }

    /**
     * Method to check if the item has expired.
     * It returns true if the item's sell-in value is less than the expiry day.
     * It's declared 'final' and thus cannot be overridden by subclasses.
     *
     * @return true if item's sellIn is less than EXPIRED_DAY, false otherwise
     */
    protected final boolean isExpired() {
        return item.sellIn < EXPIRED_DAY;
    }
}
