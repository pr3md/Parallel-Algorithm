/**
  * Created by sreeram on 10/24/16.
  */
object heapsort {
  def left(i: Int) = (2*i) + 1                    //> left: (i: Int)Int
  def right(i: Int) = left(i) + 1                 //> right: (i: Int)Int
  def parent(i: Int) = (i - 1) / 2                //> parent: (i: Int)Int

  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val t = a(i)
    a(i) = a(j)
    a(j) = t
  }                                         //> swap: (a: Array[Int], i: Int, j: Int)Unit

  def maxHeap (a: Array[Int], i: Int, size: Int): Unit = {
    val l = left(i)
    val r = right(i)
    var m = -1
    m = if (l < size && a(l) > a(i)) {l} else {i}
    m = if (r < size && a(r) > a(m)) {r} else {m}
    if (m != i) {
      swap(a, i, m)
      maxHeap(a, m, size)
    }
  }                                         //> maxHeap: (a: Array[Int], i: Int, size: Int)Unit

  def buildMaxHeap (a: Array[Int], size: Int): Unit = {
    println(s"$a -> $size")
    val hs = size / 2
    for (i <- 0 to hs) {
      println(s"i -> $i")
      maxHeap(a, hs - i, size)
    }
  }                                         //> buildMaxHeap: (a: Array[Int], size: Int)Unit

  def heapSort (a: Array[Int]) {
    buildMaxHeap(a, a.length)
    for (i <- (0 until a.length).reverse) {
      swap(a, 0, i)
      maxHeap(a, 0, i)
    }
  }

  val data = Array (1,0,2,9,3,8,4,7,5,6)
  heapSort (data)
  data
}