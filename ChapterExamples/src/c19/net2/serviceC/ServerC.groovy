package c19.net2.serviceC

import org.jcsp.lang.*
import org.jcsp.net2.*;
import org.jcsp.net2.tcpip.*
import org.jcsp.groovy.*
import netObjects.*
def serverIP = "127.0.0.1"
// each service is located at a different port 	
def CServerAddress = new TCPIPNodeAddress(serverIP, 6789)
Node.getInstance().init(CServerAddress)
def initialChannel = NetChannel.numberedNet2One(1)
while (true) {
	def request = initialChannel.read()
	def processSendChannel =NetChannel.one2net(request.processReceiveLocation)
	def cProcess = new Cprocess()
	processSendChannel.write(cProcess)		
}
