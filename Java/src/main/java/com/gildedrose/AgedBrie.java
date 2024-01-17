package com.gildedrose;

/**
 * `AgedBrie` is a subclass of `ItemWrapper`, representing a distinctive type of item in an inventory system.
 * Aged Brie has its own unique behavior when updating its state (e.g., quality), it increases in quality as it gets older.
 * It overrides some methods from `ItemWrapper` to fit its characteristics.
 */
public final class AgedBrie extends ItemWrapper {


    /**
     * Constructor for `AgedBrie` class. Accepts an item and constructs an `AgedBrie` object.
     *
     * @param item An instance of `Item` class which this class encapsulates.
     */
    public AgedBrie(Item item) {
        super(item);
    }

    /**
     * For the `AgedBrie` item, it increases the quality of an item,
     * it can be overridden in subclasses to provide a unique mechanism to update the quality.
     */
    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    /**
     * For the `AgedBrie` item, the `additionalUpdate` method does not perform any operation.
     * This method can be overridden in the subclasses to provide additional required updates.
     */
    @Override
    protected void additionalUpdate() {
        if (isExpired()) {
            increaseQuality();
        }
    }
}
