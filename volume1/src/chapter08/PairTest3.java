package chapter08;

public class PairTest3 {

    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy");
        var cfo = new Manager("Sid Sneaky");
        var buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        printBuddies(result);
//        System.out.println("first:" + result.getFirst().getName() +
//                ", second:" + result.getSecond().getName());

        maxminBonus(managers, result);
        printBuddies(result);
//        System.out.println("first:" + result.getFirst().getName() +
//                ", second:" + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
            result.setFirst(min);
            result.setSecond(max);
        }
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        if (PairAlg.hasNulls(result)) {
            return;
        }
        PairAlg.swapHelper(result);
        // PairAlg.swap(result);
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
