package poly.edu.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    // Đọc cookie
    public String getValue(String name, String defaultValue) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c.getValue();
                }
            }
        }
        return defaultValue;
    }

    // Tạo cookie (thêm vào response)
    public Cookie add(String name, String value, int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 3600); // tính bằng giây
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }

    // Xóa cookie
    public void remove(String name) {
        add(name, "", 0);
    }
}