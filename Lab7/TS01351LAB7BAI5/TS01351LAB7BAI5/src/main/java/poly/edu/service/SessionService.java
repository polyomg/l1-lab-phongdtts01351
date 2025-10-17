package poly.edu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Đọc giá trị của attribute trong session
     * @param <T> Kiểu dữ liệu của giá trị
     * @param name tên attribute
     * @param defaultValue giá trị mặc định
     * @return giá trị đọc được hoặc defaultValue nếu không tồn tại
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return value != null ? value : defaultValue;
    }

    /**
     * Thay đổi hoặc tạo mới attribute trong session
     * @param name tên attribute
     * @param value giá trị attribute
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Xóa attribute trong session
     * @param name tên attribute
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }
}