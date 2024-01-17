package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ItemFactoryTest {

    @Test
    public void testGetItemByPatternName_BaseItem() {
        Item item = new Item("any item", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_AgedBrie() {
        Item item = new Item("Aged Brie", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(AgedBrie.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_BackstagePasses() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BackstagePasses.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Matches_BackstagePasses() {
        Item item = new Item("Backstage passes to a ANY concert", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BackstagePasses.class, itemWrapper);

        item = new Item("Backstage passes to a ANY concert and drink", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BackstagePasses.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Not_Matches_BackstagePasses() {
        Item item = new Item("A Backstage passes to a TAFKAL80ETC concert", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);

        item = new Item("A Backstage passes to a TAFKAL80ETC concert and drink", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Conjured() {
        Item item = new Item("Conjured Mana Cake", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Conjured.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Matches_Conjured() {
        Item item = new Item("Conjured", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Conjured.class, itemWrapper);

        item = new Item("Conjured ANY", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Conjured.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Not_Matches_Conjured() {
        Item item = new Item("A Conjured Mana Cake", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);

        item = new Item("A Conjured", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);

        item = new Item("Conjure", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Sulfura() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Sulfura.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Matches_Sulfura() {
        Item item = new Item("Sulfuras", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Sulfura.class, itemWrapper);

        item = new Item("Sulfuras ANY", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(Sulfura.class, itemWrapper);
    }

    @Test
    public void testGetItemByPatternName_Not_Matches_Sulfura() {
        Item item = new Item("A Sulfuras, Hand of Ragnaros", 10, 10);
        ItemWrapper itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);

        item = new Item("A Sulfuras", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);

        item = new Item("Sulfura", 10, 10);
        itemWrapper = ItemFactory.getByPatternName(item);
        assertInstanceOf(BaseItem.class, itemWrapper);
    }

}

