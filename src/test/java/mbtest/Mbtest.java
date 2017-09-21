package mbtest;

import cn.spmb.dao.Studentdao;
import cn.spmb.entity.StuIds;
import cn.spmb.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomcat on 2017/9/20.
 */
public class Mbtest {
    Studentdao studentdao=null;

    @Before
    public void setup() throws IOException {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        studentdao= (Studentdao) context.getBean("studentdao");
    }

    @Test
    public void test1() throws Exception {
        Student student = studentdao.findStuByid(10);
        System.out.println(student);

    }
    @Test
    public void testinsert() throws Exception {
       Student student=new Student();
       student.setNumber(134);
       student.setName("smm");
       student.setAge(18);
       student.setSex("female");
       student.setBirthday(new Date());
       student.setCid(5);
      studentdao.insertStu(student);
      System.out.println(student);

    }
    @Test
    public void test3() throws Exception {
        Student student=new Student();
        student.setCid(4);
        student.setAge(27);
        System.out.println(studentdao.findStuCount(student));
    }
    @Test
    public void test4() throws Exception {
        StuIds stuIds=new StuIds();
        List<Integer> list=new ArrayList<Integer>(Arrays.asList(10,14,18,19,22));
        stuIds.setIds(list);
        System.out.println(studentdao.findStByids(stuIds));
    }
}
