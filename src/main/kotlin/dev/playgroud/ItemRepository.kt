package dev.playgroud

class ItemRepository(
    private val items: HashMap<Int, Item> = hashMapOf(
        1 to Item(1, "봉투", 20),
        2 to Item(2, "농심)새우깡1300", 1_300),
        3 to Item(3, "농심)매운새우깡1300", 1_300)
    ),
) {
    fun update(item: Item): Item? =
        this.items.put(item.barcodeNumber, item)

    fun getByBarcodeNumber(barcodeNumber: Int): Item? =
        this.items[barcodeNumber]
}