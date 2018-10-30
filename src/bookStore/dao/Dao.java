package bookStore.dao;

import java.util.List;

public interface Dao<T> {
    /**
     *执行Insert操作，返回插入后记录的Id
     * @param sql:执行的sql语句
     * @param args：填充占位符的可变参数
     * @return 插入新纪录的Id
     */
    long insert(String sql,Object...args);

    /**
     * 执行UPDATE操作，包括Insert（但没有返回值），UPDATE，DELETE
     * @param sql：待执行的sql语句
     * @param args：填充占位符的可变参数
     */
    void update(String sql,Object...args);

    /**
     * 执行单条记录的查询操作，返回与记录对应的一个类的List
     * @param sql:待执行的sql语句
     * @param args：填充占位符的可变参数
     * @return 与记录对应的一个对一项
     */
    T query(String sql,Object...args);
    /**
     * 执行多条记录的查询操作，返回与记录对应的一个类的list
     * @param sql:待执行的sql语句
     * @param args：填充占位符的可变参数
     * @return ：与记录对应的类的一个List
     */
    List<T> queryForList(String sql,Object...args);

    /**
     *执行一个属性或值的查询操作，例如查询某一条记录的一个字段，或查询某个统计的信息，返回要查询的值
     * @param sql：待执行的sql语句
     * @param args：填充占位符的可变参数
     * @return 返回一个不同属性的值的类的实例
     */
    <V>V getSingleVal(String sql,Object...args);

    /**
     * 执行批量的更新操作
     * @param sql：待执行的sql语句
     * @param params 填充占位符的可变参数
     */

    void batch(String sql,Object[]...params);

}
