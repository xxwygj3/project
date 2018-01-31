package com.sbtest.projectjdbc.test.list;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 列表学习计划
 * 为了是某个对象能使用串行化进行存储，其类必须实现Serializable
 * 在Serializable接口中没有任何方法，它只是表明，该对象可以转换为串行化表示形式。
 */
public class ProgramOfStudy implements Iterable<Course>, Serializable{
    private List<Course> list;

    public ProgramOfStudy() {
        list = new LinkedList<Course>();
    }

    /**
     * 插入新课程
     * @param course
     */
    public void addCourse(Course course){
        if(course != null){
            list.add(course);
        }
    }

    /**
     * 根据课程代号和课程编码查找课程
     * @param prefix
     * @param number
     * @return
     */
    public Course find(String prefix,int number){
        for(Course course:list){
            if(prefix.equals(course.getPrefix()) && number == course.getNumber()){
                return course;
            }
        }
        return null;
    }

    /**
     * 在指定课程后插入新课程
     * @param target
     * @param newCourse
     */
    public void addCourseAfter(Course target,Course newCourse){
        if(target == null || newCourse == null){
            return;
        }
        int targetIndex = list.indexOf(target);
        if(targetIndex != -1){
            list.add(targetIndex+1,newCourse);
        }
    }

    /**
     * 指定课程替换成新课程
     * @param target
     * @param newCourse
     */
    public void replace(Course target,Course newCourse){
        if(target == null || newCourse == null){
            return;
        }
        int targetIndex = list.indexOf(target);
        if(targetIndex != -1){
            list.set(targetIndex,newCourse);
        }
    }

    public String toString(){
        String result = "";
        for(Course course:list){
            result += course.getPrefix()+" "+course.getNumber()+" "+course.getTitle()+" "+course.getGrade()+ "\n";
        }
        return result;
    }

    @Override
    public Iterator<Course> iterator() {
        return list.iterator();
    }

    /**
     * 保存
     * @param fileName
     * @throws IOException
     */
    public void save(String fileName) throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * 加载
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ProgramOfStudy load(String fileName) throws IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProgramOfStudy pos = (ProgramOfStudy)ois.readObject();
        ois.close();
        return pos;
    }

    public static void main(String[] args) throws IOException {
        ProgramOfStudy pos = new ProgramOfStudy();
        pos.addCourse(new Course("CS",101,"Introduction to Programming","A-"));
        pos.addCourse(new Course("ARCH",305,"Building Analysis","A"));
        pos.addCourse(new Course("GRE",210,"Intermediate German"));
        pos.addCourse(new Course("CS",320,"Computer Architecture"));
        pos.addCourse(new Course("THE",201,"The Theatre Experience"));

        Course arch = pos.find("CS",320);
        pos.addCourseAfter(arch,new Course("CS",321,"Operating Systems"));

        Course theatre = pos.find("THE",201);
        theatre.setGrade("A-");

        Course german = pos.find("GRE",210);
        pos.replace(german,new Course("FRE",110,"Beginning French","B+"));

        System.out.println(pos);

        pos.save("ProgramOfStudy");
    }
}
