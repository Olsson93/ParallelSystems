package c3 
 
import org.jcsp.lang.*

class Negator implements CSProcess {
  
  def ChannelInput inChannel
  def ChannelOutput outChannel
  
  void run () {
    while (true) {
		outChannel.write(inChannel.read()*-1)
      //output the negative of the input value
    }
  }
}
