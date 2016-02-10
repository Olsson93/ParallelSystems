package c2

import org.jcsp.lang.*
 
class Multiplier implements CSProcess {
  
  def ChannelOutput outChannel
  def ChannelInput inChannel
  def int factor = 4
  
  void run() {
    def i = 1
    while (i > 0) {
    i = inChannel.read()
	outChannel.write(i*factor)
      // read in the next value of i
    }
    
  }
}

    
