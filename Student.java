import java.util.Scanner;

class StudentClass {
  String name;
  double[] score = new double[3];

  public StudentClass(double test1, double test2, double test3, String s) {
    this.name = s;
    this.score[0] = test1;
    this.score[1] = test2;
    this.score[2] = test3;
  }

  public StudentClass(String s) {
    this.name = s;
    for (int i = 0; i < score.length; i++) {
      score[i] = 0;
    }
  }

  public void setTestScore(int testNum, double score) {
    this.score[testNum - 1] = score;
  }

  public double getTestScore(int testNum) {
    return this.score[testNum - 1];
  }

  public double getAverage() {
    double result = 0;
    for (double d : this.score) {
      result += d;
    }
    return result / (double) 3;
  }

}

public class Student {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the name:");
    String name = scanner.nextLine();
    System.out.println("If you know the three test scores, enter 1.");
    while (!scanner.hasNextInt())
      scanner.next();
    int userInput = scanner.nextInt();
    StudentClass student;
    if (userInput == 1) {
      System.out.println("Enter the three test scores:");
      while (!scanner.hasNextDouble())
        scanner.next();
      double test1 = scanner.nextDouble();
      while (!scanner.hasNextDouble())
        scanner.next();
      double test2 = scanner.nextDouble();
      while (!scanner.hasNextDouble())
        scanner.next();
      double test3 = scanner.nextDouble();
      student = new StudentClass(test1, test2, test3, name);
    } else {
      student = new StudentClass(name);
    }
    System.out.println("Enter 1 to change a test score.");
    while (!scanner.hasNextInt())
      scanner.next();
    userInput = scanner.nextInt();
    if (userInput == 1) {
      System.out.println("Enter the test score to change:");
      while (!scanner.hasNextInt())
        scanner.next();
      int testChange = scanner.nextInt();
      System.out.println("Enter the new score:");
      while (!scanner.hasNextDouble())
        scanner.next();
      double newScore = scanner.nextDouble();
      student.setTestScore(testChange, newScore);
    }
    System.out.println("Enter 1 to view a test score.");
    while (!scanner.hasNextInt())
      scanner.next();
    userInput = scanner.nextInt();
    if (userInput == 1) {
      System.out.println("Enter the test score to view:");
      while (!scanner.hasNextInt())
        scanner.next();
      int testScore = scanner.nextInt();
      System.out.println(student.getTestScore(testScore));
    }
    System.out.println("Average " + student.getAverage());
    System.out.println();
  }
}