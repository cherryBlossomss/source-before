package com.auch.sb.reflect.pojo;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/6/5 11:04
 */
public class User extends Human implements School,Company {

    private final String id;

    private final String name;

    private final String schoolName;

    private  final  String companyName;


    public User(String gender) {
        super(gender);
        this.id = "001";
        this.name = "张三";
        this.schoolName="岷县二中";
        this.companyName = "超人贷";
    }

    @Override
    public String getComanyName() {
        return companyName;
    }

    @Override
    public String getSchoolName() {
        return schoolName;
    }
}
