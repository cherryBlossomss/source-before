package com.auch.sb.reflect;

import com.auch.sb.reflect.pojo.Human;
import com.auch.sb.reflect.pojo.User;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * <p>reflection</p>
 *
 * @author luohuiqi
 * @date 2023/6/5 11:15
 */
@Log
public class ClassTest {

    @Test
    @DisplayName("Class对象的获取")
    public void testGetClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        // 获取Class对象的三种方式
//        log.info("根据类名:  \t" + User.class);
//        log.info("根据对象:  \t" + new User("男").getClass());

        Class<?> userClass = Class.forName("com.auch.sb.reflect.pojo.Human");
        Object o = userClass.newInstance();
        Object o1 = userClass.newInstance();
        log.info("实例化o:" + o);
        log.info("实例化o1:" + o1);


        log.info("根据全限定类名:\t" + userClass);

//
//        Class<?> userClass = Class.forName("com.auch.sb.reflect.pojo.User");
//        log.info("根据全限定类名:\t" + userClass);
//        // 常用的方法
//        log.info("获取全限定类名:\t" + userClass.getName());
//        log.info("获取类名:\t" + userClass.getSimpleName());
    }

    @Test
    @DisplayName("依据class获取实例对象")
    public void testInstanceByClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");
        // 1.Class.newInstance 可根据无参构造来初始化对象
        Human human = (Human) humanClass.newInstance();
        log.info("human = " + human);
        // 2.Constructor.newInstance 根据构造函数初始化类
        Constructor<?> constructor = humanClass.getConstructor(String.class);
        Human human1 = (Human) constructor.newInstance("男性");
        log.info("human1 = " + human1);
    }

//    @Test
//    @DisplayName("Class获取类以及方法结构数据")
//    public void testMethodDataByClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Class<?> userClass = Class.forName("com.auch.sb.reflect.pojo.User");
//
//        userClass.getInterfaces()
//    }


    @Test
    @DisplayName("构造-构造函数")
    public void testConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        // getConstructors 获取构造函数，不包括private
        for (Constructor<?> constructor : humanClass.getConstructors()) {
            log.info("构造函数" + constructor.toString());
        }

        // getDeclaredConstructors 获取构造函数，包括private
        for (Constructor<?> constructor : humanClass.getDeclaredConstructors()) {
            log.info("声明构造函数" + constructor.toString());
        }

    }

    @Test
    @DisplayName("基础用法-构造函数")
    public void testUseConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        // 1.Constructor.newInstance 根据构造函数初始化类
        Constructor<?> constructor = humanClass.getConstructor(String.class);
        Human human1 = (Human) constructor.newInstance("男性");
        log.info("human1 = " + human1);
        Constructor<?> constructor001 = humanClass.getDeclaredConstructor(String.class, Integer.class);
        // 必须修改访问权限
        constructor001.setAccessible(true);
        Human human = (Human) constructor001.newInstance("男性", 111);
        log.info("human = " + human);

        //2. getDeclaringClass()	返回 Class 对象，该对象表示声明由此 Constructor 对象表示的构造方法的类,其实就是返回真实类型（不包含参数）
        log.info("真实对象" + constructor001.getDeclaringClass().getName());

        // 3.getGenericParameterTypes()	按照声明顺序返回一组 Type 对象，返回的就是 Constructor对象构造函数的形参类型。
        for (Type genericParameterType : constructor001.getGenericParameterTypes()) {
            log.info("构造函数形参" + genericParameterType.getTypeName());
        }

        // 4.getName()	以字符串形式返回此构造方法的名称。
        log.info("名称" + constructor001.getName());
        // getParameterTypes()	按照声明顺序返回一组 Class 对象，即返回Constructor 对象所表示构造方法的形参类型
        for (Class<?> parameterType : constructor001.getParameterTypes()) {
            log.info("构造函数形参" + parameterType.getTypeName());
        }

        //  5. toGenericString()	返回描述此 Constructor 的字符串，其中包括类型参数。
        log.info("构造函数形参" + constructor001.toGenericString());
    }

    @Test
    @DisplayName("构造 - 属性")
    public void testField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        Constructor<?> constructor001 = humanClass.getDeclaredConstructor(String.class, Integer.class);
        // 必须修改访问权限
        constructor001.setAccessible(true);

        // 非private属性
        for (Field field : humanClass.getFields()) {
            log.info("field = " + field.getName());
        }
        // 包括private 属性
        for (Field field : humanClass.getDeclaredFields()) {
            log.info("Declared Field = " + field.getName());
        }
        // 获取指定name名称的(包含private修饰的)字段，不包括继承的字段,而getField(String name)包含不包含private属性，但可获取到父类的非private属性
        Field gender = humanClass.getDeclaredField("gender");
        log.info("Gender = " + gender);
    }

    @Test
    @DisplayName("基础用法 - 属性")
    public void testUseField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        Constructor<?> constructor001 = humanClass.getDeclaredConstructor(String.class, Integer.class);
        // 必须修改访问权限
        constructor001.setAccessible(true);
        Human human = (Human) constructor001.newInstance("张三", 1222);

        // 获取指定name名称的(包含private修饰的)字段，不包括继承的字段,而getField(String name)包含不包含private属性，但可获取到父类的非private属性
        Field gender = humanClass.getDeclaredField("gender");

        // getType()	返回一个 Class 对象，它标识了此Field 对象所表示字段的声明类型。
        log.info("声明类型："+ gender.getType());

        // setAccessible(boolean flag)	将此对象的 accessible 标志设置为指示的布尔值,即设置其可访问性
        gender.setAccessible(true);

       //  set(Object obj, Object value)	将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
        gender.set(human,"女性");
        // get(Object obj)	返回指定对象上此 Field 表示的字段的值
        log.info("获取字段值："+gender.get(human).toString());

        // isEnumConstant()	如果此字段表示枚举类型的元素则返回 true；否则返回 false
        log.info("字段是否时枚举："+gender.isEnumConstant());
        // getName()	返回此 Field 对象表示的字段的名称
        log.info("字段名称："+gender.getName());
        // getDeclaringClass()	返回表示类或接口的 Class 对象，该类或接口声明由此 Field 对象表示的字段
        log.info("Class 对象"+gender.getDeclaringClass());
    }

    @Test
    @DisplayName("构造 - 方法")
    public void testMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        Constructor<?> constructor001 = humanClass.getDeclaredConstructor(String.class, Integer.class);
        // 必须修改访问权限
        constructor001.setAccessible(true);

        // 非private方法，包括继承的方法
        for (Method method: humanClass.getMethods()) {
            log.info("method = " + method.getName());
        }
        // getMethods()返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
       log.info("获取特定方法"+humanClass.getMethod("setAge", Integer.class));

        // 包括private 方法 ，不包括继承方法
        for (Method method:  humanClass.getDeclaredMethods()) {
            log.info("method = " + method.getName());
        }
        // getDeclaredMethods()返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        log.info("获取特定方法"+humanClass.getDeclaredMethod("setAge", Integer.class));


    }

    @Test
    @DisplayName("基础用法 - 方法")
    public void testUseMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> humanClass = Class.forName("com.auch.sb.reflect.pojo.Human");

        Constructor<?> constructor001 = humanClass.getDeclaredConstructor(String.class, Integer.class);
        // 必须修改访问权限
        constructor001.setAccessible(true);
        Object human = constructor001.newInstance("张三", 1222);

        // 获取指定name名称的(包含private修饰的)字段，不包括继承的字段,而getField(String name)包含不包含private属性，但可获取到父类的非private属性
        Method setAge = humanClass.getDeclaredMethod("setAge", Integer.class);
        // getName()	以 String 形式返回此 Method 对象表示的方法名称，即返回方法的名称
        log.info("方法名称："+setAge.getName());

        //isVarArgs()	判断方法是否带可变参数，如果将此方法声明为带有可变数量的参数，则返回 true；否则，返回 false。
        log.info("是否时可变参数："+setAge.isVarArgs());
        // toGenericString()	返回描述此 Method 的字符串，包括类型参数。
        log.info("描述数据："+setAge.toGenericString());

        Field age = humanClass.getDeclaredField("age");

        age.setAccessible(true);
        log.info("modify before age = " + age.get(human));
        //  todo 执行方法
        setAge.invoke(human,1111);
        log.info("modify after age = " + age.get(human));

        // getReturnType()	返回一个 Class 对象，该对象描述了此 Method 对象所表示的方法的正式返回类型,即方法的返回类型
        log.info("返回类型Class"+setAge.getReturnType());

        // getGenericReturnType()	返回表示由此 Method 对象所表示方法的正式返回类型的 Type 对象，也是方法的返回类型。
        log.info("返回类型Type"+setAge.getGenericReturnType());

        // getParameterTypes()	按照声明顺序返回 Class 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型。即返回方法的参数类型组成的数组
        Arrays.stream(setAge.getParameterTypes()).forEach(x -> log.info("参数类型Class[]"+x.getName()));

        // getGenericParameterTypes()	按照声明顺序返回 Type 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型的，也是返回方法的参数类型
        Arrays.stream(setAge.getGenericParameterTypes()).forEach(x -> log.info("参数类型Type[]"+x.getTypeName()));
    }
}
