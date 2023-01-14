package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * 외부 네트워크에 미리 연결하는 객체를 하나 생성한다고 가정
 */
public class NetworkClient {

    private String url; // 접속할 서버의 url

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    /**
     * 빈 등록 초기화 메서드
     */
    @PostConstruct
    public void init() {
        System.out.println("\n === NetworkClient.init ===");
        connect();
        call("초기화 연결 메시지");
    }

    /**
     * 빈 소멸 메서드
     */
    @PreDestroy
    public void close() {
        System.out.println("\n === NetworkClient.close ===");
        disconnect();
    }
}
