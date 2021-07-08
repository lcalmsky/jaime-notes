얼마전 M1 24인치 iMac을 장만한 하였습니다.

드디어 회사 맥북이 아닌 제 소유의 아이맥을 가지게되어 기쁜 마음도 잠시.. 회사에서 쓰던 내용을 그대로 migration하기 싫어서 일일히 수동세팅을 하는 중입니다.

(이번 기회에 안 쓰던-또는 생각이 안 나는- 앱 및 설정들은 철저히 배제할 예정)

혹시 나중에도 비슷한 경험을 하게될 것을 대비해 자주 쓰는 설정이나 프로그램에 대해 계속 업데이트 하려고 합니다.

## macOS 설정

현재 버전: `11.4 Big Sur`

* 트랙패드 세 손가락으로 드래그 설정: `손쉬운 사용` - `포인터 제어기` - `트랙패드 옵션` - `드래그 활성화`
* Dock 크기 조정: `Dock 및 메뉴 막대` - `크기`
* 블루투스 아이콘 보기: `Dock 및 메뉴 막대` - `Bluetooth` - `메뉴 막대에서 보기`
* 키보드
    * `F1, F2 등의 키를 표준 기능 키로 사용` 체크
    * 키 반복: 빠르게, 반복 지연 시간: 짧게
    * 텍스트
        * `자동으로 문장을 대문자로 시작` 체크 해제
        * `스페이스를 두 번 눌러 마침표 추가` 체크 해제
    * 단축키
        * Spotlight: `키보드` - `단축키` - `Spotlight` - `Spotlight 검색보기` 체크 해제
        * 입력 소스: `키보드` - `단축키` - `입력 소스` - `이전 입력 소스 선택` 체크 해제
        * 서비스: `터미널에서 man 페이지 인덱스 검색 체크` 해제

## Applications

* [iTerm2](https://iterm2.com/): 터미널
* [Homebrew](https://brew.sh/index_ko): macOS용 패키지 관리자
    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
* [oh my zsh](https://github.com/ohmyzsh/ohmyzsh): zsh 확장버전
* [Alfred](https://www.alfredapp.com/): 키보드로 제어
* [Clipy](https://clipy-app.com/): 클립보드 관리
* [IINA](https://iina.io/): 동영상 플레이어
* [Bear](https://apps.apple.com/us/app/bear-beautiful-writing-app/id1091189122?ls=1&mt=12): 마크다운 에디터

## IntelliJ IDEA

현재 버전: `2021.1.3 Ultimate Edition`

* 코드 자동완성 대문자/소문자 구분 끄기
    * `Preferences` - `Editor` - `General` - `Code Completion` - `Match case` 체크 해제
* 플러그인 설치
    * .ignore (4.1.0)
    * AsciiDoc (0.33.6)
    * Atom Material Icons (36.0)
    * Key Promoter X (2021.1.1)
    * Kubernetes (211.7442.27)
    * Maven Helper (4.13.203.000.0)
    * One Dark theme (5.1.6)
    * PlantUML integration (5.5.1)
    * Power Mode II (100.001)
    * Rainbow Brackets (6.18)

## Alfred
* 실행시 무조건 영어 입력: `Preferences` - `Advanced` - `Force Keyboard` - `ABC`

## git
* alias
    ```bash
    git config --global alias.au "commit --amend --author \"Jaime <lcalmsky@gmail.com>\""
    git config --global alias.co commit
    git config --global alias.st status
    git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr)%C(bold blue)<%an>%Creset' --abbrev-commit"
    git config --global alias.tree "log --graph --date-order --date=short --pretty=format:'%C(auto)%h%d %C(reset)%s %C'"
    ```
* user
  ```bash
  git config --global user.name Jaime
  git config --global user.email lcalmsky@gmail.com
  ```

---
작성중(2021/07/08 20:20)