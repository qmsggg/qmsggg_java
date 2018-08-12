package qmsggg.cl;

@TestAnnotations2(count = 2)
public class Client {

    public static void main(String[] args) {
        TestAnnotations2 annotations2 = Client.class.getAnnotation(TestAnnotations2.class);
        System.out.println(annotations2.count());

        System.out.println(annotations2.count());
        System.out.println(annotations2.annotationType());
    }
}
