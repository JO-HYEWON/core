package hello.core.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
//        this.price = price; // 여기가 문제됨. 이렇게 쓰면 좆됨
    }

    public int fixOrder(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price; // 이렇게 써야됨
    }

//    public int getPrice(){
//        return price;
//    }

}
