# Chapter 01. 객체, 설계

> 오브젝트 : 코드로 이해하는 객체지향 설계 &nbsp; |&nbsp; 조영호 저&nbsp; |&nbsp; 위키북스
> * 구입처 &nbsp; : &nbsp; [yes24](http://www.yes24.com/Product/Goods/74219491)
    &nbsp; / &nbsp;[교보문고](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158391409&orderClick=LAG&Kc=)
>  * 저작권을 존중하고자 노력합니다. (문제시 private 하겠습니다. )
>  * 책의 내용과 다릅니다.
>
## reference
* [저자 조영호 님 github](https://github.com/eternity-oop/object)

## 목표
* 1회독 완독, 설계, 객체지향 프로그래밍 학습
* 2021.08.02~ 08.08 : chapter 01
* 2021.08.09~ 08.15 : chapter 02


## step 1
 #### p.41 도메인 설계해보고 클래스 구현하기
 * 예매 객체에서 생각보다 movie 참조가 많이 생겼다.
    * encapsulation
     
#### DicsountPolicy
 * 할인 정책을 Movie 도메인에 두기로 결정 
     * 할인 정책의 주선자는? 
       * 상영관 : 영화별 적용 &#8594; 고객에게 일괄 제공
       * 영화사 : 영화별 적용 &#8594; 고객에게 일괄 제공
       * 회원의 포인트 : 상영관 정책 &#8594; 고객 선택
       * 회원 등급 혜택 : 상영관 정책 &#8594; 고객 선택

 * interface DiscountPolicy
    ``` java
        public interface DiscountPolicy {
           BigDecimal calculateDiscount(Screening screening);
           BigDecimal getDiscount(Screening screening);
        }
    ```
   * BigDecimal 반환 타입
     * 본래 계산 로직은 BigDecimal 이지만, 처음에는 간단히 하자는 생각이었다.
     * 계산 결과로 할인율의 Double 등 타입이 달라져서 객체 타입 적용
    
  #### DiscountCondition
  * Movie마다 적용되는건 DiscountPolicy
  * 할인 조건은 상영관/영화사에서 결정
     * 해당 조건에 맞는 영화에게만 할인 적용되게 해야 한다.
    

  #### 문제
* 하단의 테스트 결과 출력을 위한 날짜 출력 메서드가 너무 많다.
  * 실제 로직과 다르기 때문에 별도 분리 필요
* BigDecimal과 Integer로 통일성 갖출 필요가 있다. 
  * 만일 수정시 수정이 복잡해질 수 있고, 오류 발생률이 높다.
    
* step1. result of Test.java<br>
    <img src="https://user-images.githubusercontent.com/66774973/128636852-6b544fc6-15e1-46f9-a6f1-86798f653da0.png" width="300"> 

     