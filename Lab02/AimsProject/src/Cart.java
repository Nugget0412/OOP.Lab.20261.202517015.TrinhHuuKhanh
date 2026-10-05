public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add \"" + disc.getTitle() + "\".");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" is not in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-4d%-30s%8.2f%n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }
        System.out.printf("%-4s%-30s%8.2f%n", "", "Total Cost", totalCost());
        System.out.println("***************************************************");
    }
}
