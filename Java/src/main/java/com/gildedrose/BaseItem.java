package com.gildedrose;

/**
 * `BaseItem` is a subclass of `ItemWrapper` representing a basic or default type of item in an inventory system.
 * It does not override any method from `ItemWrapper` class, thus it uses the default mechanisms to update the quality and sell-in values.
 */
public non-sealed class BaseItem extends ItemWrapper {

    /**
     * Constructor for `BaseItem` class.
     *
     * @param item An instance of `Item` class which this class encapsulates.
     */
    public BaseItem(Item item) {
        super(item);
    }
}
