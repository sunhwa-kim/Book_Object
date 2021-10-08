# Chapter 10. 상속과 코드 재사용


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


객체지향 프로그래밍의 장점 중 하나는 코드를 재사용하기 용이하다는 것이다. <br>
클래스를 재사용하기 위한 방법으로 상속과 합성이 있다. <br>
이번 챕터는 상속에 관해 살펴보고 <br>
ch11에서는 합성에 대해 살펴보고 상속과 합성의 장단점을 비교할 것이다. <br>



## 02 취양한 기반 클래스 문제
p. 326


#### 🔹 메서드 오버라이딩의 오작용 문제

디버깅 예제 <br>


3 size <br>
<img src="https://user-images.githubusercontent.com/66774973/136505522-b6edf84d-ddc4-405c-94c4-b61352cf6ec0.PNG" width="400"> <br>


⁉ 1. addCount = 6 ?


처음 사이즈 3을 count <br>
<img src="https://user-images.githubusercontent.com/66774973/136505243-5c710de1-627e-43d2-95c4-f211b9321208.PNG" width="400">
<img src="https://user-images.githubusercontent.com/66774973/136505300-17c04e52-ed2a-4a2b-a0eb-37d56f86288c.PNG" width="400"> <br>
super.addAll() -> add() <br>
<img src="https://user-images.githubusercontent.com/66774973/136505358-ec484e52-7d9b-4f93-8ae5-4f3417a68324.PNG" width="400"> <br>
결국 add() 3번 호출, 리스트를 다시 돌며 번복 <br>
<img src="https://user-images.githubusercontent.com/66774973/136505391-40e9418b-0a1a-4493-8439-dac763f2713d.PNG" width="400">
<img src="https://user-images.githubusercontent.com/66774973/136505410-e2510563-e3c1-4c7d-bb98-e74a3486298f.PNG" width="400"> <br>


⁉ 2. addAll() 제거 <br>

* HashSet의 addAll 메서드 호출
* 내부적으로 추가된느 각 요소별로 InstrumentedHashSet의 add() 호출로
* 예상결과 3  <br>
  <img src="https://user-images.githubusercontent.com/66774973/136506831-301047ba-25f4-431c-b553-9dfd3f7c2499.PNG" width="400"> <br>


* ⛔ 나중에 HashSet addAll()가 add메시지 전송되지 않게 수정된다면 ?
    * 현재의 addAll 메서드로 추가되는 카운트는 누락된 결과가 나올 것이다.


⁉ 3. 미래의 수정까지 감안 -

* InstrumentedHashSet의 addAll() 오버라이딩
    * 추가되는 각 요소별로 add() 호출
* ⛔ 오버라이딩된 addAll() 구현이 HashSet과 동일 => 결국 코드 중복
    * 부모클래스 코드를 그대로 가져오는 방법이 항상 가능하지 않을 수 있다.


<br>

#### 🔹 부모 클래스와 자식 클래스의 동시 수정 문제
p.329

* 개인적으로 구현해본 것으로, 일단 `공통 부분`을 위로 올린 방식은 아니다. 
  * 인스턴스 변수가 추가되어 있고.., 11장을 봐야 할 것 같다.

``` java
    public class SingerPlayList extends PlayList {
    
        private Map<String, Singer> singerList = new HashMap<>();
    
        public SingerPlayList() {
        }
    
        @Override
        public void addSong(Song song) {
            super.addSong(song);
            singerList.put(song.singerName(), song.getSinger());
        }
    
        public void showSingerList(String singerName) {
            if (!singerList.containsKey(singerName)) {
                System.out.println("해당 가수는 목록에 없습니다.");
                return;
            }
            Singer singer = singerList.get(singerName);
            singer.showAlbumList();
        }
    }
```