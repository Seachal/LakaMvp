package com.laka.lakamvp;

import com.laka.lakamvp.kotlinlearn.bean.A;
import com.laka.lakamvp.kotlinlearn.bean.B;
import com.laka.lakamvp.kotlinlearn.bean.Course;
import com.laka.lakamvp.kotlinlearn.bean.School;
import com.laka.lakamvp.kotlinlearn.bean.Student;
import com.laka.lakamvp.kotlinlearn.bean.Teacher;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test1() {
        final Timer timer = new Timer(true);
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
               System.out.println("------------------------------------");
            }
        };
        timer.schedule(timerTask,100,100);
    }


}