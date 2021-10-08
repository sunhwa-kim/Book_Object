# Chapter 09. 유연한 설계


> 오브젝트 : 코드로 이해하는 객체지향 설계 &nbsp; / &nbsp; 조영호 저자 &nbsp; / &nbsp; 위키북스
> * 구입처 &nbsp; : &nbsp; [yes24](http://www.yes24.com/Product/Goods/74219491)
    &nbsp; / &nbsp;[교보문고](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158391409&orderClick=LAG&Kc=)
> * 저작권을 존중하고자 노력합니다. (문제시 private 하겠습니다. )
> * 책의 내용과 다릅니다.
>
## reference
* [저자 조영호 님 github](https://github.com/eternity-oop/object)



<br>

---

#### 🔹 숨겨진 의존성은 나쁘다.
의존성 주입 외 의존성 해결방법들


* **SERVICE LOCATOR 패턴**
  > 서비스를 사용하는 코드로부터 서비스가 누구인지(구현한 구체클래스의 타입이 무엇인지), 어디에 있는지(인스턴스를 어떻게 얻을지)를 몰라도 되게 해준다.
    * 의존성 해결할 객체들을 보관
    * ⛔의존성을 감추는 특성이 가장큰 단점이다.
        * 숨겨진 의존성은 캡슐화를 위반한다.


* ⛔ : 의존성 주입이 SERVICE LOCATOR 패턴보다 좋다가 아니라, **명시적인 의존성이 숨겨진 의존성보다 좋다**가 핵심


* Movie에 연결된 DiscountPolicy의 인스턴스가 예상했던 할인정책이 아니라면, DiscountPolicy가 아닌 ServiceLocator의 DiscountPolicy 설정부분을 찾아야 한다.
``` java
  public class Factory {
      public Movie createAvatarMovie() {
        // NPE 발생
  /*		ServiceLocator.provide(new AmountDiscountPolicy(
                                  Money.wons(800),
                                  new SequenceCondition(1),
                                  new SequenceCondition(10)));*/
          return new Movie("아바타",
              Duration.ofMinutes(120),
              Money.wons(10000));
      }
  }
```


* SERVICE LOCATOR 패턴 언제 사용?
    * 직접 객체 넘기는 방식이 불필요하거나 코드를 읽기 어렵게 할 때
    * 본질적으로 하나뿐인 시스템


😃 example of My project <br>
* 당시 객체 생성시 생성자 내에 입력 값에 대한 여러 예외 처리메서드들로 분리 후, 검증 로직을 분리 했었다.
  * 생성 클래스를 생성자에 둘지, 분리 할지 고미하다가 아래처럼 클라이언트 쪽에서 보는게 좋을 거 같단 생각으로 분리 했었다.
  * TDD 방식으로 접근해볼때, 객체 생성시에 2객체의 접근이 이루어져야 하는게 좋지 않은 것 같다는 생각이 들었고,
  * SERVICE LOCATOR 패턴 예를 보면서 디버깅의 상황을 보면, 객체 안에 있어야 하지 않을까 생각이 들었었다.

``` java
	public void isValidPlayerStrategy(String playerNumber) {
		PlayNumber.isValid(playerNumber);
		this.pitcher.strategy(playerNumber);
	}
```


<br>

## 04 의존성 역전 원칙
p. 300


⁉ 아래 모듈 구조의 문제점은? <br>
<img src="https://user-images.githubusercontent.com/66774973/136314614-5e98027f-89f5-4c88-9867-f24db9a1af18.PNG" width="400"> <br>

* ⛔ Movie를 다양한 컨텍스트에서 재사용시 불필요한 클래스들이 같이 배포돼야 한다.
    * OCP 준수, DIP 준수 했음에도


* 변경 : Movie 정상적 컴파일 위해서 DiscountPolicy만 필요 - **SEPARATED INTERFACE 패턴**
  * Movie와 같은 패키지로 DiscountPolicy를 모은다.
  * pricing 패키지에서 DiscountPolicy 를 분리, 별도의 패키지에 위치


<br>


😃 example of My project <br>

* JPA 연결 구현 객체들을 infrastructure로 두고, domain 레이어에 추상클래스를 뒀던 프로젝트가 떠올랐다.
  * 당시에 패키지별로 클래스다이어그램 그려보니 레이어를 어떻게 나누는게 좋을지 확인 할 수 있었다. <br>

<img src="https://user-images.githubusercontent.com/66774973/136578217-783e646e-b201-4ed3-adab-08f967f7f1da.PNG" height="400"> 
<img src="https://user-images.githubusercontent.com/66774973/136578869-f9d20a4a-f62d-4100-9aee-467072ca83e3.PNG" width="500">