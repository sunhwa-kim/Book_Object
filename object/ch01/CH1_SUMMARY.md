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

### step 1
> 기본 소스는 저자님의 github에 있습니다.
   <br>교재의 내용과 다름니다. <br> 저의 생각과정을 담았습니다. 

1. 기본 레이어드에 따른 패키지 별로 담아서, 객체의 역할을 찾아보기.
  * Audience와 Bag를 구분 지은 이유는?
    * Audience 
      * 클라이언트에서 오는 요청 객체 : __AudienceRequest__
      * 사용자 : __Audience entity__ ( != 회원 - 식별자, id 등 부여 )
    * Bag
      * 교재 :  관람객의 소지품으로, 결제 방식의 주도는 관람객에게 있다. (step2)
      * 다르게 보면, 소극장에서 제공하는, 공연 관람을 이용하기 위한 클라이언트의 결제 방식으로
        * 결제 방식의 제한에 대한 권한은 소극장에 있다 ;)
     <br>
          
   * TicketSeller는 Thearter에서 클라이언트상에 쓰이고 있다. => interface 일 것 같다.
   * Theater는 비즈니스 로직을 담당하는 것 같다 => service layer
     * 객체로 보이지 않는다.
   * TicketOffice의 remove() 전 empty 확인 추가
     
        ``` java
            if(tickets.isEmpty()) return (Ticket) tickets;
        ```

---

### step 2

> 교재 & 로버트 마틴's "클린 소프트웨어"
>  * 소프트 웨어 모듈이 가져야 하는 3가지 기능
>  * 모듈 : 크기와 상관 없이 클래스나 패키지, 라이브러리와 같이 프로그램을 구성하는 임의의 요소
>    * 첫번째. 제대로 실행 돼야 한다.
>    * 두번째, 변경이 용이해야 한다.
>    * 세번째, 이해하기 쉬어야 한다.


#### 1. 이해하기 어렵고, 변경이 용이하지 않다.?

* Theater.class 

    ``` java
        public void enter(Audience audience) {
            if (audience.getBag().hasInvitation()) {
                Ticket ticket = ticketSeller.getTicketOffice().getTicket();
                audience.getBag().setTicket(ticket); } 
            else {
                Ticket ticket = ticketSeller.getTicketOffice().getTicket();
                audience.getBag().minusAmount(ticket.getFee());
                ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
                audience.getBag().setTicket(ticket);
            }
        }
    ```
  
 
#### 2. 설계 개선하기
* 소스 보기 전 고쳐보기 : 패키지 ch01/my_step02
> 객체의 자율성 높이는 방향으로 설계 -> 이해 쉽고, 유연한 설계

* 캡슐화와 응집도
* 절차지향과 객체지향
    * 절차지향 : 데이터와 프로세스를 나누어 별도의 클래스에 배치
* 책임의 이동

참고 : [객체지향 개발 5원칙](https://www.nextree.co.kr/p6960/)

* __encapsulation__
    * SRP, DIP
* __interface와 구현으로 나누고 인터페이스만 공개__
    * OCP, DIP
* __cohesion__
    * 응집도가 높다 : SRP


### step 3
* encapsulation에 집중한 작업만으로 step3과 비슷해져 있었다.
  * 내 코드와 비교해보며, 생각지 못 한 점 등을 정리
   
#### 1. this.setTicket(ticket);
&nbsp; 본래 ```this.setTicket(ticket);``` 이 if/else에 중복으로 있었다.
  * 중복 되는 것 갖고, return 전의 메서드 시작시 미리 진행하게 한다면?
    * 로직은 초대장 여부 확인 후 티켓을 제공
    * 로직이 변경되도록 놔둘 것이닞 고민하다가, 차라리 ```butTicket()``` 메서드를 만들어 뒀다.
    * 초대장이 있으면 티켓으로 바꿔주고(메서드명 바꾸는게 좋겠지만..), 없으면 구매하는게 보이도록 했다.
    ``` java
        public Long hasInvitation(Ticket ticket) {
            if(invitation != null){
                this.setTicket(ticket);
                return 0L;
            }
            else{
                this.buyTicket(ticket);
                return ticket.getFee();
            }
        }
    ```
    
#### 2. TicketOffice와 Audience 간 추가된 의존성
 > 교재
 > 트레이드옾의 시점이 왔다. 어떤 것을 우선해야 하는가?
 > 1. 어떤 기능을 설계하는 방법은 한 가지 이상일 수 있다.
 > 2. 동일 기능을 한 가지 이상의 방법으로 설계할 수 있기 때문에 결국 설계는 트레이드오프의 산물이다.

### 객체지향 설계
* 설계를 구현과 떨어트려서 이야기하는 것은 불가능하다.
* 변경 가능한 코드란 이해하기 쉬운 코드다.
    * 객체들로 구성, 객체들 간 상호작용 통한 구현
* 객체 사이의 의존성을 적절하게 관리하는 설계

