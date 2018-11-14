/**
 *
 */
package com.student.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a
 *
 */
public class PrintStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Student studentOne = new Student();
		studentOne.setAge(3);
		studentOne.setBirthday("1979-60-30");
		studentOne.setClassid(6);
		studentOne.setId(16);
		studentOne.setName("張勇");
		studentOne.setScore(100);
		PrintStudent(studentOne);
		// int id, String name, String birthday, int age, int score, int classid
		// id name birthday age score classid
		// 2 qian 2007/06/05 10 80 1 ​​
		ArrayList<Student> studentList= new ArrayList<Student>();
		Student studentTwo = new Student(2, "qian", "2007-06-05", 10, 80, 1);
		Student studentThree = new Student(3, "sun", "2007-06-05", 10, 80, 1);
		Student studentFour = new Student(4, "qian", "2007-06-05", 10, 80, 1);
		PrintStudent(studentTwo);
		PrintStudent(studentThree);
		PrintStudent(studentFour);
		String StringFromTable1 = "001";
		String StringFromTable2 = "002";
		String BiaoDashi = StringFromTable1 + "/" + StringFromTable1;
		System.out.println("Min1Age+"+Min1Age(studentList));
	}

	/**
	 *
	 * @param studentOne（student
	 *            クラス） return なし
	 */
	private static void PrintStudent(Student stu) {
		System.out.println(stu.getAge());
		System.out.println(stu.getBirthday());
		System.out.println(stu.getClassid());
		System.out.println(stu.getName());
		System.out.println(stu.getScore());
		System.out.println(stu.getId());

	}
	private static int Min1Age(List<Student> StudentList) {
		// 最小年齢の初期化
		int minAge = 0;
		int num = 0;
		// Loop 最小値取得
		for (Student student : StudentList) {
			if (num == 0) {
				minAge = student.getAge();
				num++;
			} else {
				if (student.getAge() < minAge) {
					minAge = student.getAge();
				}
			}
		}
		// 算出した年齢を返す
		return minAge;
	}
}
