package poly.edu.dao;

import poly.edu.entity.Category;

public interface Report {
    Category getGroup(); // Tên phương thức khớp với alias 'group' trong query
    Double getSum();     // Khớp với alias 'sum'
    Long getCount();     // Khớp với alias 'count'
}