# Chapter 06. 메시지와 인터페이스

> 오브젝트 : 코드로 이해하는 객체지향 설계 &nbsp; / &nbsp; 조영호 저자 &nbsp; / &nbsp; 위키북스
> * 구입처 &nbsp; : &nbsp; [yes24](http://www.yes24.com/Product/Goods/74219491)
    &nbsp; / &nbsp;[교보문고](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158391409&orderClick=LAG&Kc=)
>  * 저작권을 존중하고자 노력합니다. (문제시 private 하겠습니다. )
>  * 책의 내용과 다릅니다.
>
## reference
* [저자 조영호 님 github](https://github.com/eternity-oop/object)

## 목표
* 1회독 완독, 설계, 객체지향 프로그래밍 학습
* 2021.08.02 ~ 08.08 : chapter 01 by ksh
* 2021.08.09 ~ 08.15 : chapter 02 by ksh
* 2021.08.16 ~ 08.22 : chapter 03, 04 by ksh
* 2021.08.23 ~ 08.29 : chapter 05 by ksh
* 2021.08.30 ~ 09.12 : chapter 06, 07 by ksh


---

> 유연하고 재사용 가능한 퍼브릭 인터페이스 &#8594; 설계 원칙 & 기법
> 


## 01. 협력과 메시지
p. 176

### 01-1. 클라리언트 - 서버 모델

: 협력 관계를 설명하기 위한 전통적 메타포

* **협력** : 클라이언트가 서버의 서비스 요청하는 단방향 상호작용
  * 객체는 협력에 참여하는 동안 <u>클라이언트와 서버의 역할을 동시 수행</u>
    * **메시지** : 두 객체 간 협력의 매개체
      * 객체가 수신하는 메시지 집합
      * 외부 객체에게 전송하는 메시지 집합
      * 협력에 참여하는 전송자와 수신자 양쪽 모두 포함한 개념

* 클라이언트
  * 메시지 전송자
    * 메시지만 안다.
* 서버
  * 메시지 수신자
    * 메시지 도착만 알고, 처리위한 메서드는 자율적 결정
    
* 메시지 전송자와 수신자 느슨한 결합
  * 오퍼레이션 호출 (퍼블릭 인터페이스의 메시지)
  * 시그니처 &#8594; 다형성



### 01-2. 메시지와 메시지 전송

* 요청 : 메시지 전송(message sending), 메시지 패싱(message passing)
 
> 메시지 : 오퍼레이션명 + 인자 <br>
> 메시지 전송 : 메시지 + 메시지 수신자 = 오퍼레이션명 + 인자 + 메시지 수신자 <br>
>  

``` java
     condition.isSatisfied(screening);
```

  * condition : 메시지 수신자
  * isSatisfied : 오퍼레이션명
  * (screening) : 인자


### 01-3. 메시지와 메서드

> 메시지 수신자의 실제 타입은 무엇인가? <br>
> 객체는 메시지와 메서드라는 2가지 서로 다른 개념을 실행시점에 연결해야 하기 때문에 컴파일 시점과 실행 시점의 의미기 달라질 수 있다.<br>
>  실행 시점에 메시지와 메서드를 바인딩하는 메커니즘은 <br>
>  두 객체 사이의 결합도를 낮춰 유연하고 확장 가능한 코드를 작성할 수 있게 한다. 
> <br>


``` java
  condition.isSatisfied(screening);
```

* 메시지 수신자 condition
  * 정의 (컴파일 시점) : DiscountCondition 인터페이스 타입
  * 실행 코드 : 인터페이스의 구현 클래스
    * PeriodCondition의 isSatisfiedBy() 메서드
    * SequenceCondition의 isSatisfiedBy() 메서드


### 01-4. 퍼블릭 인터페이스와 오퍼레이션

> 퍼블릭 인터페이스 : 객체가 의사소통을 위해 외부에 공개하는 메시지 집합 <br>
> 오퍼레이션 operation : 수행가능한 행동에 대한 추상화 = 퍼블릭 인터페이스에 포함된 메시지 <br>
> <br>

``` java
  condition.isSatisfied(screening);
```
* isSatisfied : 오퍼레이션명
  * 메서드 호출 &#8594; 오퍼레이션 호출
  * UML
    * 오퍼레이션 : 인터페이스와 각 요소 - 추상화
      * 시그니처
    * 메서드 : 시그니처 + 구현 (오퍼레이션의 구현)
    


> 😃 헷갈리니 다시 정리해보자. <br>
* **<mark>메시지</mark>** : 협력에 참여하는 전송자와 수신자 모두 포함하는 개념
  * 메시지 전송자와 수신자 느슨한 결합 (서로 내용은 모른다.)
  * 메시지 수신자 실제 타입 : 실행시점에 메시지와 메서드 바인딩
    * 메시지가 (퍼블릭 인터페이스와 )오퍼레이션 결정

    * <mark>**메시지 전송**</mark> : 메시지 + 메시지 수신자 = 오퍼레이션명 + 인자 + 메시지 수신자
      * 오퍼레이션명 + 인자
      * 퍼블릭 인터페이스 : 외부에 공개하는 메시지 집합
        * 오퍼레이션 : 퍼블릭 인터페이스의 메시지 (추상화)
    * <mark>**메시지 수신**</mark>
      * 오퍼레이션의 시그니쳐 == 메서드 실행
      * 메서드 : 시그니처 + 구현 (오퍼레이션의 구현)

    * 다형성 : 동일한 오퍼레이션 호출에 대해 (시그니처 맞는)서로 다른 메서드 실행


###  ✔ 용어 정리
* 메시지
  * 객체간 협력을 위한 의사소통 메커니즘
  * 메시지 전송 : 객체의 오퍼레이션이 실행되도록 요청하는 것
  * 협렵에 참여하는 전송자, 수신자 모두 포함하는 개념
* 오퍼레이션
  * 객체간 제공하는 추상적 서비스
  * 메시지 수신하는 객체의 인터페이스 강조
  * 메시지 수신 : 메시지에 대응되는 객체의 오퍼레이션 호출
* 메서드
  * 메시지에 응답하기 위해 실행되는 코드 블록
  * 오퍼레이션의 구현
  * 다형성의 개념으로 오퍼레이션과 메서드 구분
    * 동일한 오퍼레이션에 대해 메서드는 다를 수 있다.
* 퍼블릭 인터페이스
  * 외부에서 수신할 수 있는 메시지의 집합
  * 클래스의 퍼블릭 메서드들의 집합
  * 객체 설계 &#8594; 퍼블릭 인터페이스 설계
* 시그니처
  * 오퍼레이션이나 메서드의 명세
  * 이름과 인자의 목록 포함
  * 일부언어 반환 타입도 시그니처 일부로 포함



---

## 02. 인터페이스와 설계 품질
p.181

> 좋은 인터페이스 &#8594; 책임주도 설계 방법


* ch03 - 좋은 인터페이스
  * 최소한의 인터페이스 : 꼭 필요한 오퍼레이션만 포함
  * 추상적 인터페이스 : 무엇을 하는지 표현
* 책임주도 설계 방법
  * 협력에 적합한 메시지로 메시지를 먼저 선택
    * 협력에 관련된 죄소의 오퍼레이션만 포함
  * 메시지가 객체를 선택
    * 클라이언트 의도를 메시지에 표현(오퍼레이션  &#8594; 인터페이스)
    * 협력에 적합한 메시지 결정 확률 up


> 퍼블릭 인터페이스 품질에 영향 미치는 원칙과 기법들 <br>
* 디미터 법칙
* 문지 말고 시켜라 Tell, Dont's Ask
  * 상태를 묻는 오퍼레이션을 행동 요청하는 오퍼레이션으로 대체하여 인터페이스를 향상시켜라. p.187
* 의도를 드러내는 인터페이스
* 명령-쿼리 분리


### 02-1. 디미터 법칙

* 디미터 법칙 Law of Demeter
  * 협력하는 객체의 내부 구조와의 결합으로 발생된 설계 문제 해결위해 제안된 원칙
  * 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라.
    * 부끄럼타는 코드 shy code
      * 클라이언트와 서버 간 낮은 결합도
        * 메시지 전송자에게 노출되지 않는 메시지 수신자 내부구조
          * 기차 충돌 train wreck ⛔
        * 메시지 수신자의 내부 구현에 결함되지 않는 메시지 전송자
        

#### 디미터 법칙과 캡슐화
* 캡슐화의 다른 관점으로, 클래스 캡슐화 위한 구체적 지침 제공
  * 캡슐화는 클래스의 내부 구현을 감출 것을 강조
  * 디미터 법칙은 협력하는 클래스의 캡슐화를 지키기 위해 <u>접근요소를 제한</u>
    * 협력 클래스와 클래스의 내부 구현을 유기적 개념으로 연결


* ch04 - 절차지향적 코드

``` java
  public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer,
                               int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for(DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }
```

<br>

* ch04 - 수정 결과 코드

``` java
  public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
  }
```

<br>

#### 디미터 법칙 위반 코드 - 기차 충돌

``` java
  screening.getMovie().getDiscountConditions();
```
😃 getMvoie() 는 Screecning의 인스턴스 변수의 클래스 이겠지 &#8594; 협력 객체간 메시지 조건 만족
* ❌  인스턴스 변수? &#8594; 내부 구조 물은 후 실행
* ❌  screening이 할인 조건을 알아내는 역할?

<br>

* 내부 구현 노출
  * 메시지 전송자가 메시지 수신자의 내부 정보 알 수 있다.
  * 캡슐화 위반, 높은 결합도
  * 메시지 전송자는 메시지 수신자의 내부 구조에 묻지 않는다.
``` java
  screening.calculateFee(audienceCount);
```
😃 screenig은 가격 요청  &#8594; 누군가 어떻게 해서든 주겠지


### 02-2. 묻지말고 시켜라
Tell, Don's Ask.

> 상태를 묻는 오퍼레이션을 행동 요청하는 오퍼레이션으로 대체하여 인터페이스를 향상시켜라. <br>
> 협력을 설계하고, 객체가 수신할 메시지 결정을 묻지 말고 시켜라 <br>
> 인터페이스는 객체가 어떻게 하는지가 아니라, **무엇을 하는지 서술**해야 한다. 어떤 작업을 수행하는지 노출하지 않는다.<br>

#### 정보 전문가
* ch05 GRASP
* 객체 정보 이용하는 행동이 외부로 노출되지 않는다.
* <mark>**정보와 행동을 동일한 클래스에 둔다. (최대한 가까이 위치)**</mark>
* 높은 응집도
* 정보 != 데이터
  * 정보 알고 있다. != 정보 저장하고 있다.


``` java
  screening.getMovie().getDiscountConditions();
```
#### ❌ 이유
* 기차 충돌
* 메시지 전송자가 (객체 외부)
  * 메시지 수신자의 상태 기반으로 결정 ✖ - 캡슐화 위반
  * 메시지 수신자의 상태 변경 ✖️
* 메시지 수신자의 책임!


### 02-3. 의도를 드러내는 인터페이스

> 메서드명 짓기<br>
> 의도를 드러내는 선택자 ,  Intention Revealing Selector by 켄트 백 <br>
> 의도를 드러내는 인터페이스 ,  Intention Revealing Interface by 에릭 에반스 <br>
> 

* **무엇을 하는지** 드러내도록 메서드 이름 짓기
  * 객체가 협력 안에서 수행해야 하는 책엠에 대해 고민
    * 메시지 전송 목적 생각
    * 클라이언트의 의도 부합한 메서드명

1. ch05_step01
  * DiscountCondition 내
    ``` java
       private boolean isSatisfiedByPeriod(Screening screening) {
            return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                    startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                    endTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0;
        }
  
        private boolean isSatisfiedBySequence(Screening screening) {
            return sequence == screening.getSequence();
        }
    ```

2. ch05_step02
  * 클래스 분리
    ``` java
    public class PeriodCondtion {
        public boolean isSatisfiedByPeriod(Screening screening) {
            return (생략);
        }
    }
  
    public class SequenceCondition {
        public boolean isSatisfiedBySequence(Screening screening) {
            return sequence == screening.getSequence();
        }
    }
    ```
    
    * 메서드명이 다르다
      * 두 메서드는 동일한 작업을 수행하지 않는다. ❌
      * 실제 할인조건 판단하는 동일 작업 수행
    * 메서드 수준에서의 캡슐화 위반
      * 책임을 수행하는 방법을 드러내는 메서드 사용한 설계는 변경에 취약
        * 클라이언트가 협력하는 객체의 종류를 알도록 강요
          * PeriodCondtion &#8594; SequenceCondition 변경시
            * 객체 변경
            * 메서드 변경
            * ➕ 할인 여부 판단 로직 변경시 메서드명도 변경


3. 클라이언트 관점에서의 협력을 보고, 클라이언트의 의도를 담는다.
    ``` java
      public boolean isSatisfiedBy(Screening screening)
    ```

  * 동일한 메서드명 &#8594; 동일한 목적
    

4. **JAVA : 정적 타이핑 언어는 메서드명이 같다고 동일한 메시지 처리 할 수 없다.**

* **의도를 드러내는 인터페이스**
  * 구현과 관련된 내용은 모두 캡슐화 하고
  * 객체의 퍼블릭 인터페이스에는 협력가 관련된 의도만을 표현해야 한다.
    * 수뱅 방법은 언급하지 말고
    * 결과와 목적만 포함하도록 클래스와 오퍼레이션 이름을 부여하라.
    * 클라이언트 개발자는 내부를 이해할 필요성이 줄어든다.
  * 도메인의 퍼블릭 인터페이스에서는 관계, 규칙 시행방법이 아닌 **이벤트와 규칙**만 명시한다.
    * 이벤트? p.205


* 동일한 타입 계층으로 묶어야 한다.
  * ch05_step03
  ``` java
    public interface DiscountCondition {
        boolean isSatisfiedBy(Screening screening);
    }
  ```
  * **DiscountCondition 인터페이스 정의, 인터페이스에 isSatisfiedBy 오퍼레이션 정의**
  * **DiscountCondition 실체화로 클라이언트는 두 메서드 동일한 방식으로 사용 가능**
    * implements DiscountCondition

    ``` java
      public class PeriodCondtion implements DiscountCondition {
          public boolean isSatisfiedBy(Screening screening) {
              return (생략);
          }
      }
    
      public class SequenceCondition implements DiscountCondition {
          public boolean isSatisfiedBy(Screening screening) {
              return sequence == screening.getSequence();
          }
      }
    ```


### 02-4. 함께 모으기

> 실제 예를 참고하며 원칙 위반 코드들을 살펴보자.

* ch01 - Theater
* Theater 를 시작으로 수정하며 , 클래스 분리하고, 객체 지향적 프로그래밍 실습하기
  * 협력관계하 메시지 중심으로 보고자, 일단 세부 구현은 패스 - 실행X
``` java
  public class Theater {
      private TicketSeller ticketSeller;
  
      public Theater(TicketSeller ticketSeller) {
          this.ticketSeller = ticketSeller;
      }
  
      public void enter(Audience audience) {
          if (audience.getBag().hasInvitation()) {
              Ticket ticket = ticketSeller.getTicketOffice().getTicket();
              audience.getBag().setTicket(ticket);
          } else {
              Ticket ticket = ticketSeller.getTicketOffice().getTicket();
              audience.getBag().minusAmount(ticket.getFee());
              ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
              audience.getBag().setTicket(ticket);
          }
      }
  }
```

[sunhwa-git](https://github.com/sunhwa-kim/Book_Object/tree/main/object/ch06/step02)

#### 묻지 말고 시켜라
<br>

* 조건분기문 로직의 공통 결과 audience.setTicket(ticket);
  * ticketSeller.getTicket();
    * ticket 가진 TicketSeller에게 위임
    * ticket이 필요한 객체? Audience
      * TicketSeller가 Audience에게 ticket 전달
``` java
  ticketSeller.setTicket(audience);
```
<br>

  * Audience
    * Bag에게 묻지 말고 시키기
      * hasInvitation()
      * minusAmount()

<br>

#### 인터페이스에 의도를 드러내자

 * 동일한 메서드명 setTicket() 모두 같은 역할?
   * ticketSeller.setTicket(audience);
     * 판매역할
     * ticketSeller.sellTo(audience);
   * audience.setTicket(getTicket());
     * 구매역할
     * audience.buy(getTicket());
   * bag.setTicket(ticket);
     * 결제,.. 보관
     * Audience 안의 bag은 보관 - 클라이언트 의도
     * bag.hold(ticket);
     