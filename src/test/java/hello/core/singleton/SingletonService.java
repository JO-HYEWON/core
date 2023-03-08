package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    // 자기 자신을 내부에 private으로, static으로 가지고 있으면 클래스 레벨에 존재하기 때문에 딱 하나만 존재하게 된다.
    private static final SingletonService instqance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회 가능
    public static SingletonService getInstance(){
        return instqance;
    }

    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용해 객체 생성을 못하게 막는다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }



}
