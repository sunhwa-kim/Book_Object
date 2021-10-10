# Chapter 11. 합성과 유연한 설계


> 오브젝트 : 코드로 이해하는 객체지향 설계 &nbsp; / &nbsp; 조영호 저자 &nbsp; / &nbsp; 위키북스
> * 구입처 &nbsp; : &nbsp; [yes24](http://www.yes24.com/Product/Goods/74219491)
    &nbsp; / &nbsp;[교보문고](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158391409&orderClick=LAG&Kc=)
> * 저작권을 존중하고자 노력합니다. (문제시 private 하겠습니다. )
> * 책의 내용과 다릅니다.
>
## reference
* [저자 조영호 님 github](https://github.com/eternity-oop/object)



<br>

p.346


#### ✔ `설계`는 `변경`과 관련된 것이다.
* `코드 재사용을 위해서는` 객체 합성이 클래스 상속보다 더 좋은 방법이다.
* 상속과 합성은 재사용의 대상이 다르다
    * &#8594; 상속대신 합성으로 의존성을 인터페이스로 바꿀수 있다.
    * &#8594; 클래스 간 높은 결합도를 객체간의 낮은 결합도로 대체할수 있다.


> 서브클래싱에 대한 재사용을 `화이트박스 재사용`(white-box reuse)이라고 부른다. `화이트박스`는 `가시성`때문에 나온 말이다. 상속을 받으면 부모 클래스의 내부가 자식 클래스에 공개되기 때문이다. ... <br>
> 객체의 합성은 클래스 상속의 대안이다. ... `블랙박스 재사용`(black-box reuse)이라고 하는데, 객체의 내부는 공개되지 않고 인터페이스를 통해서만 재사용되기 때문이다. <br>
>

<br>

<br>

**포워딩** : 기존 클래스의 인터페이스를 그대로 외부에 제공하면서 구현에 대한 결합없이 일부 작동 방식 변경하고 싶을 때 사용하는 기법 <br>
* **포워딩 메서드** : 동일한 메서드 호출위해 추가된 메서드

<br>

🙊 **몽키 패치**  <br>
Monkey Patch <br>
* 현재 실행중인 환경에만 영향을 미치도록 지역적 코드를 수정/확장 하는 것을 가리킨다.
    * 동적 타입 언어에서는 열린 클래스(Open Class)제공으로, 몽키 패치의 일종으로 볼 수 있다.
    * C#의 확장 메서드(Extension Method), 스칼라의 암시적 변환(implicit conversion) 등
    * `JAVA` 몽키패치를 지원 X
        * 바이트코드 직접 변환
        * AOP (Aspect-Oriented Programing)

<br>

**추상메서드** <br>
* OCP 만족 - 부모클래스에서 새로운 추상메서드 추가하여 부모클래스의 다른 메서드 안에서 호출
* 단점
    * 상속 계층에 속하는 모든 자식 클래스가 추상메서드를 `오버라이딩` 해야한다.
      **훅 메서드** hook method <br>
* 추상메서드와 동일하게 자식 클래스에서 오버라이딩할 의도로 메서드 추가했지만
    * 편의를 위해 기본 구현을 제공하는 메서드

<br>

🌋 **클래스 폭발** class explosion = **조합의 폭발** combination explosion <br>
* 상속의 남용으로 하나 기능 추가위해 필요이상으로 많은 수의 클래스를 추가해야 하는 경우 의미
* 해결위해서는 `상속 포기`

<br>



#### 🔹 상속을 이용해서 기본정책 구현하기


* 😃 복습겸, 계산로직을 세세히 분리시켜보다가, 공통부분에 속하는 seconds 까지 부모클래스로 올려놨다. <br>
    * 매개변수가 많아졋고,
        * 생성자에서 super(seconds)호출, 중복코드 증가, 결합도도 높아짐 ⛔
        * ch10에서 taxRate 추가 예제와 동일한 결과가 나온 것 같다.
            * **책임을 아무리 잘 분리하더라도 인스턴스 변수의 추가는 종종 상속 계층 전반에 걸친 변경을 유발한다.** - p.343
  ``` java
    public abstract class Phone {
        private List<Call> calls = new ArrayList<>();
        private Duration seconds;
    
        public Phone(Duration seconds) {
            this.seconds = seconds;
        }
    
        public void call(Call call) {
            this.calls.add(call);
        }
    
        public Money calculateFee() {
            Money result = Money.ZERO;
            for (Call call : calls) {
                long callFee = call.durationBySec(seconds);
                result = calculateCallFee(result, call, callFee);
            }
            return result;
        }
        protected abstract Money calculateCallFee(Money result, Call call, long secondOfCall);
    }
  ```

<br>


## 03 합성관계로 변경하기
p. 368


* `설계`는 `변경과 유지보수`를 위해 존재한다.
* 설계는 `트레이드오프`의 산물이다.


<br>

#### 🔹 기본정책 합성하기

* 다양한 종류의 객체와 `협력`하기 위해 `합성관계`를 사용시,
    * 합성 객체의 타입을 `인터페이스`나 `추상클래스`로 선언하고
    * `의존성 주입`을 통해 런타임시 필요한 객체 설정할수 있도록 구현


``` java
    public abstract class Phone {
        private List<Call> calls = new ArrayList<>();
        private Duration seconds;
    
        public Phone(Duration seconds) {
            this.seconds = seconds;
        }
    
        public void call(Call call) {
            this.calls.add(call);
        }
    
        public Money calculateFee() {
            Money result = Money.ZERO;
            for (Call call : calls) {
                long callFee = call.durationBySec(seconds);
                result = calculateCallFee(result, call, callFee);
            }
            return afterCalculated(result);
        }
    
        protected Money afterCalculated(Money fee) {
            return fee;
        }
        protected abstract Money calculateCallFee(Money result, Call call, long callFee);
    }
  ```

* 합성 후

  ``` java
    public class NightlyDiscountPhone extends BasicRatePolicy {
        public static final int NIGHT_HOUR = 22;
    
        private Money nightlyAmount;
        private Money regularAmount;
        private Duration seconds;
    
        public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
            // super(seconds);  // bad
            this.nightlyAmount = nightlyAmount;
            this.regularAmount = regularAmount;
            this.seconds = seconds;
        }
    
        @Override
        protected Money calculateCallFee(Call call) {
            long callFee = call.durationBySec(seconds);
            if (call.isNightlyHour(NIGHT_HOUR)) {
                return nightlyAmount.times(callFee);
            }
            return regularAmount.times(callFee);
        }
    }
  ```
  

<br>

## 04 믹스인
p. 379


* 자바 코드와 아주 유사했지만, extends와  with의 조합으로 선형화와 this/super 호출의 참조값의 동적 결정 등
  * 보다 실행시점에 바인딩되고 변경되는 과정을 보면서
  * 유연하면서도 제약이 있을수 있는 예를 보았다.
