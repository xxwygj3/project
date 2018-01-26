package com.sbtest.projectjdbc.common;

import java.util.List;

public interface BaseDao<T> {
    int insert(T entity);

    int updateByUniqueKey(T entity);

    List<T> selectList(BaseQuery query);

    List<T> pagingSelectList(BaseQuery query);

    List<T> select4Update(BaseQuery query);

    T selectSingle(BaseQuery query);

    int selectCount(BaseQuery query);

    int selectSequence();

    int deleteByUniqueKey(String key);
}
