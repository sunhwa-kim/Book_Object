# Chapter 01. 객체, 설계

> 오브젝트 : 코드로 이해하는 객체지향 설계 &nbsp; |&nbsp; 조영호 저&nbsp; |&nbsp; 위키북스
> * 구입처 &nbsp; : &nbsp; [yes24](http://www.yes24.com/Product/Goods/74219491)
    &nbsp; / &nbsp;[교보문고](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158391409&orderClick=LAG&Kc=)
>  * 저작권을 존중하고자 노력합니다. (문제시 private 하겠습니다. )
>  * 책의 내용과 다소 다를 수 있습니다. 책을 구매해 주세요.
> 

## 스터디 목표
* 1회독 완독
* Kim SunHwa : 요약 정리
* 2021.08.02~ 08.08 : chapter 01

## reference
* [저자 조영호 님 github](https://github.com/eternity-oop/object)

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
     * 본래 계산 로직은 BigDecimal로 해야하나, 처음에는 간단히 하자는 생각이었다.
     * 계산 결과로 할인율의 Double 등 타입이 달라져서 적용
     