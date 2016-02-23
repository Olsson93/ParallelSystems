package c4


import org.jcsp.lang.*
import org.jcsp.groovy.*

class ResetSuccessor implements CSProcess {
	  
  def ChannelInput  inChannel
  def ChannelInput  resetChannel
  def ChannelOutput outChannel
	  
  void run () {
    def guards = [ resetChannel, inChannel  ]
    def alt = new ALT ( guards )
	while (true) {
		
		def i= alt.priSelect()
		if( i ==0)
		{
			inChannel.read()
			outChannel.write(resetChannel.read())
		}
		else
		{
			outChannel.write(inChannel.read()+1)
		}
	  // deal with inputs from resteChannel and inChannel
	  // use a priSelect
	}
  }
}
