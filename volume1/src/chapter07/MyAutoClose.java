package chapter07;

public class MyAutoClose implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new Exception("MyAutoClose throw Exception");
    }
}
