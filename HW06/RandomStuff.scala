trait RandomStuffTrait{
	def transform(list: List[Int], op:(Int) => Int) : List[Int]
	def allValid(list: List[Int], op:(Int) => Boolean) : Boolean
	def executeWithRetry(retryCount: Int, op: => Int) : Option[Int] 
}
object RandomStuff extends RandomStuffTrait {
	def transform(list: List[Int], op:(Int) => Int) : List[Int] = {
		list map op
	}
	def allValid(list: List[Int], op:(Int) => Boolean) : Boolean = {
		list forall op
	}
	def executeWithRetry(retryCount: Int, op: => Int) : Option[Int] = {

		if (retryCount == 0) {
      		None
    	} else {
      		try {
        		Some[Int](op)
      		} catch {
        		case e: Exception => {
        			executeWithRetry(retryCount - 1, op)	
        		}
      		}
    	}
	}

}