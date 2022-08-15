package me.whiteship.refactoring._05_global_data._01_before;

public class Home {

    public static void main(String[] args) {
        System.out.println(Thermostats.targetTemperature);
        Thermostats.targetTemperature = -1111600;
        Thermostats.fahrenheit = false;
    }
}

/**
 * 전역 데이터
 *
 * - 전역 데이터 (예, 자바의 public static 변수)
 *
 * - 전역 데이터는 아무곳에서나 변경될 수 있다는 문제가 있다.
 *
 * - 어떤 코드로 인해 값이 바뀐 것인지 파악하기 어렵다.
 *
 * - 클래스 변수 (필드)도 비슷한 문제를 겪을 수 있다.
 *
 * - "변수 캡슐화하기 (Encapsulate Variable)"를 적용해서 접근을 제어하거나 어디서 사용하는지 파악하기 쉽게 만들 수 있다.
 */