# 🚇oop-metro

전철역에서 지하철을 이용하거나 교통카드를 충전하는 시스템

## 🚎프로젝트 설명

![oop-metro](https://github.com/ssg-java3-240304/oop-metro/assets/95676035/37f89429-559d-4414-9eab-76d90c353c4f)

### 1. Station
##### 승차와 충전 메뉴 제공
- 임의의 사용자 객체를 생성
- 사용자가 아이디를 입력하면 그 아이디의 사용자 정보를 가져옴
- 사용자는 메뉴에서 1. 승차, 2. 교통카드 충전을 선택
- 사용자가 승차하거나 충전했을 경우 잔액/사용 날짜/유효기간 날짜를 변경한 내역을 userList.txt파일에 저장

### 2. Gate
##### 승차 시 이동 거리, 환승 여부를 물어보는 메뉴 제공
- 승차하기 전, 사용자의 선불카드에 잔액이 부족하거나, 기후동행카드의 유효기간이 만료되었을 경우 다시 Station 메뉴로 돌아감 (check 메소드)
- 사용자는 승차 시 정거장 이동 수를 입력
- 사용자는 이동 후 하차할지, 환승할지 여부를 입력
- 사용자가 입력한 총 정거장 이동 수(stops), 환승 횟수(transfer)와 사용자의 정보(Card 객체, 선불카드일 경우 잔액)를 FeeInvoice에 전달
- FeeInvoice에서 사용자의 정보에 따라 계산한 요금과 잔액/누적 금액 정보를 사용자에게 제공

### 3. Charger
##### 카드 충전 메뉴 제공 및 카드 현황 출력
- 카드 충전 메뉴 제공
- user가 보유한 카드의 충전 메소드 호출하여 충전 진행
- 카드 현황 출력

### 4. FeeInvoice
##### 승하차시 요금 정보 출력 / 탑승 후 잔액 체크
- Gate에서 Card의 정보(card 종류, card가 가지고 있는 user의 기본 요금, card의 잔액(or 누적 금액)), 이동한 정거장 수, 환승 횟수를 받아 승하차 시 ClimateCard라면 만료일 정보를, DeferredCard와 PrepaidCard라면 기본요금과 잔액(or 누적금액) 보여줌
- 탑승 후 잔액을 체크하여 잔액 부족 시 하차 시킴

### 5. User
##### 사용자 정보에 들어갈 필드 값을 설정/가져오기
- 사용자 정보에 들어갈 userId, name, age, price (나이에 맞는 기본 요금), card 종류

### 6. UserRepository
##### 사용자 정보 리스트 저장소
- 임의의 사용자 정보를 리스트에 저장

### 7. Card
##### 사용자가 가지고 있는 카드 객체 저장
- 카드 객체의 생성자, getter/setter, toString 오버라이드를 선언한 부모 클래스

### 8. ClimateCard
##### 기후동행카드의 정보
- 카드 정보 저장(필드, 생성자, getter/setter)
- 충전 기능 제공(충전일 입력, 유효성 체크)

### 9. DeferredCard
##### 후불카드의 정보
- 카드 정보 저장(필드, 생성자, getter/setter)
- 충전 기능 제공(자동결제 날짜 입력, 유효성 체크)

### 10. PrepaidCard
##### 선불카드의 정보
- 카드 정보 저장(필드, 생성자, getter/setter)
- 충전 기능 제공(충전금액 입력, 유효성 체크)


## 💜프로젝트 소감

### 🍒나지영

- Gate, Station, User 담당

주제 선정과 요구사항 정리는 수월하게 진행하였습니다. 하지만 어떤 객체만 도출할지, 그 객체들이 서로 어떻게 상호작용하는지에 대한 3명의 생각이 다 달랐기 때문에 그 의견을 취합하는 과정이 오래 걸렸습니다. 그렇지만 그만큼 다들 구체적으로 생각했기에 많은 경우의 수를 제거할 수 있었고, 열정을 가지고 좀 더 완성도 있는 프로젝트를 제작할 수 있었다고 생각합니다.

전에 프로젝트를 진행했을 땐 주제 선정 후 각자 맡은 부분을 바로 코딩했기 때문에, 제가 맡은 것 외에는 다른 객체들이 어떻게 흘러가는지 이해하기 힘들었습니다. 이번 경험을 통해 프로젝트에 대한 이해와 집중력이 높아질 수 있도록 사전에 객체의 상호작용을 정리하는 시간이 매우 중요하다는 것을 깨달았습니다.

각자의 의견을 존중하고, 이해가 안 가는 부분은 바로 물어볼 수 있도록 이끌어준 팀의 분위기가 너무 좋았습니다. 예상치 못 한 사고로 따로 떨어져 있게 된 저의 참여도를 높일 수 있도록 현장에 있다고 생각할 만큼 소통이 잘 된 팀원분들에게 미안하고 감사합니다.

### 🍉박수빈

- FeeInvoice, UserReposiotry, Station 담당

처음엔 헤매기도 하고 요구사항 도출도 이슈 작성도 쉬운 것 하나 없었습니다. 하지만 많은 대화를 나누고 UseCase 작성도 해보면서 서로의 생각을 맞춰나갔습니다. 그럼에도 아직 요구사항 도출과 이슈 작성 등은 부족하고 어렵지만 당연한 것이라 생각합니다.

테스트하는 과정에서도 많은 테스트 케이스가 발생할 수 있다는 점, 예상치 못한 부분, 여러명이 여러 테스트를 진행해야 한다는 점들을 다시 상기할 수 있던 점도 많은 도움이 된 것 같습니다. 그리고 제가 담당한 파트만 보는 것이 아니라 다른 팀원이 작성한 코드를 보며 전반적인 흐름을 파악하는 것이 중요하다는 사실도 한번 더 깨닫게 되어 배움이 많았던 프로젝트였습니다.

여러 시행착오가 있었음에도 불구하고 팀원들의 노력이 있어서 만족스러운 결과를 만들어내었습니다.

### 🥕정예진

- Card, ClimateCard, DeferredCard, PrepaidCard, Charger, UserRepository, User 담당

추상화하는 과정에서 각자가 생각한 클래스의 구조가 다 달라서 세세한 요구사항들을 합의해 나가는 것이 쉽지는 않았습니다. 그러나 이슈 하나 하나를 해결하면서 객체지향프로그래밍에 대한 이해의 깊이가 한층 깊어지는 것을 느꼈습니다. 각자 맡은 역할에 충실하면서도 서로의 오류를 함께 고민하며 시너지를 얻는 재미를 알게 되었습니다.