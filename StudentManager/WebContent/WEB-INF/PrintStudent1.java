/**
 *
 */

package com.student.bean;
import java.util.ArrayList;
import java.util.List;
/**
 * 学生情報表示する
 */

/**
 * @author q2617
 *
 */
public class PrintStudent1 {

	// プログラムはMainファクションから起動します
	public static void main(String[] args) {
		// Student対象を作成します
		Student studentOne = new Student();
		studentOne.setId(1);
		studentOne.setName("ming");
		studentOne.setBirthday("1990/10/10");
		studentOne.setAge(20);
		studentOne.setScore(90);
		studentOne.setClassid(1);

		System.out.println(studentOne);
		System.out.println(studentOne.getId());
		Student studentTwo = new Student(2,"sun","1988/01/10",20,2,1);
		Student studentThree = new Student(3,"xi","1948/01/10",50,2,1);

		// studentリストを作成
		List<Student> StudentList = new ArrayList<>();
		StudentList.add(studentOne);
		StudentList.add(studentTwo);
		StudentList.add(studentThree);
		// studentリストを「学生の年齢算出Method」に渡して
		// 「学生の年齢算出Method」を呼び出して
		// 学生年齢の最大値を取得
		int MaxStudentAge = CalculatteAge(StudentList);
		int MinStudentAge = Min1Age(StudentList);
		double AvgeStudentAge = Aveage(StudentList);
		System.out.println("年齢一番年上の学生の年齢：" + MaxStudentAge);
		System.out.println("年齢一番年下の学生の年齢：" + MinStudentAge);
		System.out.println("平準年齢：" + AvgeStudentAge);


	}

	/**
	 * 学生の年齢算出Method 学生一覧のリストから年齢最大の学生の年齢を取得
	 *
	 * @param StudentList
	 * @return 年齢最大の学生の年齢
	 */
	public static int CalculatteAge(List<Student> StudentList) {
		// 最大年齢の初期化
		int maxAge = 0;
		// Loop 最大値取得
		for (Student student : StudentList) {
			if (student.getAge() > maxAge) {
				maxAge = student.getAge();
			}
		}
		// 算出した年齢を返す
		return maxAge;
	}

	public static int Min1Age(List<Student> StudentList) {
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

	public static double Aveage(List<Student> StudentList) {
		// 最合计齢の初期化
		double sumAge = 0;
		// Loop 最合计値取得
		for (Student student : StudentList) {

			sumAge = (sumAge + student.getAge());

		}
		// 算出した年齢を返す
		return  (sumAge  / StudentList.size());
	}
}
