package com.gildedrose;

/**
 * `ItemFactory` is an enumerated class working as a factory for creating instances of subclasses deriving from `ItemWrapper`.
 * The `ItemFactory` encapsulates the logic to decide which subclass of `ItemWrapper` needs to be instantiated based on the name of the `Item`.
 */
public enum ItemFactory {

    // Each enumerated constant represents a type of inventory item and overwrites the abstract `createItem` method
    // to instantiate a corresponding `ItemWrapper` subclass.
    AGED_BRIE("Aged Brie") {
        @Override
        public ItemWrapper createItem(Item item) {
            return new AgedBrie(item);
        }
    },
    BACKSTAGE_PASSES("^Backstage passes to a .* concert.*") {
        @Override
        public ItemWrapper createItem(Item item) {
            return new BackstagePasses(item);
        }
    },
    BASE_ITEM("null") {
        @Override
        public ItemWrapper createItem(Item item) {
            return new BaseItem(item);
        }
    },
    CONJURED("^Conjured.*") {
        @Override
        public ItemWrapper createItem(Item item) {
            return new Conjured(item);
        }
    },
    SULFURA("^Sulfuras.*") {
        @Override
        public ItemWrapper createItem(Item item) {
            return new Sulfura(item);
        }
    };

    // The `pattern` field is a string that the name of an `Item` object has to match in order for a specific `ItemWrapper` subclass to be instantiated.
    private final String pattern;

    /**
     * Constructor for `ItemFactory` enum type.
     *
     * @param pattern A regex string that the name of an `Item` object needs to match.
     */
    ItemFactory(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Static method generates an instance of an `ItemWrapper` subclass corresponding with the name of the passed `Item`.
     * If no defined types in `ItemFactory` match, a new base item is returned.
     *
     * @param item An instance of `Item` class.
     * @return An instance of the corresponding `ItemWrapper` subclass.
     */
    public static ItemWrapper getByPatternName(Item item) {
        for (ItemFactory itemFactory : ItemFactory.values()) {
            if (item.name.matches(itemFactory.pattern)) {
                return itemFactory.createItem(item);
            }
        }
        return BASE_ITEM.createItem(item);
    }

    /**
     * Abstract method that is overwritten by each enum constant to return a new instance of the corresponding `ItemWrapper` subclass.
     *
     * @param item An instance of `Item` class.
     * @return A new instance of a `ItemWrapper` subclass.
     */
    public abstract ItemWrapper createItem(Item item);
}
