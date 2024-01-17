package com.gildedrose;

/**
 * `Sulfura` is a subclass of `Legendary` and represents a specific kind of legendary item.
 * Unlike other items, `Sulfura's` quality and sell-in values remain unchanged over time.
 * Therefore, the methods to update quality and sell-in are overridden and left empty.
 */
public final class Sulfura extends Legendary {

    /**
     * Constructor for `Sulfura` class.
     *
     * @param item An instance of `Item` class which this class encapsulates.
     */
    public Sulfura(Item item) {
        super(item);
    }
}
