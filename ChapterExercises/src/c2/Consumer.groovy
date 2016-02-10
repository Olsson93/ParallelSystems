package c2
 
import phw.util.*
import org.jcsp.lang.*


class Consumer implements CSProcess {
  
  def ChannelInput inChannel
  
  void run() {
    def i = 1
    while ( i > 0 ) {
		i = inChannel.read()
		println "the output is : ${i}"
      //insert a modified println statement
      
    }
    println "Finished"
  }
}

