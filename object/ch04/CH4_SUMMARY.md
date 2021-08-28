# Chapter 04. 설계 품질과 트레이드오프

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
* 2021.08.02 ~ 08.08 : chapter 01
* 2021.08.09 ~ 08.15 : chapter 02
* 2021.08.16 ~ 08.22 : chapter 03, 04


---



#### p.117 ~ my_step02

* 앞 부분은 데이터 중심 설계 차이를 알아보고자, 교재 대로 학습
* step01에서의 코드를 interface 등을 쓰지 않고 코드 자체에서만 수정해보기

* DiscountCondition
    * 일단, ReservationAgency의 Movie에서 DiscountCondition 꺼내는 걸 줄여보자
        * Movie 가 조건 책임지게 수정 -> 객체가 책임 : DiscountCondition

* Movie
    * ReservationAgency의 Movie는 영화 한 표당 가격계산시 필요
        * Movie가 조건에 따라 영화 티켓 한 장의 가격 계산
        * ReservationAgency는 결과만 받게 수정
    * isDiscountable(screening)
        * 조건을 맞춰 할인 여부 로직이 해당 메서드의 책임이라면, Screening을 보내야 한다고 생각
            * Movie의 많은 데이터를 공개하는 코드가 없어졌다.
        * But, Movie와 Screening간 강한 결합력
            * 앞의 챕터가 아른아른
        * 교재에서 데이터 중심의 작업이 이해되기 시작, 가진 데이터 중심으로 행동하도록 작업하게 되어있었다.

* Screening
    * 인원수에 따른 조건에 맞춘 가격 계산



* Movie와 DiscountCondition 간의 결합도
    * 할인 조건 명칭 변경시
    * 할인 조건 종류 추가/삭제시 if-else 구문 수정
    * isDiscountable에 필요한 정보 변경시 파라미터 변경 - DiscountCondition, Movie, Screening 모두 변경
        * 내 코드는 2개만 변경 ㅎㅎ

