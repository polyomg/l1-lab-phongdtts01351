package poly.edu.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    HttpServletRequest request;

    // Lưu vào session
    public void set(String name, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    // Lấy từ session
    public Object get(String name) {
        HttpSession session = request.getSession();
        return session.getAttribute(name);
    }

    // Xóa session
    public void remove(String name) {
        HttpSession session = request.getSession();
        session.removeAttribute(name);
    }
}
