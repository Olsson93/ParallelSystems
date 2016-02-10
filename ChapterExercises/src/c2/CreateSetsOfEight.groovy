package c2

import org.jcsp.lang.*

class CreateSetsOfEight implements CSProcess{
	
	def ChannelInput inChannel

	void run(){
		def outList = []
		def v = 1
		while (v != -1){
			for ( i in 0 .. 7 ) {
				v = inChannel.read()
				if(v==-1)
				{
					return
				}
				outList[i]=v
				// put v into outList and read next input
			}
			println " Eight Object is ${outList}"
		}
		println "Finished"
	}
}