> `map.toString`을 검색해서 들어오시는 분들이 많은 거 같아 간단히 설명을 추가합니다.

`Map` 인터페이스의 구현체(대표적으로 `HashMap` 등)에서 `toString`을 호출하면 내부적으로 `Map`을 탐색하는 `Iterator`를 만들어 각 `Entry`를 `key=value` 형식의 문자열로 변환해줍니다.

```java
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("boolean", true);
        map.put("list", List.of("a", "b", "c"));
        map.put("integer", 1);
        map.put("String", "abc");
        System.out.println(map);
    }
}
```

이 소스 코드를 실행하면

```text
{boolean=true, integer=1, String=abc, list=[a, b, c]}
```

이런 결과가 출력됩니다.

`Map`은 중괄호(`{}`)로 표현하고, `List`는 대괄호(`[]`)로 표현합니다.

이는 각각 `Map`과 `List` 구현체의 `toString`을 따르기 때문입니다.

`Map` 안에 `Map`이나 `List`를 중첩해도 마찬가지로 표현됩니다.

`Map` 안에 커스텀 클래스를 포함하더라도 커스텀 클래스의 `toString`이 호출되어 출력됩니다.

예를 들어, 

```java
import java.util.*;

class Scratch {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        User user = new User("홍길동", 10, false);
        users.put(user.name, user);
        System.out.println(users);
    }

    private static class User {
        String name;
        int age;
        boolean isMarried;

        public User(String name, int age, boolean isMarried) {
            this.name = name;
            this.age = age;
            this.isMarried = isMarried;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("age=" + age)
                    .add("isMarried=" + isMarried)
                    .toString();
        }
    }
}
```

이렇게 커스텀 클래스 `User`를 작성(내부적으로 사용할 거라 `private static` 클래스로 정의하였고 `getter/setter` 등을 만들지 않았습니다)하고 기본적인 `toString`(보통 `IDE`에서 지원해주는)을 `override` 한 소스 코드가 있을 때, 이를 실행해보면,

```text
{홍길동=User[name='홍길동', age=10, isMarried=false]}
```

이렇게 출력되는 것을 확인할 수 있습니다.

`toString`을 따라 출력되는 형태가 변한다고 했으므로 `User`의 `toString`을 아래처럼 수정하면,

```java
@Override
public String toString() {
    return String.format("%s은(는) %d살이고 결혼을 %s습니다.", name, age, isMarried ? "했" : "안 했");
}
```

```text
{홍길동=홍길동은(는) 10살이고 결혼을 안 했습니다.}
```

이렇게 출력됩니다.

두 줄 요약:

- {key1=value2, key2=value2, ...} 형식으로 `Map` 안의 `Entry`가 출력됨(`LinkedHashMap`을 사용하면 `Entry`의 순서가 보장되어 출력) 
- `key`와 `value`는 각각의 타입(클래스)에서 구현한 `toString`을 이용해 문자열로 변환하여 출력됨

---

> 여기부터는 기존 본문으로 map.toString()을 통해 출력한 문자열을 다시 Map으로 만드는 과정입니다.

며칠 전 서버 로그를 분석하다가 `JSON` 포맷이 아닌 일반적인 `Map` 구현체의 `toString` 형태를 발견하게 되었습니다.

디버깅을 위해서나 로컬에서는 자주 확인할 수 있는 형식이죠.

```java
Map<String, Object> map = new HashMap<>();
map.put("boolean", true);
map.put("list", Arrays.asList("a", "b", "c"));
map.put("integer", 1);
map.put("String", "abc");
System.out.println(map);
```

간단히 위와 같은 소스 코드를 실행시켜보면

```text
{boolean=true, integer=1, String=abc, list=[a, b, c]}
```

이런 결과가 출력됩니다.

이렇게 단순한 경우엔 마치 `HTTP` 요청에서 `query parameter`를 파싱하듯이 ",", "=" 등을 이용해 키와 값 등을 구분할 수 있으나, 로그에서 저 부분만 긁어와서 `JSON` 형태로 변환하는 작업은 생각보다 쉽지가 않습니다.

특히 커스텀 클래스가 상속관계를 가지고 있어 출력형태가 위의 예시처럼 단순하지 않은 경우 도저히 파싱할 엄두가 안 나더군요.

사실 `map`을 출력하는 부분의 소스 코드를 수정하여 확인해도 되지만 이미 스테이징 환경에 배포되어있는 모듈의 로그라서 괜히 건드리고싶지 않았고, 단순 디버깅을 위해 직렬화/역직렬화를 하기엔 성능 이슈 또한 고려해야 했기에(로컬이었으면 바로 `ObjectMapper` 써서 출력했을텐데..) 다른 방법을 찾아야 했습니다.

찾아보니 `java.util.Properties`를 활용한 방법이 있었습니다.

`Properties`는 일반적으로 `key=value` 형식의 파일을 읽어 접근할 수 있는 인터페이스를 제공합니다.

이를 이용하면 위의 로그가 다시 `Properties`로 역직렬화 되고, `Properties`의 인터페이스를 활용한다면 얼마든지 편하게 로그의 데이터에 접근할 수 있습니다.

```
public static void main(String[] args) throws IOException {
    byte[] allBytes = Files.readAllBytes(Paths.get("filename");
    String str = new String(allBytes, StandardCharsets.UTF_8);
    Properties props = new Properties();
    props.load(new StringReader(str.substring(1, str.length() - 1).replace(", ", "\n")));
    Map<String, String> map = new HashMap<>();
    for (Map.Entry<Object, Object> e : props.entrySet()) {
        map.put((String) e.getKey(), (String) e.getValue());
    }
    System.out.println(map);
}
```

`Properties`로 불러온 뒤 `Properties`의 `entrySet`을 순차적으로 탐색하면서 `Map`에 다시 넣어주면 `Map` 인터페이스를 사용할 수 있습니다.

하지만 이 방법도 `List` 내부에 ','가 존재한다든지 복잡한 문자열에 대해선 제대로 파싱하지 못하더군요 ㅜㅜ

그냥 `ObjectMapper` 씁시다. (😹~두 번 씁시다~)