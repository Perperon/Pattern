package com.perperon.pattern;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.perperon.utils.BaseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dupengcheng
 * @date 2024-03-22
 * @apiNote
 */
@SpringBootTest
public class CollectionTest {

    @Test
    public void test(){

        String url = "jdbc:mysql://192.168.11.51:6019/mrtcloud?SSL=true";
        String username = "root";
        String password = "#7VCg1K_19F#";
        /*String url = "jdbc:mysql://localhost:3306/mrtcloud_myzy?SSL=true";
        String username = "root";
        String password = "root";*/

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 创建PreparedStatement对象
            String sql = "select DISTINCT a.id,\n" +
                    "                        a.staff_id,\n" +
                    "                        a.username,\n" +
                    "                        a.hospital_id\n" +
                    "        from kb_accounts a,\n" +
                    "             kb_roles r,\n" +
                    "             kb_account_role ar\n" +
                    "        WHERE ar.account_id = a.id\n" +
                    "          and ar.role_id = r.id\n" +
                    "          and a.`username` != 'admin' \n" +
                    "          AND r.`code` not in ('DeptManager11','StudentType_gps','superadmin','DeptManager')\n" +
                    "          AND a.hospital_id = 'c77e18b0-1ffa-11e7-b036-00163e0603fa'";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            List<Map<String, Object>> dataList = resultSetToList(resultSet);
            JSONArray jsonArray = JSONUtil.parseArray(dataList);
            //String s = objectMapper.writeValueAsString(dataList);
            System.out.println(jsonArray.toString());
            String updateSql = "UPDATE kb_accounts SET password = ? WHERE id = ?";
            PreparedStatement preparedStatement  = connection.prepareStatement(updateSql);
            for (Map<String, Object> map : dataList) {
                preparedStatement.setString(1, BaseUtil.getEncryption(map.get("username").toString()));
                preparedStatement.setString(2, map.get("id").toString());
                // 执行更新
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("更新成功");
                }
            }
            // 关闭资源
            preparedStatement.close();
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
        }
    }


    public List<Map<String, Object>> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();

        if (resultSet != null) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    rowMap.put(columnName, columnValue);
                }
                list.add(rowMap);
            }
        }

        return list;
    }
}
