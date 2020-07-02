package chapter06;

import java.util.Optional;
import java.util.ServiceLoader;

public class CiperTest {
    public static void main(String[] args) {
        ServiceLoader<Ciper> load = ServiceLoader.load(Ciper.class);
        Optional<Ciper> ciperOptional = load.findFirst();
        Ciper ciper = ciperOptional.get();
        System.out.println(ciper.demo());

        for(Ciper ciper1 : load) {
            System.out.println(ciper1.demo());
        }
    }
}
