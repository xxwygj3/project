package com.sbtest.projectjdbc.test.list;

import java.io.Serializable;

/**
 * 课程类
 */
public class Course implements Serializable {
    private String prefix;//简称
    private int number;//编号
    private String title;//标题
    private String grade;//等级

    public Course(String prefix, int number, String title, String grade) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        if (grade == null) {
            this.grade = "";
        } else {
            this.grade = grade;
        }
    }

    public Course(String prefix, int number, String title) {
        this(prefix, number, title, "");
    }

    public String getPrefix() {
        return prefix;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 取得,返回true
     *
     * @return
     */
    public boolean taken() {
        return !grade.equals("");
    }

    /**
     * 是否符合课程要求
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Course) {
            Course otherCourse = (Course) other;
            if (prefix.equals(otherCourse.getPrefix()) && number == otherCourse.getNumber()) {
                return true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = prefix + " " + number + ": " + title;
        if (!grade.equals("")) {
            result += " [" + grade + "]";
        }
        return super.toString();
    }
}
