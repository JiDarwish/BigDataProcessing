package fp_practice

/**
 * In this part you can practice your FP skills with some small exercises.
 * Hint: you can find many useful functions in the documentation of the List class.
 *
 * This part is worth 15 points.
 */
object FPPractice {
  def main(args: Array[String]): Unit = {
    val list = List.range(0, 40)
    println(list)
    println(first10Above25(list))
  }

  /////////////////////////////////////////////////
  ////////////////////////////////// HELPER METHODS
  /////////////////////////////////////////////////
  def firstN(xs: List[Int], n: Int): List[Int] = xs match {
    case value :: tail => {
      if (n > 0) {
        return value :: firstN(tail, n - 1)
      } else {
        return List()
      }
    }

    case Nil => List()
  }

  def over25(xs: List[Int]): List[Int] = {
    return filter(xs, (value: Int) => value > 25)
  }

  def filter[A](xs: List[A], f: A => Boolean): List[A] = xs match {
    case value :: tail => {
      if (f(value)) {
        value +: filter(tail, f)
      } else {
        filter(tail, f)
      }
    }
    case Nil => List()
  }

  def sum(xs: List[Int]): Int = {

    xs match {
      case Nil => 0
      case i :: tail => i + sum(tail)
    }
  }
  def getListSize(list: List[Int]): Int = list match {
    case _ :: tail => 1 + getListSize(tail)
    case Nil => 0
  }

  /** Q13 (4p)
   * Returns the sum of the first 10 numbers larger than 25 in the given list.
   *
   * @param xs the list to process.
   * @return the sum of the first 10 numbers larger than 25.
   */
  def first10Above25(xs: List[Int]): Int = {
    val onlyOver25 = over25(xs)
    val only10itemsOver25 = firstN(onlyOver25, 10)
    return sum(only10itemsOver25)
  }


  /** Q14 (5p)
   * Provided with a list of all grades for each student of a course,
   * count the amount of passing students.
   * A student passes the course when the average of the grades is at least 5.75 and no grade is lower than 4.
   *
   * @param grades a list containing a list of grades for each student.
   * @return the amount of students with passing grades.
   */
  def passingStudents(grades: List[List[Int]]): Int =
    grades match {
      case student :: gradesTail => {
        if (sum(student) / getListSize(student) >= 5.75) {
          1 + passingStudents(gradesTail)
        } else {
          passingStudents(gradesTail)
        }
      }
      case Nil => 0
    }



  // TODO ask if you can use the functional methods that you made in here

  /** Q15 (6p)
   * Return the length of the first list of which the first item's value is equal to the sum of all other items.
   *
   * @param xs the list to process
   * @return the length of the first list of which the first item's value is equal to the sum of all other items,
   *         or None if no such list exists.
   *
   *         Read the documentation on the `Option` class to find out what you should return.
   *         Hint: it is very similar to the `OptionalInt` you saw earlier.
   */
  def headSumsTail(xs: List[List[Int]]): Option[Int] = xs match {
    case listInts :: tail =>
      if (sum(listInts) - listInts(0) == listInts(0)) Some(getListSize(listInts)) else headSumsTail(tail)
    case Nil => None
  }

}
