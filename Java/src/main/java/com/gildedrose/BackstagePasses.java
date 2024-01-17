package com.gildedrose;

/**
 * Subclass `BackstagePasses` extends from `ItemWrapper`.
 * It represents a particular type of item in the inventory.
 * <p>
 * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
 * The Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert.
 */
public final class BackstagePasses extends ItemWrapper {

    /**
     * Constructor for `BackstagePasses` class
     *
     * @param item An instance of `Item` class which this class encapsulates.
     */
    public BackstagePasses(Item item) {
        super(item);
    }

    /**
     * Method to update the quality of the item.
     * The quality of the item is increased by 1 unit.
     * If the sellIn value of the item is less than or equal to 10, the quality is increased by an additional 1 unit.
     * If the sellIn value of the item is less than or equal to 5, the quality is increased by an additional 1 unit.
     *
     * <p>
     * This method is called in the update() method of the subclass BackstagePasses to update the quality of the item
     * based on its sellIn value.
     * </p>
     *
     * @see BackstagePasses#update()
     * @see ItemWrapper#update()
     */
    @Override
    protected void updateQuality() {
        increaseQuality();
        if (item.sellIn <= 10) {
            increaseQuality();
        }
        if (item.sellIn <= 5) {
            increaseQuality();
        }
    }

    /**
     * Method to perform any additional update for the item.
     * If the item is expired, it sets the quality to the minimum quality value.
     */
    @Override
    protected void additionalUpdate() {
        if (isExpired()) {
            item.quality = MIN_QUALITY;
        }
    }
}
