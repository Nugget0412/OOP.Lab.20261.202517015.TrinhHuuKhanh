public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.print();

        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.print();

        DigitalVideoDisc[] dvdList = {
                new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 21.50f),
                new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f)
        };
        anOrder.addDigitalVideoDisc(dvdList);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Coco");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Up", "Animation", "Pete Docter", 15.00f);
        anOrder.addDigitalVideoDisc(dvd4, dvd5);
        anOrder.print();

        System.out.println("Number of DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
        System.out.println("id of " + dvd1.getTitle() + ": " + dvd1.getId());
        System.out.println("id of " + dvd5.getTitle() + ": " + dvd5.getId());
    }
}
