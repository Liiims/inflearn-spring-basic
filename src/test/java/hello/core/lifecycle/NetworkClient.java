package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 외부 네트워크에 미리 연결하는 객체를 하나 생성한다고 가정
 */
public class NetworkClient implements InitializingBean, DisposableBean {

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
     * 의존관계 주입이 끝난 후 호출되는 메서드 (초기화 지원)
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\n=== NetworkClient.afterPropertiesSet ===");
        connect();
        call("초기화 연결 메시지");
    }

    /**
     * 빈이 종료될 때 호출되는 메서드 (소멸 지원)
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("\n=== NetworkClient.destroy ===");
        disconnect();
    }
}
