class IyteImmutableList(val head: Int, val tail: HelperList) extends HelperList {
  override def toString: String = {
    var str = head + "," + tail
    if(str.endsWith(",")) str.substring(0,str.length()-1)
    else str
  }
}
abstract class HelperList {
  def head: Int
  def tail: HelperList
  def add(item: Int): HelperList = new IyteImmutableList(item, this)
}
object Nill extends HelperList {
  def head: Nothing = throw new Exception("Can't index head")
  def tail: HelperList = throw new Exception("Can't index tail")
  override def toString =  ""
}
object IyteImmutableList {
  def apply(): HelperList = Nill
}
