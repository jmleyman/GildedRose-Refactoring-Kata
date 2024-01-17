package com.gildedrose;

/**
 * The `Legendary` class is an abstract sealed class that serves as a blueprint for various types of legendary items in the inventory system.
 * Unlike regular items, legendary items do not experience a change in quality or sell-in values over time.
 * It provides default implementations for updating quality, updating sell-in, and performing additional updates specific to legendary items.
 */
public sealed abstract class Legendary extends ItemWrapper permits Sulfura {

    /**
     * Constructor for `Legendary` class.
     *
     * @param item An instance of `Item` class which this class encapsulates.
     */
    public Legendary(Item item) {
        super(item);
    }

    /**
     * This method is responsible for updating the quality of the item.
     * The updateQuality() method is overridden in subclasses to provide the specific behavior for each type of item.
     * For the base ItemWrapper class, the behavior is to decrease the quality of the item by 1 unit, to a minimum of 0.
     * This method is called in the update() method of the ItemWrapper class to update the quality of the item.
     */
    @Override
    protected void updateQuality() {
    }

    /**
     * This method is responsible for updating the sell-in value of the item.
     * It decreases the sell-in value of the item by 1 unit.
     * This method is called in the update() method of the ItemWrapper class to update the sell-in value of the item.
     */
    @Override
    protected void updateSellin() {
    }

    /**
     * This method is a hook for subclasses to perform additional updates specific to their item type.
     * <p>
     * The method is currently empty and does not perform any operations. Subclasses can override this method
     * to provide their own implementation to update specific properties or behavior for their item type.
     * <p>
     * This method is called in the {@link #update()} method of the {@link ItemWrapper} class,
     * after updating the quality and sell-in values of the item.
     */
    @Override
    protected void additionalUpdate() {
    }
}
